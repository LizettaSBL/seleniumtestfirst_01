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

        //1-a
        List<WebElement> listCountries = driver.findElements(By.cssSelector("tr.row td a:not([title=Edit])"));
        List<String> Countries = new ArrayList<>();
        List<String> textContents = new ArrayList<>();

        for (var listCountry : listCountries) {
            var textContent = listCountry.getAttribute("textContent");
            Countries.add(textContent);
            textContents.add(textContent);
        }
        Collections.sort(Countries);

        if (Countries.equals(textContents)==true) {
            System.out.println("sorting of countries is correct");
        }


        //1-b
        List<WebElement> countryRow = driver.findElements(By.cssSelector("tr.row"));
        for (int i = 2; i <= countryRow.size(); i++) {
            if (!driver.findElement(By.cssSelector("tr:nth-child("+i+") > td:nth-child(6)")).getText().equals("0")) {

                driver.findElement(By.cssSelector(" tr:nth-child("+i+") > td:nth-child(5)> a ")).click();

                List<WebElement> listZones = driver.findElements(By.cssSelector("td:nth-child(3)>input[name^='zones']"));
                List<String> namesZones = new ArrayList<>();
                List<String> textZones = new ArrayList<>();
                for (var listZona : listZones) {
                    var textZona = listZona.getAttribute("value");
                    namesZones.add(textZona);
                    textZones.add(textZona);
                }
                Collections.sort(namesZones);
                if (namesZones.equals(textZones)==true){
                    System.out.println("sorting is correct");
                }
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

        @After
        public void stop () {
            System.out.println("Test is ended");
            driver.quit();
            driver = null;
        }
    }