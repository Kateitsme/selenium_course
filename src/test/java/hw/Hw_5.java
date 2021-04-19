package hw;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Hw_5 extends Steps{

    @Test
    public void checkSortCountryList(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        // проверка сортировки стран
        List<WebElement> countriesList = driver.findElements(By.xpath("//tr[@class='row']"));
        ArrayList<String> countries = new ArrayList<>();

        for (WebElement element:countriesList){
            String countryName = element.findElement(By.xpath("//a")).getAttribute("textContent");
            countries.add(countryName);
        }

        String[] arrayPage = countries.toArray(new String[0]);
        String[] arrSortCountries = countries.toArray(new String[0]);
        Arrays.sort(arrSortCountries);

        assertArrayEquals(arrayPage,arrSortCountries);

        // проверка сортировки зон

        int count = driver.findElements(By.xpath("//tr[@class='row']")).size();
        for (int i = 1; i <= count - 1;i++){
            WebElement country = driver.findElement(By.xpath("//tr[@class='row']["+i+"]"));
            int zone =  Integer.parseInt(country.findElement(By.xpath("//td[6]")).getAttribute("textContent"));
            if (zone > 0){
                country.findElement(By.xpath("//a")).click();
                List<WebElement> countryZones = driver.findElements(By.xpath("//table[@id='table-zones']//td[3]/input"));

                ArrayList<String> zones = new ArrayList<>();
                for(WebElement element:countryZones) {
                    String zoneName = element.getAttribute("value");
                    zones.add(zoneName);
                }
                String[] zonesPage = zones.toArray(new String[0]);
                String[] zonesSort = zones.toArray(new String[0]);
                Arrays.sort(zonesSort);
                assertArrayEquals(zonesPage,zonesSort);
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }

    }


    @Test
    public void checkSortZoneList() throws InterruptedException {

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        // проверка сортировки зон стран
        int count = driver.findElements(By.xpath("//tr[@class='row']")).size();
        for (int i = 1; i<=count;i++){
            driver.findElement(By.xpath("//tr[@class='row']["+ i +"]//a")).click();
            //Thread.sleep(5000);
            List<WebElement> countryZones = driver.findElements(By.xpath("//select/../.."));
            ArrayList<String> zones = new ArrayList<>();
            for (WebElement element:countryZones){
                String zoneName = element.findElement(By.xpath("//td[3]/select")).getAttribute("textContent");
                zones.add(zoneName);

                String[] arrZones = zones.toArray(new String[0]);
                String[] arrSortZones = zones.toArray(new String[0]);
                Arrays.sort(arrSortZones);
                assertArrayEquals(arrZones,arrSortZones);
            }
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            //Thread.sleep(5000);

        }

    }
}
