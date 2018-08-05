package com.exercise.service.impl;

import com.exercise.dao.RedPaketDAO;
import com.exercise.dto.RedPacket;
import com.exercise.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2018/8/5.
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired
    private RedPaketDAO redPaketDAO;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return redPaketDAO.getRedPacket(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return redPaketDAO.decreaseRedPacket(id);
    }
}
