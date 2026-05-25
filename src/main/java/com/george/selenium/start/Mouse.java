package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;

public class Mouse {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);

        wd.get("https://www.byhy.net/cdn2/files/selenium/sample4.html");

        Actions ac = new Actions(wd);
        Thread.sleep(3000);
        ac.moveToElement(wd.findElement(By.cssSelector("#navbarDropdown"))).perform();

        for (int i = 1; i <= 9; i++) {
            WebElement source = wd.findElement(By.cssSelector(String.format("ul.list-group > li#course-%d", i)));
            WebElement target = wd.findElement(By.cssSelector("#selected-courses"));
            ac.dragAndDrop(source, target).perform();
            Thread.sleep(1500);
        }


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
