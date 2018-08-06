package com.yangyang.threadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yangyang on 2018/8/6.
 */
@Controller
@RequestMapping(value = "task")
public class ThreadPoolController {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @RequestMapping("/loopQueryTicket")
    public void loopQueryTicket() {
        QuerTicket querTicket = new QuerTicket("yang",3,5);
        executor.execute(querTicket);
    }
}
