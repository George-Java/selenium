package com.george.selenium.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumFirstTest {
    @Test
    void test() {
        System.out.println("SeleniumTest::test()执行");
    }
}
