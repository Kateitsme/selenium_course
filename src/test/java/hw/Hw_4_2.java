package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Hw_4_2 extends Steps {

    @Test
    public void secondTest() {
        driver.get("http://localhost/litecart/");
        int a = driver.findElements(By.xpath("//li/a[@class='link']")).size();
        int b = driver.findElements(By.xpath("//li/a[@class='link']/div[contains(.,'Sale')or contains(.,'New')]")).size();
        Assert.assertEquals("все элементы со стикерами", a, b);
    }
}
