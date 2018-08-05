package com.exercise.service;

import com.exercise.dto.RedPacket;

/**
 * Created by Administrator on 2018/8/5.
 */
public interface RedPacketService {

    RedPacket getRedPacket(Long id);

    int decreaseRedPacket(Long id);
}
