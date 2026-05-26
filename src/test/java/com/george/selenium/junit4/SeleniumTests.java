package com.george.selenium.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParameterTest.class, ExampleTest.class})
public class SeleniumTests {
}
