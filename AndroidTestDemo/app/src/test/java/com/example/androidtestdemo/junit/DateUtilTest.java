package com.example.androidtestdemo.junit;

import com.example.androidtestdemo.util.DateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DateUtilTest {

    private String time = "2017-10-15 16:00:02";
    private long timeStamp = 1508054402000L;
    private Date mDate;

    @Before
    public void setUp() throws Exception {
        System.out.print("测试开始 ");
        mDate = new Date();
        mDate.setTime(timeStamp);
    }

    @After
    public void tearDown() throws Exception {
        System.out.print("测试结束");
    }

    @Test
    public void dateToStamp() throws ParseException {
//        assertNotEquals(4, DateUtil.dateToStamp(time));
        assertNotEquals(4, DateUtil.dateToStamp("2017-10-15"));
    }

    @Test
    public void stampToDate() {
        assertEquals("预期时间", DateUtil.stampToDate(timeStamp));
    }

    @Test(expected = ParseException.class)
    public void dateToStampTest1() throws ParseException {
//        assertNotEquals(4, DateUtil.dateToStamp(time));
        DateUtil.dateToStamp("2017-10-15");
    }
}