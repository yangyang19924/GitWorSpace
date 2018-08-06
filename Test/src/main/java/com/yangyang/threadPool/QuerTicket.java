package com.yangyang.threadPool;

/**
 * Created by yangyang on 2018/8/6.
 */
public class QuerTicket extends Thread {

    private String username;

    private int loopstep=1;

    private int looptime=1;

    public QuerTicket(String username,int loopstep,int looptime) {
        super();
        this.username = username;
        this.loopstep = loopstep;
        this.looptime = looptime;
    }

    @Override
    public void run() {
        for(int i=0;i<loopstep;i++) {
            System.out.println("sql查询策略(执行3次每次间隔5秒)");
            System.out.println("_______姓名:"+username+"_第"+(i+1)+"次抢票状态:未抢到");
            try {
                Thread.sleep(looptime*1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
