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
    public int grapRedPacketForVersion(Long redPacketId, Long userId) {

        long start = System.currentTimeMillis();

        while(true) {
            long end = System.currentTimeMillis();

            if(end - start > 100) {
                return FAILED;
            }

            RedPacket redPacket = redPaketDAO.getRedPacket(redPacketId);

            if(redPacket.getStock() > 0) {
                int update = redPaketDAO.decreaseRedPacketForVersion(redPacketId,redPacket.getVersion());

                if(update == 0)
                    return FAILED;

                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setUserId(userId);
                userRedPacket.setAmount(redPacket.getUnitAmount());
                userRedPacket.setNote("抢红包 "+redPacketId);

                int result = userRedPacketDAO.grabRedPacket(userRedPacket);

                return result;
            }

            else
                return FAILED;
        }
    }
}
