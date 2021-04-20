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

    WebElement regularPriceElement = product.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//li//s[@class='regular-price']"));
    WebElement campaignPriceElement = product.findElement(By.xpath("(//ul[@class='listing-wrapper products'])[2]//li//*[@class='campaign-price']"));

    String regularPrice = regularPriceElement.getAttribute("textContent");
    String campaignPrice = campaignPriceElement.getAttribute("textContent");
    //сравнить цвет и размер шрифта
    String regularPriceColor = regularPriceElement.getCssValue("color");
    String campaignPriceColor = campaignPriceElement.getCssValue("color");
    String regularPriceFontSize = regularPriceElement.getCssValue("font-size");
    String campaignPriceFontSize = campaignPriceElement.getCssValue("font-size");
    //сравнить жирность и зачеркнутость шрифта
        String campaignPriceTag = campaignPriceElement.getCssValue("font-weight");
        String regularPriceStyle = regularPriceElement.getCssValue("text-decoration");

        product.click();

    // страница товара
    String productLink2 = driver.findElement(By.xpath("//link[@rel='canonical']")).getAttribute("href");
    String productName2 = driver.findElement(By.xpath("//h1[@class='title']")).getAttribute("textContent");

    WebElement regularPriceElement2 = driver.findElement(By.xpath("//s[@class='regular-price']"));
    WebElement campaignPriceElement2 = driver.findElement(By.xpath("//*[@class='campaign-price']"));

    String regularPrice2 = regularPriceElement2.getAttribute("textContent");
    String campaignPrice2 = campaignPriceElement2.getAttribute("textContent");
        //сравнить цвет и размер шрифта
        String regularPriceColor2 = regularPriceElement2.getCssValue("color");
        String campaignPriceColor2 = campaignPriceElement2.getCssValue("color");
        String regularPriceFontSize2 = regularPriceElement2.getCssValue("font-size");
        String campaignPriceFontSize2 = campaignPriceElement2.getCssValue("font-size");
        //сравнить жирность и зачеркнутость шрифта
        String campaignPriceTag2 = campaignPriceElement2.getCssValue("font-weight");
        String regularPriceStyle2 = regularPriceElement2.getCssValue("text-decoration");

    Assert.assertEquals(link, productLink2);
    Assert.assertEquals(name, productName2);
    Assert.assertEquals(regularPrice, regularPrice2);
    Assert.assertEquals(campaignPrice, campaignPrice2);
    Assert.assertEquals(GreyColorCheck(regularPriceColor), GreyColorCheck(regularPriceColor2));
    Assert.assertEquals(RedColorCheck(campaignPriceColor), RedColorCheck(campaignPriceColor2));
    Assert.assertTrue(checkFontSizes(regularPriceFontSize,campaignPriceFontSize));
    Assert.assertTrue(checkFontSizes(regularPriceFontSize2,campaignPriceFontSize2));
    Assert.assertTrue(regularPriceStyle.contains("line-through"));
    Assert.assertTrue(regularPriceStyle2.contains("line-through"));
    Assert.assertEquals(regularPriceStyle.contains("line-through"), regularPriceStyle2.contains("line-through"));
    Assert.assertEquals(campaignPriceTag, campaignPriceTag2);
}
}
