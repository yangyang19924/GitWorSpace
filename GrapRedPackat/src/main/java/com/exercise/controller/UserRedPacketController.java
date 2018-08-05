package com.exercise.controller;

import com.exercise.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/5.
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketServiceImpl;

    @RequestMapping("/grapRedPacket")
    @ResponseBody
    public Map<String,Object> grapRedPacket(Long redPacketId,Long userId) {

        int result = userRedPacketServiceImpl.grapRedPacket(redPacketId,userId);

        Map<String,Object> retMap = new HashMap<>();
        boolean flag = result>0;

        retMap.put("success",flag);
        retMap.put("message",flag?"成功":"失败");

        return retMap;
    }
}
