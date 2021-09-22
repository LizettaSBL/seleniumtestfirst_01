package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

import java.util.concurrent.TimeUnit;


public class Stickers {
    private static WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver(); //вызов браузера
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Test is started");

    }

    @Test
    public void setup() {
        driver.get("http://localhost/litecart/en/");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (int i = 1; i <= (driver.findElements(By.xpath("//li[starts-with(@class,'product')]")).size()); i++) {

            if ((driver.findElements(cssSelector("//li[starts-with(@class,'product')]["+i+"]//div[starts-with(@class,'sticker')]")).size()) == 1)
            {
                System.out.println(i + ". the product has one sticker");
            } else{
                System.out.println(i + ". product has no sticker or more than one");
            }
        }

    }


    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
    }

}

