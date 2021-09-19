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
        //Post Popular
        System.out.println("Block check Post Popular");
        for (int i = 1; i <= (driver.findElements(By.xpath("//*[@id=\"box-most-popular\"]/div/ul/li")).size()); i++) {

            if (!(driver.findElements(cssSelector("#box-most-popular > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='New']")).isEmpty())) {
                System.out.println(i + ". the product has a sticker");
            } else {
                if (!(driver.findElements(cssSelector("#box-most-popular > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='On Sale']")).isEmpty())) {
                    System.out.println(i + ". the product has a sticker");
                } else {
                    System.out.println(i + ". product has no sticker");
                }
            }
        }

        //Campaigns
        System.out.println("Block check Campaigns");
        for (int i = 1; i <= (driver.findElements(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li")).size()); i++) {

            if (!(driver.findElements(cssSelector("#box-campaigns > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='New']")).isEmpty())) {
                System.out.println(i + ". the product has a sticker");
            } else {
                if (!(driver.findElements(cssSelector("#box-campaigns > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='On Sale']")).isEmpty())) {
                    System.out.println(i + ". the product has a sticker");
                } else {
                    System.out.println(i + ". product has no sticker");
                }
            }
        }

        //Latest Products
        System.out.println("Block check Latest Products");
        for (int i = 1; i <= (driver.findElements(By.xpath("//*[@id=\"box-latest-products\"]/div/ul/li")).size()); i++) {

            if (!(driver.findElements(cssSelector("#box-latest-products > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='New']")).isEmpty())) {
                System.out.println(i + ". the product has a sticker");
            } else {
                if (!(driver.findElements(cssSelector("#box-latest-products > div > ul > li:nth-child(" + i + ") > a.link > div.image-wrapper > div[title='On Sale']")).isEmpty())) {
                    System.out.println(i + ". the product has a sticker");
                } else {
                    System.out.println(i + ". product has no sticker");
                }
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

