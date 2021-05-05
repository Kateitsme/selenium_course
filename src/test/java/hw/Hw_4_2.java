package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Hw_4_2 extends Steps {

    @Test
    public void secondTest() {
        driver.get("http://localhost/litecart/");
        int count = driver.findElements(By.xpath("//li[contains(@class,'product')]")).size();
        int stickers = 0;
        for (int i = 1; i <= count;i++){
            if (driver.findElements(By.xpath("(//li[contains(@class,'product')])["+ i +"]//div[contains(@class,'sticker')]")).size()==1) {
                stickers++;
            }
        }
        Assert.assertEquals("не все элементы со стикерами", count, stickers);
    }
}
