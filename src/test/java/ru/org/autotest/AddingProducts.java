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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddingProducts {
    /*
    1) Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить.
    2) Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять.
    3) Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более
       правильные ожидания, будет рассказано в следующих занятиях).
    4) Картинку с изображением товара нужно уложить в репозиторий вместе с кодом. При этом указывать в коде полный абсолютный путь к файлу плохо,
       на другой машине работать не будет. Надо средствами языка программирования преобразовать относительный путь в абсолютный.
    5) После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.
    */
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
        driver.get("http://localhost/litecart/admin/login.php");
        //Loging
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("login")).click();
        //Open Catalog
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        //number of products
        int numberOfProducts = driver.findElements(By.cssSelector(".row")).size();

        //Add New Product
        driver.findElement(By.cssSelector("#content > div > a:nth-child(2)")).click();

        //General
        WebElement NewProTab = driver.findElement(By.cssSelector("#tab-general"));
        NewProTab.findElement(By.cssSelector("input[name=status")).click();
        setField(NewProTab, "name[en]", "Iphone 13");
        setField(NewProTab, "code", "12345");

        //Gender
        List<WebElement> genderList = NewProTab.findElements(By.cssSelector("#tab-general > table > tbody > tr:nth-child(7) tr"));
        genderList.get(1).findElement(By.cssSelector("input[name='product_groups[]']")).click();

        NewProTab.findElement(By.cssSelector("input[name=quantity]")).clear();
        setField(NewProTab, "quantity", Keys.END + "1");
        //Upload Images
        File file = new File("./src/main/resources/iphone_13.png");
        setField(NewProTab, "new_images[]", file.getAbsolutePath());
        setField(NewProTab, "date_valid_from", "09.10.2021");
        setField(NewProTab, "date_valid_to", "09.12.2021");

        //Information
        WebElement InfoTab = driver.findElement(By.cssSelector("a[href*='tab-information']"));
        InfoTab.click();
        List<WebElement> infoTable = driver.findElements(By.cssSelector("#tab-information tr>td"));
        Select select = new Select(infoTable.get(0).findElement(By.cssSelector("select")));
        select.selectByVisibleText("ACME Corp.");
        NewProTab = driver.findElement(By.cssSelector("#tab-information")); //переопределение страницы
        setField(NewProTab, "keywords", "telefon");
        setField(NewProTab, "short_description[en]", "new smartphone model");
        NewProTab.findElement(By.cssSelector(".trumbowyg-editor"))
                .sendKeys(Keys.HOME + "Incredibly bright display in a robust design." + Keys.ENTER
                        + "Cinema Effect mode that makes your video look like a movie." + Keys.ENTER
                        + "Super fast chip. And a tireless battery.");
        setField(NewProTab, "head_title[en]", "Telefon");
        setField(NewProTab, "meta_description[en]", "Telefon|Iphone 13|Buy");

        //Prices
        WebElement PricesTab = driver.findElement(By.cssSelector("a[href*='tab-prices']"));
        PricesTab.click();
        WebElement tablePrice = driver.findElement(By.cssSelector("#tab-prices > table:nth-child(2)"));
        tablePrice.findElement(By.cssSelector("input[name=purchase_price]")).clear();
        setField(tablePrice, "purchase_price", Keys.END + "699");
        select = new Select(tablePrice.findElement(By.cssSelector("select")));
        select.selectByVisibleText("US Dollars");
        List<WebElement> priceTr = driver.findElements(By.cssSelector("#tab-prices > table:nth-child(4) > tbody > tr"));
        setField(priceTr.get(1).findElement(By.cssSelector("td:nth-child(1)")), "prices[USD]", "699");
        setField(priceTr.get(2).findElement(By.cssSelector("td:nth-child(1)")), "prices[EUR]", "603,87");

        //Save
        driver.findElement(By.cssSelector("button[name=save]")).click();
        //Product addition control
        Assert.assertTrue("No new product found", numberOfProducts + 1 == driver.findElements(By.cssSelector(".row")).size());
    }

    private void setField(WebElement createAccount, String field, String data) {
        createAccount.findElement(By.cssSelector("input[name='" + field + "']")).sendKeys(data);
    }

    @After
    public void stop() {
        System.out.println("Test is ended");
        driver.quit();
        driver = null;
    }
}
