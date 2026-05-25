package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class SwitchFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();

        wd.get("https://www.byhy.net/cdn2/files/selenium/sample2.html");
        SeleniumUtil.wait(wd, 10);

        //wd.switchTo().frame():切换窗口
        wd.switchTo().frame("innerFrame");

        WebElement el = wd.findElement(By.cssSelector("div[id='inner12'] > span"));
        String text = el.getText();
        System.out.println(text);

        //wd.switchTo().defaultContent():切换到默认窗口
        wd.switchTo().defaultContent();
        WebElement outerButton = wd.findElement(By.cssSelector("[id=outerbutton]"));
        //等待3秒以便观察按钮点击效果
        Thread.sleep(3000);
        outerButton.click();


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
