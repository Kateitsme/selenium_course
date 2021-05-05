package hw;

import helpers.NewProductHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static helpers.NewProductHelper.initProductInfo;
public class Hw_6_2 extends Steps{
    @Test
    public void createProduct() throws InterruptedException {
        loginToLitecartAdmin();
        NewProductHelper product = new NewProductHelper();
        initProductInfo(product);
        Thread.sleep(100);
        click(By.xpath("//span[@class='name'][contains(text(),'Catalog')]"));
        click(By.xpath("//a[text() = ' Add New Product']"));
        click(By.xpath("//td[strong = 'Status']//label[text() = '" + product.status + "']"));
        type(By.xpath("//input[@name='name[en]']"),product.name);
        type(By.xpath("//input[@name='code']"),product.code);
        click(By.xpath("//*[@type = 'checkbox'][@data-name = '" + product.categories + "']"));
        click(By.xpath("//td[contains(text(), '" + product.gender + "')]/..//*[@type = 'checkbox']"));

        type(By.xpath("//input[@name='quantity']"),product.quantity);
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(product.chooseFile);

        type(By.xpath("//input[@name='date_valid_from']"),product.dateFrom);
        type(By.xpath("//input[@name='date_valid_to']"),product.dateTo);

        click(By.linkText("Information"));
        wait_to(By.xpath("//select[@name='manufacturer_id']"));
        new Select(driver.findElement(By.xpath("//select[@name='manufacturer_id']"))).selectByVisibleText(product.manufacturer);
        type(By.xpath("//div[@class='trumbowyg-editor']"),product.description);
        type(By.xpath("//input[@name='head_title[en]']"),product.headTitle);
        click(By.linkText("Prices"));
        type(By.xpath("//input[@name='purchase_price']"),product.purchasePrice);
        new Select(driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']"))).selectByVisibleText(product.currency);
        type(By.xpath("//input[@name='prices[USD]']"),product.priceUSD);
        type(By.xpath("//input[@name='prices[EUR]']"),product.priceEUR);

        click(By.xpath("//button[@name='save']"));
        isElementPresent(driver, By.xpath("//table[@class = 'dataTable']//* [text() = '" + product.name + "']"));
    }
}
