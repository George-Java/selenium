package com.george.selenium.junit4;

import com.george.selenium.entity.Weightlifting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExampleTest {
    private final String sex;
    private final int weight;
    private final String expected;
    private Weightlifting weightlifting = null;

    @Before
    public void setUp() {
        // 创建被测类对象
        weightlifting = new Weightlifting();
    }

    @After
    public void tearDown() {
        // 释放被测类对象
        weightlifting = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"male", 56, "男子56公斤级"},
                {"male", 62, "男子62公斤级"},
                {"male", 69, "男子69公斤级"},
                {"female", 58, "女子58公斤级"},
                {"female", 63, "女子63公斤级"},
                {"female", 69, "女子69公斤级"},
                {"male", 57, "男子62公斤级"},
                {"female", 47, "女子48公斤级"},
                {"female", 48, "女子48公斤级"}
        });
    }

    public ExampleTest(String sex, int weight, String expected) {
        this.sex = sex;
        this.weight = weight;
        this.expected = expected;
    }

    @Test
    public void test01() {
        // 3.断言
        String actual = weightlifting.determineCategory(sex, weight);
        Assert.assertEquals(expected, actual);
    }
}
