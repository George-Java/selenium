package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        ChromeDriver wd = new ChromeDriver();

        wd.get("https://www.byhy.net/cdn2/files/selenium/stock1.html");
        //wait()工具方法,详见SeleniumUtil.java
        SeleniumUtil.wait(wd, 10);

        WebElement el;

        el = wd.findElement(By.id("kw"));
        //清空文本框
        el.clear();
        //sendKeys("文本内容"),向文本框中输入内容
        el.sendKeys("通讯");
        //getAttribute("属性名"),获取某html标签的某属性的值
        System.out.println(el.getAttribute("placeholder"));

        el = wd.findElement(By.id("go"));
        el.click();

        /*wd.get("https://www.byhy.net/cdn2/files/selenium/sample1.html");
        List<WebElement> animals = wd.findElements(By.className("animal"));
        animals.forEach(animal -> {
            WebElement span = animal.findElement(By.tagName("span"));
            System.out.println(span.getText());
        });*/

        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
