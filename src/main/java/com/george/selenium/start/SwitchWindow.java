package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class SwitchWindow {
    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();

        wd.get("https://www.byhy.net/cdn2/files/selenium/sample3.html");
        SeleniumUtil.wait(wd, 10);

        String current = wd.getWindowHandle();

        WebElement link = wd.findElement(By.cssSelector("a[href]"));
        link.click();
        System.out.println(wd.getTitle());

        for (String handle : wd.getWindowHandles()) {
            if (!handle.equals(current)) {
                wd.switchTo().window(handle);
                break;
            }
        }
        System.out.println(wd.getTitle());

        //关闭新标签页前对新标签页进行的一系列操作......

        //wd.close():关闭当前标签页,但要注意此时还没有切换回原来的标签页
        wd.close();

        //切换到原标签页
        wd.switchTo().window(current);

        System.out.println(wd.getTitle());


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
