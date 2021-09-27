package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zones {
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
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        //Loging
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        for (int i = 2; i <= driver.findElements(By.cssSelector("tr.row")).size()+1; i++) {
            driver.findElement(By.cssSelector("tr:nth-child("+i+") > td:nth-child(3)>a")).click();

                List<WebElement> listZones = driver.findElements(By.cssSelector("td:nth-child(3)>select[name^='zones']"));
                List<String> SortZones = new ArrayList<>();
                List<String> Zones = new ArrayList<>();

                for (var listZona : listZones) {

                    if (listZona.isSelected() == true)
                    {
                        var textZona = listZona.getAttribute("text");
                        SortZones.add(textZona);
                        Zones.add(textZona);
                    }

                    }
            Collections.sort(SortZones);
            if (SortZones.equals(Zones)==true){
                System.out.println("sorting is correct");
                }
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }

    }

    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
    }
}
