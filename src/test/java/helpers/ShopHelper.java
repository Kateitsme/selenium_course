package helpers;

import hw.Steps;

public class ShopHelper extends Steps { //Меняем наследование от нужного класса для вызова другого браузера

    public void openUrlShop() {
        driver.get("http://localhost/litecart/en/");
    }
}
