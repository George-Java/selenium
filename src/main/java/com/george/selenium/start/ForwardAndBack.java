package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class ForwardAndBack {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);

        wd.get("https://www.baidu.com");
        System.out.println(wd.getTitle());
        Thread.sleep(2000);

        wd.navigate().to("https://www.bing.com");
        System.out.println(wd.getTitle());
        Thread.sleep(2000);

        wd.navigate().back();
        System.out.println(wd.getTitle());
        Thread.sleep(2000);

        wd.navigate().forward();
        System.out.println(wd.getTitle());
        Thread.sleep(2000);


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
