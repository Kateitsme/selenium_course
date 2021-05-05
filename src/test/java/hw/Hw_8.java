package hw;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class Hw_8 extends Steps{
    @Test
    public void testCheckLinks() {
        //1) зайти в админку
        loginToLitecartAdmin();
        //2) открыть пункт меню Countries
        openCountriesIUrl();
        //3) открыть на редактирование какую-нибудь страну или начать создание новой
        driver.findElement(By.xpath("//a[contains(.,' Add New Country')]")).click();
        //4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой
        // -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        String locator_links = "//i[contains(@class,'link')]";
        List<WebElement> links = driver.findElements(By.xpath(locator_links));

        for (int i = 0; i < links.size(); i++) {
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();
            //требуется именно кликнуть по ссылке, чтобы она открылась в новом окне,
            links.get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            // потом переключиться в новое окно,
            driver.switchTo().window(newWindow);
            // закрыть его,
            driver.close();
            // вернуться обратно,
            driver.switchTo().window(originalWindow);
            // и повторить эти действия для всех таких ссылок.
        }
    }
}
