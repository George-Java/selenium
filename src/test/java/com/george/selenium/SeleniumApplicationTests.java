package com.george.selenium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//使用JUnit测试套件
@Suite
@SelectClasses({HelloTest.class, CssSelectorTest.class})
class SeleniumApplicationTests {
    @ParameterizedTest
    @ValueSource(ints = {3, 17, 8, 11, 9})
    void testPrintNumber(int num) {
        System.out.println(num);
    }
}
