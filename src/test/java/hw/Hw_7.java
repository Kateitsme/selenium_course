package hw;

import helpers.ShopHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Hw_7 extends ShopHelper {
    @Test
    public void testCart() {
        //4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
        for (int i = 0; i < 3; i++) {
            //1) открыть главную страницу
            openUrlShop();
            List<WebElement> product=driver.findElements(By.xpath("//div [contains(@id, 'box-most-popular')]//li"));
            //2) открыть первый товар из списка
            product.get(i).click();
            //выбор продуктов
            if (driver.findElements(By.xpath("//select[@name='options[Size]']")).size() != 0) {
                new Select(driver.findElements(By.name("options[Size]")).get(0)).selectByIndex(1);
            }
            //2) добавить его в корзину
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            WebElement count = driver.findElement(By.xpath("//span[@class='quantity']"));
            //3) подождать, пока счётчик товаров в корзине обновится
            wait.until(textToBePresentInElement(count, i+1 + ""));
        }
        //5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        driver.findElement(By.xpath("//*[contains(text(), 'Checkout')]")).click();
        //кол-во товаров в корзине
        List<WebElement> btnRemove = driver.findElements(By.xpath("//*[@name = 'remove_cart_item']"));
        //удаление товаров из корзины
        //6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
        for (int i = 0; i < btnRemove.size(); i++) {
            WebElement table = driver.findElement(By.xpath("//table[contains(@class, 'dataTable')]"));
            int rest = btnRemove.size();
            //ожидание появления соответствующей кнопки удаления товара
            wait.until(visibilityOf(btnRemove.get(0)));
            btnRemove.get(0).click();

            driver.navigate().refresh();
            //ожидание пока элемент исчезнет из DOM
            wait.until(stalenessOf(table));
            //если товары остались, ожидание до появления таблицы товаров корзины
            if (rest != 1) {
                wait.until(visibilityOfElementLocated(By.xpath("//table[contains(@class, 'dataTable')]")));
                btnRemove = driver.findElements(By.xpath("//*[@name = 'remove_cart_item']"));
            }
        }
    }
}
