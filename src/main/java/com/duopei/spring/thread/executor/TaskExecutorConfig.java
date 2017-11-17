package com.duopei.spring.thread.executor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * 当一个任务通过execute(Runnable)方法欲添加到线程池时：
1、如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
2、如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
3、如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
4、如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
5、当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
 * 
 * @author GXLIMENG
 *
 */
@Configuration
@ComponentScan("com.duopei.gxlimeng.spring.thread.executor")
@EnableAsync // @EnableAsync开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer { // 配置实现类

	// 返回一个线程池
	@Override
	public Executor getAsyncExecutor() { // 重写方法后返回一个ThreadPoolTaskExecutor，这样就获得到一个基于线程池的TaskExecutor(任务执行器)
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(10); // 线程池维护线程的最大数量 
		taskExecutor.setCorePoolSize(5); // 线程池维护线程的最少数量
		taskExecutor.setQueueCapacity(25); // 线程池所使用的缓冲队列
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
