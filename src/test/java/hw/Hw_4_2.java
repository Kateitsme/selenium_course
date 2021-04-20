package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Hw_4_2 extends Steps {

    @Test
    public void secondTest() {
        driver.get("http://localhost/litecart/");
        int count = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']")).size();
        int stickers = 0;
        for (int i = 1; i <= count;i++){
            isElementPresent(driver, By.xpath("(//li[@class='product column shadow hover-light'])["+ i +"]/a/div/div[contains(.,'Sale')or contains(.,'New')]"));
            stickers++;
        }
        Assert.assertEquals("не все элементы со стикерами", count, stickers);
    }
}
