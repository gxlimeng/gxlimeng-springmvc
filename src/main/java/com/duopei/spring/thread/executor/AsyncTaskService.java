package com.duopei.spring.thread.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	@Async // @Async表示改方法为异步方法，这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
	public void executorAsyncTask(Integer i) {
		System.out.println(Thread.currentThread().getName() + " 异步任务=" + i);
	}

	@Async
	public void executorAsyncTaskPlus(Integer i) {
		System.out.println(Thread.currentThread().getName() +" 异步任务+1=" + (++i));
	}
}
