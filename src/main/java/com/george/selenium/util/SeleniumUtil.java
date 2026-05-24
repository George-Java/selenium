package com.george.selenium.util;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SeleniumUtil {
    public static void wait(WebDriver wd, int seconds) {
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
