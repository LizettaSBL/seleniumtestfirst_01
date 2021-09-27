package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortingCountries {
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

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        //Loging
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        List<WebElement> listCountries = driver.findElements(By.cssSelector("tr.row td a:not([title=Edit])"));
        List<String> Countries = new ArrayList<>();
        List<String> textContents = new ArrayList<>();

        for ( var listCountry:listCountries) {
            var textContent = listCountry.getAttribute("textContent");
            Countries.add(textContent);
            textContents.add(textContent);
        }
        Collections.sort(Countries);
        Countries.equals(textContents);

    }



    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
}
}