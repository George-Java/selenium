package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class CssSelector {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();

        wd.get("https://www.byhy.net/cdn2/files/selenium/stock1.html");
        SeleniumUtil.wait(wd, 10);

        WebElement el;

        //By.cssSelector("css选择器"):依靠CSS选择器定位元素
        el = wd.findElement(By.cssSelector(".result-item > .name"));
        System.out.println(el.getText());
        System.out.println(el.getAttribute("outerHTML"));
        System.out.println(el.getAttribute("innerHTML"));


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
