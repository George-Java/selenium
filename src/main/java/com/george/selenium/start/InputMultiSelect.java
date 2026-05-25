package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class InputMultiSelect {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);

        wd.get("https://www.byhy.net/cdn2/files/selenium/test2.html");

        Select sl = new Select(wd.findElement(By.cssSelector("#ss_multi")));
        sl.getAllSelectedOptions().forEach(el -> System.out.println(el.getText()));
        System.out.println();
        Thread.sleep(2000);

        //取消选中所有选项
        sl.deselectAll();

        //按下标顺序选
        sl.selectByIndex(0);
        Thread.sleep(2000);

        //按value属性的值选
        sl.selectByValue("小雷老师");
        Thread.sleep(2000);

        //直接按下拉框选项可见文字选
        sl.selectByVisibleText("小凯老师");
        sl.getAllSelectedOptions().forEach(el -> System.out.println(el.getText()));


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
