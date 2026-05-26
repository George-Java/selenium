package com.george.selenium.start;

import com.george.selenium.util.SeleniumUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class JSExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        SeleniumUtil.wait(wd, 10);

        wd.get("https://www.baidu.com");
        String currentHandle = wd.getWindowHandle();
        //创建Javascript脚本执行对象JavascriptExecutor js
        JavascriptExecutor js = (JavascriptExecutor) wd;
        //执行JS脚本，在新标签页打开必应导航
        js.executeScript("window.open('https://www.bing.com','_blank')");

        System.out.println(wd.getTitle());
        for (String handle : wd.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                wd.switchTo().window(handle);
                break;
            }
        }
        System.out.println(wd.getTitle());
        //暂停线程三秒，方便观察网页刷新
        Thread.sleep(3000);
        //wd.navigate().refresh():刷新网页
        wd.navigate().refresh();


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
