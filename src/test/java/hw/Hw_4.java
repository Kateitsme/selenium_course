package hw;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Hw_4 extends Steps {


    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        //блок Appearence
        Thread.sleep(5000);
        click(By.xpath("//li[.//text()='Appearence']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Logotype']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Catalog
        click(By.xpath("//li[.//text()='Catalog']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Product Groups']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Option Groups']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Manufacturers']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Suppliers']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Delivery Statuses']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Sold Out Statuses']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Quantity Units']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='CSV Import/Export']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Countries']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Currencies']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Customers
        click(By.xpath("//li[.//text()='Customers']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='CSV Import/Export']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Newsletter']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Geo Zones']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Languages
        click(By.xpath("//li[.//text()='Languages']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Storage Encoding']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        //блок Modules
        click(By.xpath("//li[.//text()='Modules']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Customer']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Shipping']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Payment']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Order Total']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Order Success']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Order Action']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Orders
        click(By.xpath("//li[.//text()='Orders']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        Thread.sleep(5000);
        click(By.xpath("//li[.//text()='Order Statuses']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Pages']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Reports
        click(By.xpath("//li[.//text()='Reports']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        Thread.sleep(5000);
        click(By.xpath("//li[.//text()='Most Sold Products']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Most Shopping Customers']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Settings
        click(By.xpath("//li[.//text()='Settings']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Defaults']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='General']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Listings']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Images']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Checkout']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Advanced']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Security']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Slides']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Tax
        click(By.xpath("//li[.//text()='Tax']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Tax Rates']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        //блок Translations
        click(By.xpath("//li[.//text()='Translations']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='Scan Files']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
        click(By.xpath("//li[.//text()='CSV Import/Export']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='Users']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

        click(By.xpath("//li[.//text()='vQmods']"));
        Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));

    }
}
