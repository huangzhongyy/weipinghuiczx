package com.cssl.myquartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: weipinghuiczx
 * @Date: 2019/8/7 10:16
 * @Author: Mr.Deng
 * @Description:
 */
//@Configuration
public class QuartzConfig {

 // 创建任务
  @Bean
  public JobDetail uploadTaskDetail() {
   return JobBuilder.newJob(NumberWarning.class).withIdentity("NumberWarning").storeDurably().build();
  }

 /**
  *   支持并发
  */
 // 定时器
 @Bean
 public Trigger uploadTaskTrigger() {
  // 定义规则
  CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("30 1/1 * * * ? *");
  return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
   .withIdentity("NumberWarning")
   .withSchedule(scheduleBuilder)
   .build();
 }

}
