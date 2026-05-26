package com.george.selenium;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {
    @Test
    void test() {
        System.out.println("TaskTest::test()执行");
    }

    @Test
    //@Disabled注解的方法或类会被忽略
    @Disabled
    void testDisabled() {
        System.out.println("TaskTest::testDisabled()执行");
    }
}
