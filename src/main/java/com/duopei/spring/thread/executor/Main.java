package com.duopei.spring.thread.executor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskService asyncTaskService = ctx.getBean(AsyncTaskService.class);
		for (int i = 0; i < 10; i++) { // 结果并不是按顺序的
			asyncTaskService.executorAsyncTask(i);
			asyncTaskService.executorAsyncTaskPlus(i+100);
		}
		ctx.close();
	}
}
