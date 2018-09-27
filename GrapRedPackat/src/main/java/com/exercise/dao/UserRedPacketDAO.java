package com.exercise.dao;

import com.exercise.dto.UserRedPacket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2018/8/5.
 */
@Repository
public interface UserRedPacketDAO {


    @SelectKey(keyProperty = "id",statement = "SELECT LAST_INSERT_ID()",before = false,resultType = Long.class)
    @Insert({
            "insert into t_user_red_packet(red_packet_id,user_id,amount,grab_time,note)",
            "values(#{userRedPacket.redPacketId},#{userRedPacket.userId},#{userRedPacket.amount},now(),#{userRedPacket.note})"
    })
    public int grabRedPacket(@Param("userRedPacket") UserRedPacket userRedPacket);
}
