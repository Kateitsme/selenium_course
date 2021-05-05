package helpers;

import java.io.File;

import static helpers.RandomizeHelper.*;

public class NewProductHelper {
    public String status;
    public String name;
    public String code;
    public String categories;
    public String gender;
    public String quantity;
    public String chooseFile;
    public String dateFrom;
    public String dateTo;
    public String manufacturer;
    public String description;
    public String headTitle;
    public String purchasePrice;
    public String currency;
    public String priceUSD;
    public String priceEUR;

    public static void initProductInfo(NewProductHelper product) {
        File file = new File("src/test/resources/batman_duck.png");
        String absolutePath = file.getAbsolutePath();


        product.status = getRandomElementFromArray(new String[] {" Enabled", " Disabled"});
        product.name = "Duck";
        product.code = getRandomInt(4);
        product.categories = "Rubber Ducks";
        product.gender = getRandomElementFromArray(new String[] {"Female", "Male", "Unisex"});
        product.quantity = getRandomInt(1);
        product.chooseFile = absolutePath;
        product.dateFrom = "12042021";
        product.dateTo = "11042022";

        product.manufacturer = "ACME Corp.";
        product.description = getRandomString(10);
        product.headTitle = getRandomString(5);

        product.purchasePrice = getRandomInt(2);
        product.currency = getRandomElementFromArray(new String[] {"US Dollars", "Euros"});
        product.priceUSD = getRandomInt(1);
        product.priceEUR = getRandomInt(1);
    }
}
