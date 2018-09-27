package com.exercise.dao;

import com.exercise.dto.RedPacket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/8/5.
 */
@Repository
public interface RedPaketDAO {

    @Select({"select id,user_id as userId,amount,send_date as sendDate,total,unit_amount as unitAmount,stock,version,note from",
            "t_red_packet where id = #{id}"})
    public RedPacket getRedPacket(@Param("id") Long id);

    @Update({
            "update t_red_packet set stock=stock-1 where id = #{id}"
    })
    public int decreaseRedPacket(@Param("id") Long id);


    @Update({
            "update t_red_packet set stock=stock-1,version = version+1 where id = #{id} and version = #{version}"
    })
    public int decreaseRedPacketForVersion(@Param("id") Long id ,@Param("version") int version);
}
