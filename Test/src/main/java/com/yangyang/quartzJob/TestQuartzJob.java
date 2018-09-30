package com.yangyang.quartzJob;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by yangyang on 2018/9/29.
 */
@DisallowConcurrentExecution
public class TestQuartzJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(TestQuartzJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("TestQuartzJob Begin....");
        excuteQuartzJob();
        logger.debug("TestQuartzJob end...");

    }

    private void excuteQuartzJob() {
     //   System.out.println("执行定时任务TestQuartzJob，当前时间是" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
