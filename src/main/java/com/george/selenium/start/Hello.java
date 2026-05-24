package com.george.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

/*
 *ClassName: Hello
 *Package：com.george.selenium.start
 *Description：
 *@Author: George
 *@CreationDate: 2026-05-24-14:36
 *@Version 1.0
 */
public class Hello {
    public static void main(String[] args) {
        ChromeDriver wd = new ChromeDriver();

        /*wd.get("https://www.byhy.net/cdn2/files/selenium/stock1.html");
        WebElement kw = wd.findElement(By.id("kw"));
        kw.sendKeys("通讯");
        WebElement go = wd.findElement(By.id("go"));
        go.click();*/

        wd.get("https://www.byhy.net/cdn2/files/selenium/sample1.html");
        List<WebElement> animals = wd.findElements(By.className("animal"));
        animals.forEach(animal -> System.out.println(animal.getText()));

        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        wd.quit();
        sc.close();
    }
}
