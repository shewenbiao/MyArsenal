package com.example.androidtestdemo.junit;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.junit.Assert.assertThat;

public class AssertThatTest {

    @Rule
    public MyRule mMyRule = new MyRule();

    @Test
    public void testAssertThat() {
        assertThat(2, is(2));
    }

    @Test
    public void testAssertThat2() {
        assertThat(2, nullValue());
    }

    @Test
    public void testAssertThat3() {
//        assertThat("Hello UI", both(startsWith("Hello")).and(endsWith("AUT")));
        assertThat("123", "Hello UI", both(startsWith("Hello")).and(endsWith("AUT")));
    }

    @Test
    public void testPhone() {
//        assertThat("13521723196", new IsMobilePhoneMatcher());
        assertThat("19521723196", new IsMobilePhoneMatcher());
    }

}
