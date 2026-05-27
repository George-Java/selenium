package com.george.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Scanner;

//QQ Music自动化
public class QQMusic {
    static void main() throws InterruptedException {
        WebDriver wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wd.get("https://y.qq.com/");

        Actions ac = new Actions(wd);
        ac.moveToElement(wd.findElement(By.cssSelector(".section_inner>div[class='mod_playlist mod_slide']"))).perform();
        Thread.sleep(2000);

        wd.findElement(By.cssSelector("[class='slide_action__btn slide_action__btn--right']")).click();
        Thread.sleep(2000);

        wd.findElement(By.cssSelector("[class='slide_action__btn slide_action__btn--left']")).click();
        Thread.sleep(2000);

        wd.findElement(By.cssSelector("a[class='top_login__link']")).click();
        Thread.sleep(20000);

        wd.findElement(By.cssSelector("a[class='top_subnav__link'][title='歌手']")).click();
        Thread.sleep(2000);

        WebElement SingerCover = wd.findElement(By.cssSelector("li[class='singer_list__item'] a[class='singer_list__cover']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("arguments[0].scrollIntoView(true);", SingerCover);
        Thread.sleep(2000);

        SingerCover.click();


        System.out.println("请输入回车结束");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        sc.close();
        wd.quit();
    }
}
