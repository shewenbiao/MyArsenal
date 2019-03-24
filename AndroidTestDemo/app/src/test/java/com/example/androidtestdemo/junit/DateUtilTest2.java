package com.example.androidtestdemo.junit;

import com.example.androidtestdemo.util.DateUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DateUtilTest2 {

    private String time;

    public DateUtilTest2(String time) {
        this.time = time;
    }

    @Parameterized.Parameters
    public static Collection getTimeList() {
        return Arrays.asList(new String[]{
                "2017-10-15",
                "2017-10-15 16:00:02",
                "2017年10月15 16时00分02秒"
        });
    }

    @Test
    public void dateToStampTest1() throws ParseException {
//        assertNotEquals(4, DateUtil.dateToStamp(time));
        DateUtil.dateToStamp(time);
    }
}