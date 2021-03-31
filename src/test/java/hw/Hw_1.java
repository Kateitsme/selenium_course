package hw;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hw_1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void firstTest(){
        driver.get("http://yandex.ru");
        driver.findElement(By.xpath("//a[@data-id='video']")).click();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
