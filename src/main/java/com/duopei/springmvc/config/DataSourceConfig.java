package com.duopei.springmvc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.duopei.springmvc.config.dynamicdatasource.DataSourceType;
import com.duopei.springmvc.config.dynamicdatasource.DynamicDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/24.
 //
 */
@MapperScan("com.duopei.springmvc")
@Configuration
/**
 * 启用注解事务管理，使用CGLib代理
 * 基于注解的事务，当注解中发现@Transactional时，使用id为“transactionManager”的事务管理器
 * 如果没有设置transaction-manager的值，则spring以缺省默认的事务管理器来处理事务，默认事务管理器为第一个加载的事务管理器
 */
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment environment;

    /**
     * 配置DruidDataSource数据源
     *
     * @return
     * @throws SQLException
     */
    @Bean(name=DataSourceType.read,destroyMethod = "close", initMethod = "init")
    public DruidDataSource readDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        // 基本属性 url、user、password
        dataSource.setUrl(environment.getProperty("read.db.url"));
        dataSource.setUsername(environment.getProperty("read.db.username"));
        dataSource.setPassword(environment.getProperty("read.db.password"));

        // 通常来说，只需要修改initialSize、minIdle、maxActive
        dataSource.setInitialSize(Integer.valueOf(environment.getProperty("read.db.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(environment.getProperty("read.db.minIdle")));
        dataSource.setMaxActive(Integer.valueOf(environment.getProperty("read.db.maxActive")));

        dataSource.setMaxWait(60000); // 配置获取连接等待超时的时间
        dataSource.setTimeBetweenEvictionRunsMillis(60000); // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000); // 配置一个连接在池中最小生存的时间，单位是毫秒

        dataSource.setValidationQuery("SELECT 'X' ");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        // 打开PSCache，并且指定每个连接上PSCache的大小.如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false。分库分表较多的数据库，建议配置为false
        dataSource.setPoolPreparedStatements(false);
        dataSource.setMaxOpenPreparedStatements(20);

        // 配置监控统计拦截的filters
        //dataSource.setFilters("stat");
        return dataSource;
    }


    @Bean(name=DataSourceType.write, destroyMethod = "close", initMethod = "init")
    public DruidDataSource writeDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        // 基本属性 url、user、password
        dataSource.setUrl(environment.getProperty("write.db.url"));
        dataSource.setUsername(environment.getProperty("write.db.username"));
        dataSource.setPassword(environment.getProperty("write.db.password"));

        // 通常来说，只需要修改initialSize、minIdle、maxActive
        dataSource.setInitialSize(Integer.valueOf(environment.getProperty("write.db.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(environment.getProperty("write.db.minIdle")));
        dataSource.setMaxActive(Integer.valueOf(environment.getProperty("write.db.maxActive")));

        dataSource.setMaxWait(60000); // 配置获取连接等待超时的时间
        dataSource.setTimeBetweenEvictionRunsMillis(60000); // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000); // 配置一个连接在池中最小生存的时间，单位是毫秒

        dataSource.setValidationQuery("SELECT 'X' ");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        // 打开PSCache，并且指定每个连接上PSCache的大小.如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false。分库分表较多的数据库，建议配置为false
        dataSource.setPoolPreparedStatements(false);
        dataSource.setMaxOpenPreparedStatements(20);

        // 配置监控统计拦截的filters
        //dataSource.setFilters("stat");
        return dataSource;
    }

    /**
     * 配置多数据源映射
     */
    @Bean
    public DynamicDataSource multipleDataSource() throws SQLException {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> multDataSource = new HashMap<Object,Object>();
        multDataSource.put(DataSourceType.read,readDataSource());
        multDataSource.put(DataSourceType.write,writeDataSource());
        dynamicDataSource.setTargetDataSources(multDataSource);
        dynamicDataSource.setDefaultTargetDataSource(readDataSource());
        return dynamicDataSource;
    }


    /**
     * 配置事务管理器
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSourceTransactionManager txManager() throws SQLException {
        //return new DataSourceTransactionManager(dataSource());
        return new DataSourceTransactionManager(multipleDataSource());
    }



    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(multipleDataSource());

        sessionFactory.setPlugins(new Interceptor[]{pageHelper()});// 添加分页插件pageHelper

        return sessionFactory.getObject();
    }

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
