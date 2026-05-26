package com.george.selenium.junit4;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class ParameterTest {
    private final String username;
    private final String password;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"root", "root"},
                {"admin", "admin123"},
                {"user", "123456"}
        });
    }

    public ParameterTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Test
    public void testParameter() {
        System.out.println("Your username:" + this.username);
        System.out.println("Your password:" + this.password);
    }

    @Test
    @Ignore
    public void testSelenium() {
        System.out.println("ParameterTest::testSelenium()执行");
    }
}
