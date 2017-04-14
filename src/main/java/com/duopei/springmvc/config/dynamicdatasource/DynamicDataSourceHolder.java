package com.duopei.springmvc.config.dynamicdatasource;

/**
 * 数据源管理器
 */
public class DynamicDataSourceHolder {


    public static final ThreadLocal<String> holder = new ThreadLocal<>();

    /**
     * 标记为写数据源
     */
    public static void markWrite() {
        holder.set(DataSourceType.write);
    }

    /**
     * 标记为读数据源
     */
    public static void markRead() {
        holder.set(DataSourceType.read);
    }

    /**
     * 重置
     *
     * @author
     */
    public static void reset() {
        holder.set(null);
    }


    /**
     * 获取数据源
     *
     * @return
     */
    public static String get() {
        return holder.get();
    }

}
