package com.exercise.dao;

import com.exercise.dto.UserRedPacket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2018/8/5.
 */
@Repository
public interface UserRedPacketDAO {


    @SelectKey(keyProperty = "id",statement = "",before = false,resultType = Long.class)
    @Insert({
            "insert into t_user_red_packet(red_packet_id,user_id,amount,grab_time,note)",
            "values(#{redPacketId},#{userId},#{amount},now(),#{note})"
    })
    public int grabRedPacket(UserRedPacket userRedPacket);
}
