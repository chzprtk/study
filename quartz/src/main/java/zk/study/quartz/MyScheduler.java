package zk.study.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by wanggenshen
 * Date: on 2018/7/7 16:31.
 * Description: XXX
 */
public class MyScheduler {

    public static int flag=0;
    public static int count=0;
    public static Object lock=new Object();

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1").build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMilliseconds(1)//每隔1s执行一次

                        .repeatForever()).build();//一直执行

        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);

        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        //睡眠
        TimeUnit.SECONDS.sleep(1);
        System.out.println(count);
        while(true){
            TimeUnit.SECONDS.sleep(1);
            synchronized (lock){
            System.out.println(1000.0/count+" "+count);
            count=0;
            flag++;

//                scheduler.unscheduleJob(trigger.getKey());
            if(count==1000){
                break;
            }
            }
        }
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");


    }
}

