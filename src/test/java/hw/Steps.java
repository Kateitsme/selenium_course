package hw;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Steps {
    public WebDriver driver;
    public WebDriverWait wait;
    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    public void wait_to(By locator) {
        WebElement element = wait.until(presenceOfElementLocated(locator));
    }

    public void loginToLitecartAdmin(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void openCountriesIUrl() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public  void click(By locator) {
        WebElement element = wait.until(presenceOfElementLocated(locator));
        element.click();
    }
    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }
    boolean GreyColorCheck(String color){
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner s = new Scanner( color );
        s.useDelimiter( "\\D+" );
        while ( s.hasNextInt() ) {
            numbers.add(s.nextInt()); // get int
        }
        if (numbers.get(1).equals(numbers.get(2)) && numbers.get(0).equals(numbers.get(1))) {
            System.out.println("цвет серый");
            return true;
        }
        else{
            System.out.println("цвет другой");
            return false;
        }
    }
    boolean RedColorCheck(String color){
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner s = new Scanner( color );
        s.useDelimiter( "\\D+" );
        while ( s.hasNextInt() ) {
            numbers.add(s.nextInt()); // get int
        }
        if (numbers.get(1).equals(numbers.get(2))) {
            System.out.println("цвет красный");
            return true;
        }
        else{
            System.out.println("цвет другой");
            return false;
        }
    }
    boolean checkFontSizes(String regular,String campaign){
        Scanner s = new Scanner(regular);
        int first = 0;
        int second = 0;
        s.useDelimiter( "\\D+" );
        while ( s.hasNextInt() ) {
            first=s.nextInt(); // get int
        }
        Scanner o = new Scanner(campaign);
        o.useDelimiter( "\\D+" );
        while ( o.hasNextInt() ) {
            second=o.nextInt(); // get int
        }
        if (first<second)
            return true;
        else
            return false;
    }

    public ExpectedCondition<String> anyWindowOtherThan(final Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }


    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
