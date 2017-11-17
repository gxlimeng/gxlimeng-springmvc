package com.duopei.spring.scheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.duopei.gxlimeng.spring.scheduler")
@EnableScheduling // 开启对计划任务的支持
public class SchedulerConfig {

}
