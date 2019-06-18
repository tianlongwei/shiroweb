package com.loong.testcase;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    @Test
    public void testSesssionDate(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z");
        String format = sdf.format(date);
        System.out.println(format);
    }
}