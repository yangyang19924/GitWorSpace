package com.yangyang.controller;

/**
 * Created by yangyang on 2018/8/3.
 */
public class Test1 {
    private int i;
    private int j;
    private int k;

    public Test1(){
        System.out.println("this is a constructor");
    }

    public void init(){
        if(i==0)
            System.out.println("i is 0");
        if(j==0)
            System.out.println("j is 0");
        if(k==0)
            System.out.println("k is 0");
    }

    public void print() {

        System.out.println(i+j+k);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
