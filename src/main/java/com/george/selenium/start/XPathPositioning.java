package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class XPathPositioning {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);
        wd.get("https://www.byhy.net/cdn2/files/selenium/test1.html");

        List<WebElement> els = wd.findElements(By.xpath("//*[@id]"));
        els.forEach(el -> System.out.println(el.getText()));


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
