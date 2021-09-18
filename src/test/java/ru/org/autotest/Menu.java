package ru.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {

    private static WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver(); //вызов браузера
        System.out.println("Test is started");

    }

    @Test
    public void setup() {
        driver.get("http://localhost/litecart/admin/login.php");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Loging
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        String actualUrl = "http://localhost/litecart/admin/";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Successful login");
        } else {
            System.out.println("Test failed");
        }
        //Appearence=Template
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=appearance&doc=template']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Template")) {
            System.out.println("The page (Template) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Logotype
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=appearance&doc=logotype']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Logotype")) {
            System.out.println("The page (Logotype) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Catalog
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Catalog")) {
            System.out.println("The page (Catalog) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Product Groups
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=product_groups']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Product Groups")) {
            System.out.println("The page (Product Groups) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Option Groups
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=option_groups']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Option Groups")) {
            System.out.println("The page (Option Groups) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Manufacturers
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=manufacturers']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Manufacturers")) {
            System.out.println("The page (Manufacturers) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Suppliers
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=suppliers']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Suppliers")) {
            System.out.println("The page (Option Groups) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Delivery Statuses
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=delivery_statuses']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Delivery Statuses")) {
            System.out.println("The page (Delivery Statuses) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Sold Out Statuses
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=sold_out_statuses']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Sold Out Statuses")) {
            System.out.println("The page (Sold Out Statuses) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Quantity Units
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=quantity_units']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Quantity Units")) {
            System.out.println("The page (Quantity Units) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //CSV Import/Export
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=csv']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("CSV Import/Export")) {
            System.out.println("The page (CSV Import/Export) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Countries
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Countries")) {
            System.out.println("The page (Countries) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }
        //Currencies
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=currencies&doc=currencies']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Currencies")) {
            System.out.println("The page (Currencies) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Customers
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Customers")) {
            System.out.println("The page (Customers) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //CSV Import/Export
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=customers&doc=csv']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("CSV Import/Export")) {
            System.out.println("The page (CSV Import/Export) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Newsletter
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=customers&doc=newsletter']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Newsletter")) {
            System.out.println("The page (Newsletter) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Geo Zones
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Geo Zones")) {
            System.out.println("The page (Geo Zones) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Languages
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=languages&doc=languages']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Languages")) {
            System.out.println("The page (Languages) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Storage Encoding
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=languages&doc=storage_encoding']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Storage Encoding")) {
            System.out.println("The page (Storage Encoding) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Job Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Job Modules")) {
            System.out.println("The page (Job Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Customer Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=customer']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Customer Modules")) {
            System.out.println("The page (Customer Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Shipping Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=shipping']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Shipping Modules")) {
            System.out.println("The page (Shipping Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Payment Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=payment']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Payment Modules")) {
            System.out.println("The page (Payment Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Order Total Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=order_total']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Order Total Modules")) {
            System.out.println("The page (Order Total Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Order Success Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=order_success']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Order Success Modules")) {
            System.out.println("The page (Order Success Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Order Action Modules
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=order_action']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Order Action Modules")) {
            System.out.println("The page (Order Action Modules) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Orders
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=orders&doc=orders']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Orders")) {
            System.out.println("The page (Orders) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Order Statuses
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=orders&doc=order_statuses']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Order Statuses")) {
            System.out.println("The page (Order Statuses) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Pages
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=pages&doc=pages']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Pages")) {
            System.out.println("The page (Pages) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Monthly Sales
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Monthly Sales")) {
            System.out.println("The page (Monthly Sales) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Most Sold Products
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=reports&doc=most_sold_products']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Most Sold Products")) {
            System.out.println("The page (Most Sold Products) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Most Shopping Customers
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=reports&doc=most_shopping_customers']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Most Shopping Customers")) {
            System.out.println("The page (Most Shopping Customers) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Defaults
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=defaults']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Defaults) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-General
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=general']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-General) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Listings
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=listings']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Listings) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Images
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=images']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Images) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Checkout
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=checkout']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Checkout) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Advanced
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=advanced']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Advanced) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Settings-Security
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=settings&doc=security']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Settings")) {
            System.out.println("The page (Settings-Security) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Slides
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=slides&doc=slides']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Slides")) {
            System.out.println("The page (Slides) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Tax
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Tax Classes")) {
            System.out.println("The page (Tax Classes) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Tax Rates
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=tax&doc=tax_rates']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Tax Rates")) {
            System.out.println("The page (Tax Rates) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Search Translations
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=translations&doc=search']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Search Translations")) {
            System.out.println("The page (Search Translations) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //Scan Files For Translations
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=translations&doc=scan']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Scan Files For Translations")) {
            System.out.println("The page (Scan Files For Translations) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

        //CSV Import/Export
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=translations&doc=csv']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("CSV Import/Export")) {
            System.out.println("The page (CSV Import/Export) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }


        //Users
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=users&doc=users']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("Users")) {
            System.out.println("The page (Users) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }


        //vQmods
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']")).click();
        if (driver.findElement(By.cssSelector("#content > h1")).getText().contains("vQmods")) {
            System.out.println("The page (vQmods) is open correctly");
        } else {
            System.out.println("Test failed.Page not found");
        }

    }

    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
    }
}