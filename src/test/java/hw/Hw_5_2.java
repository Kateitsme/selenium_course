package hw;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hw_5_2 extends Steps{
    @Test
    public void checkProduct(){
    driver.get("http://localhost/litecart/en/");

    // товар на главной странице
    WebElement product = driver.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//li"));

    String link = driver.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//li/a[@class='link']")).getAttribute("href");
    String name = driver.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//div[@class='name']")).getAttribute("textContent");

    WebElement regularPriceElement = product.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//s[@class='regular-price']"));
    WebElement campaignPriceElement = product.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//strong[@class='campaign-price']"));

    String regularPrice = regularPriceElement.getAttribute("textContent");
    String campaignPrice = campaignPriceElement.getAttribute("textContent");
    //сравнить цвет и размер шрифта
    String regularPriceClass = regularPriceElement.getAttribute("class");
    String campaignPriceClass = campaignPriceElement.getAttribute("class");
    //сравнить жирность и зачеркнутость шрифта
    String regularPriceTag = regularPriceElement.getAttribute("tagName");
    String campaignPriceTag = campaignPriceElement.getAttribute("tagName");

        product.click();

    // страница товара
    String productLink2 = driver.findElement(By.xpath("//link[@rel='canonical']")).getAttribute("href");
    String productName2 = driver.findElement(By.xpath("//h1[@class='title']")).getAttribute("textContent");

    WebElement regularPriceElement2 = driver.findElement(By.xpath("//s[@class='regular-price']"));
    WebElement campaignPriceElement2 = driver.findElement(By.xpath("//strong[@class='campaign-price']"));

    String regularPrice2 = regularPriceElement2.getAttribute("textContent");
    String campaignPrice2 = campaignPriceElement2.getAttribute("textContent");
    String regularPriceClass2 = regularPriceElement2.getAttribute("class");
    String campaignPriceClass2 = campaignPriceElement2.getAttribute("class");
    String regularPriceTag2 = regularPriceElement2.getAttribute("tagName");
    String campaignPriceTag2 = campaignPriceElement2.getAttribute("tagName");


    Assert.assertEquals(link, productLink2);
    Assert.assertEquals(name, productName2);
    Assert.assertEquals(regularPrice, regularPrice2);
    Assert.assertEquals(campaignPrice, campaignPrice2);
    Assert.assertEquals(regularPriceClass, regularPriceClass2);
    Assert.assertEquals(campaignPriceClass, campaignPriceClass2);
    Assert.assertEquals(regularPriceTag, regularPriceTag2);
    Assert.assertEquals(campaignPriceTag, campaignPriceTag2);
}
}
