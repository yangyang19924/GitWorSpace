package com.yangyang.controller;

import com.alibaba.fastjson.JSON;
import com.yangyang.threadPool.QuerTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyang on 2018/8/6.
 */
@Controller
@RequestMapping(value = "task")
public class ThreadPoolController {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @RequestMapping("/loopQueryTicket")
    @ResponseBody
    public String loopQueryTicket() {
        QuerTicket querTicket = new QuerTicket("yang",3,5);

        QuerTicket querTicket1 = new QuerTicket("yang1",3,1);
        executor.execute(querTicket);
        executor.execute(querTicket1);
        Map<String,String> map = new HashMap<>();
        map.put("flag","success");
        return JSON.toJSONString(map);
    }

}
