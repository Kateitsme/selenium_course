package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hw_10 extends Steps{

    @Test
    public void testBrowserLogs() {
        //1) зайти в админку
        loginToLitecartAdmin();
        //2) открыть каталог
        openCatalog();
        //2) открыть категорию, которая содержит товары
        driver.findElement(By.linkText("Rubber Ducks")).click();
        int count = driver.findElements(By.xpath("//input[contains(@name, 'products')]/../../td[3]/a")).size();
        //3) последовательно открывать страницы товаров и проверять, не появляются ли в логе браузера сообщения (любого уровня)
        for (int i = 1; i <= count; i++) {
            //последовательно открывать страницы товаров
            WebElement product = driver.findElement(By.xpath("(//input[contains(@name, 'products')]/../../td[3]/a)" + "[" + i + "]"));
            product.click();
            System.out.println(getBrowserLogs().getAll().size());
            //проверять, не появляются ли в логе браузера сообщения (любого уровня)
            Assert.assertEquals(0, getBrowserLogs().getAll().size());
            openCatalog();
            driver.findElement(By.linkText("Rubber Ducks")).click();
        }

    }
}
