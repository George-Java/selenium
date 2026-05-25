package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class AlertHandler {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);
        wd.get("https://www.byhy.net/cdn2/files/selenium/test4.html");


        Thread.sleep(2000);
        wd.findElement(By.cssSelector("#b1")).click();
        Alert alert1 = wd.switchTo().alert();
        //获取弹出框文本内容
        String msg = alert1.getText();
        System.out.println(msg);
        Thread.sleep(2000);
        //接受弹出框信息
        alert1.accept();


        Thread.sleep(2000);
        wd.findElement(By.cssSelector("#b2")).click();
        Alert alert2 = wd.switchTo().alert();
        //获取弹出框文本内容
        String msg2 = alert2.getText();
        System.out.println(msg2);
        Thread.sleep(2000);
        //接受弹出框信息
        //alert.accept();
        //拒绝弹出框信息
        alert2.dismiss();


        Thread.sleep(2000);
        wd.findElement(By.cssSelector("#b3")).click();
        Alert alert3 = wd.switchTo().alert();
        //获取弹出框文本内容
        String msg3 = alert3.getText();
        System.out.println(msg3);
        Thread.sleep(2000);
        //向弹出框的文本框中输入内容
        alert3.sendKeys("Selenium自动化");
        Thread.sleep(2000);
        //接受弹出框信息
        alert3.accept();


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
