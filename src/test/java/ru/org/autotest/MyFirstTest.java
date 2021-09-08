package ru.org.autotest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {

    private static WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test is started");

    }
    @Test
    public void setup() {
        driver.get("https://www.selenium.dev/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Selenium"));

    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
        System.out.println("Test is finished");
            }


}
