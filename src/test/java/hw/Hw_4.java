package hw;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Hw_4 extends Steps {


    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        //блок Appearence
        Thread.sleep(5000);
        int count = driver.findElements(By.xpath("//li[@id='app-']")).size();
        for (int i = 1; i <= count;i++){
            WebElement menu = driver.findElement(By.xpath("//li[@id='app-']["+i+"]"));
            menu.click();
            Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
            if (areElementsPresent(driver,By.xpath("//ul[@class='docs']/li"))){
                int countSum = driver.findElements(By.xpath("//ul[@class='docs']/li")).size();
                for (int j = 1; j <= countSum;j++){
                    WebElement menuSub = driver.findElement(By.xpath("//ul[@class='docs']/li["+j+"]"));
                    menuSub.click();
                    Assert.assertTrue("Элемент не найден",isElementPresent(driver,By.xpath("//h1")));
                }
            }
        }
    }
}
