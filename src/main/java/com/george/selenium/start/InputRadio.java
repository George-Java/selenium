package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class InputRadio {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);

        wd.get("https://www.byhy.net/cdn2/files/selenium/test2.html");

        WebElement el;
        el = wd.findElement(By.cssSelector("input[type='radio']:checked"));
        System.out.println(el.getAttribute("value"));

        wd.findElement(By.cssSelector("input[type='radio'][value='小雷老师']")).click();
        el = wd.findElement(By.cssSelector("input[type='radio']:checked"));
        System.out.println(el.getAttribute("value"));


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
