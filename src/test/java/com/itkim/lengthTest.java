package com.itkim;

import org.junit.Test;

/**
 * @description: TODO
 * @author: KimJun
 * @date: 19/1/8 22:11
 */
public class lengthTest {
    @Test
    public void test1() {
        String str = "http://music.163.com/api/song/detail/?id=450228839&ids=%5B+450228839%5D";
        System.out.println(str.length());
    }
}
