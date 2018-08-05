package com.exercise.service.impl;

import com.exercise.dao.RedPaketDAO;
import com.exercise.dao.UserRedPacketDAO;
import com.exercise.dto.RedPacket;
import com.exercise.dto.UserRedPacket;
import com.exercise.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/8/5.
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private UserRedPacketDAO userRedPacketDAO;

    @Autowired
    private RedPaketDAO redPaketDAO;

    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId) {

        RedPacket redPacket = redPaketDAO.getRedPacket(redPacketId);

        if(redPacket.getStock() > 0) {
            redPaketDAO.decreaseRedPacket(redPacketId);

            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("抢红包 "+redPacketId);

            int result = userRedPacketDAO.grabRedPacket(userRedPacket);

            return result;
        }

        return FAILED;
    }
}
