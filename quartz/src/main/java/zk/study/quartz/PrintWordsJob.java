package zk.study.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wanggenshen
 * Date: on 2018/7/7 16:28.
 * Description: 打印任意内容
 */
public class PrintWordsJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            if(MyScheduler.flag<10){
                Thread.sleep(100,999999);
            }
            BigInteger


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (MyScheduler.lock){ MyScheduler.count++;}
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
//        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));

    }
}
