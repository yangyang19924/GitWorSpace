package com.yangyang.quarz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/26.
 */
public class QuarzJob {
    public void execute(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "执行ExampleJob2");
    }
}
