package com.yangyang.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangyang on 2018/8/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class TestBeanImpl {

    @Autowired
    Test1 test;

    @Test
    public void testBean() {
        test.setI(1);
        test.setJ(2);
        test.setK(3);
        test.print();
    }
}
