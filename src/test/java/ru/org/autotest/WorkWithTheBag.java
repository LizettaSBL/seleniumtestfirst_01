package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WorkWithTheBag {
    private static WebDriver driver;
    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test is started");

    }
    @Test
    public void Task12Test() throws InterruptedException {

    }
    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
    }

}
