package ru.org.autotest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.concurrent.TimeUnit;

public class СorrectProductPage {
    private static WebDriver driver;


    @Test
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver(); //вызов браузера
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        check();
    }

    @Test
    public void testFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        driver = new FirefoxDriver(); //вызов браузера
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        check();
    }


    public void check() {
        driver.get("http://localhost/litecart/en/");

        //characteristics on the main page
        WebElement CampaignsOne = driver.findElement(By.xpath("//*[@id=\"box-campaigns\"]/div/ul/li[1]"));

        String NameCampaign = CampaignsOne.findElement(By.xpath("//div[@class=\"name\"]")).getAttribute("textContent"); //name-Yellow Duck - Main Page
        String OldPriceMain = CampaignsOne.findElement(By.xpath("//s")).getAttribute("textContent"); //old price - Main Page
        String NewPriceMain = CampaignsOne.findElement(By.xpath("//strong[@class=\"campaign-price\"]")).getAttribute("textContent"); //new price - Main Page
        double OldPriceMainDouble = Double.valueOf(OldPriceMain.substring(1));
        double NewPriceMainDouble = Double.valueOf(NewPriceMain.substring(1));

        String VarOldPriceMainColor = CampaignsOne.findElement(By.xpath("//s")).getCssValue("color"); // color- #666 OR #777
        String VarNewPriceMainColor = CampaignsOne.findElement(By.xpath("//strong[@class=\"campaign-price\"]")).getCssValue("color"); //color- #c00

        CampaignsOne.click(); //product page

        //characteristics on the product page
        WebElement ProductPage = driver.findElement(By.xpath("//*[@id=\"box-product\"]"));

        String NameProductPage = ProductPage.findElement(By.xpath("//h1")).getAttribute("textContent"); //name-Yellow Duck - Product Page
        String OldPriceProductPage = ProductPage.findElement(By.xpath("//s")).getAttribute("textContent"); //old price - Product Page
        String NewPriceProductPage = ProductPage.findElement(By.xpath("//strong[@class=\"campaign-price\"]")).getAttribute("textContent"); //new price - Product Page
        double OldPriceProductPageDouble = Double.valueOf(OldPriceProductPage.substring(1));
        double NewPriceProductPageDouble = Double.valueOf(NewPriceProductPage.substring(1));

        String VarOldPriceProductPageColor = ProductPage.findElement(By.xpath("//s")).getCssValue("color"); // color- #666 OR #777- Product Page
        String VarNewPriceProductPageColor = ProductPage.findElement(By.xpath("//strong[@class=\"campaign-price\"]")).getCssValue("color"); //color- #c00 - Product Page


        // а-name
        NameCampaign.equals(NameProductPage);
        // б-old and new price
        OldPriceMain.equals(OldPriceProductPage);
        NewPriceMain.equals(NewPriceProductPage);
        // в-old-gray and strikethrough "s"
        checkColorGrey(VarOldPriceMainColor, driver);
        checkColorGrey(VarOldPriceProductPageColor, driver);


        // г-new oily- "strong" and red

        checkColorRed(VarNewPriceMainColor, driver);
        checkColorRed(VarNewPriceProductPageColor, driver);


        // д-new larger than normal
        if (OldPriceMainDouble > NewPriceMainDouble) {
            System.out.println("old price is higher than new on the main page");
        }

        if (OldPriceProductPageDouble > NewPriceProductPageDouble) {
            System.out.println("old price is higher than new on product page");
        }
    }

    public static boolean checkColorGrey(String colorOldRGB, WebDriver driver) {
        if (driver instanceof ChromeDriver) {
            colorOldRGB = colorOldRGB.substring(5, colorOldRGB.length() - 1);
            System.out.println(colorOldRGB);
            String colorR = colorOldRGB.split(", ")[0];
            String colorG = colorOldRGB.split(", ")[1];
            String colorB = colorOldRGB.split(", ")[2];
            return colorR.equals(colorG) && colorG.equals(colorB);
        } else if (driver instanceof FirefoxDriver) {
            colorOldRGB = colorOldRGB.substring(4, colorOldRGB.length() - 1);
            System.out.println(colorOldRGB);
            String colorR = colorOldRGB.split(", ")[0];
            String colorG = colorOldRGB.split(", ")[1];
            String colorB = colorOldRGB.split(", ")[2];
            return colorR.equals(colorG) && colorG.equals(colorB);
        } else
            throw new RuntimeException("driver class not found");

    }

    public static boolean checkColorRed(String colorNewRGB, WebDriver driver) {
        if (driver instanceof ChromeDriver) {
            colorNewRGB = colorNewRGB.substring(5, colorNewRGB.length() - 1);
            System.out.println(colorNewRGB);
            String colorG = colorNewRGB.split(", ")[1];
            String colorB = colorNewRGB.split(", ")[2];
            return colorG.equals("0") && colorB.equals("0");
        } else if (driver instanceof FirefoxDriver) {
            colorNewRGB = colorNewRGB.substring(4, colorNewRGB.length() - 1);
            System.out.println(colorNewRGB);
            String colorG = colorNewRGB.split(", ")[1];
            String colorB = colorNewRGB.split(", ")[2];
            return colorG.equals("0") && colorB.equals("0");
        } else
            throw new RuntimeException("driver class not found");

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}