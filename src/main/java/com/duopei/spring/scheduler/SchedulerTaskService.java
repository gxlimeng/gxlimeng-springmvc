package com.duopei.spring.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerTaskService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedDelay = 5000) // @Scheduled表明改方法为计划任务
	public void reportCurrentTime(){
		System.out.println(" 每隔五秒执行一次："+ dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0 37 08 ? * *")
	public void fixTimeExecution(){
		System.out.println(" 在指定时间执行："+ dateFormat.format(new Date()));
	}
	
}
