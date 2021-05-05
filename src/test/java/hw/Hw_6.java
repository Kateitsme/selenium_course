package hw;

import helpers.RegistrationHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Hw_6 extends Steps{
    @Test
    public void firstTest() {
        RegistrationHelper customer = new RegistrationHelper();
        customer.initCustomer();
        driver.get("http://localhost/litecart/");
        click(By.xpath("//a[contains(text(),'New customers')]"));
        type(By.xpath("//input[@name='firstname']"), customer.first_name);
        type(By.xpath("//input[@name='lastname']"),customer.last_name);
        type(By.xpath("//input[@name='address1']"), customer.address1);
        type(By.xpath("//input[@name='postcode']"), customer.postcode);
        type(By.xpath("//input[@name='city']"), customer.city);
        new Select(driver.findElement(By.cssSelector("select[name = country_code]"))).selectByVisibleText(customer.country);
        List<WebElement> zones = new Select(driver.findElement(By.cssSelector("select[name = zone_code]"))).getOptions();
        new Select(driver.findElement(By.cssSelector("select[name = zone_code]"))).selectByVisibleText(zones.get(customer.zone).getText());
        type(By.xpath("//input[@name='email']"),customer.email);
        type(By.xpath("//input[@name='phone']"), customer.phone);
        type(By.xpath("//input[@name='password']"), customer.password);
        type(By.xpath("//input[@name='confirmed_password']"), customer.password);
        click(By.xpath("//button[@name='create_account']"));
        click(By.linkText("Logout"));
        type(By.name("email"),customer.email);
        type(By.name("password"),customer.password);
        click(By.name("login"));

    }
}
