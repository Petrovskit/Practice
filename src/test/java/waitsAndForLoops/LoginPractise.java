package waitsAndForLoops;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LoginPractise {

    @Test
    public void loginTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w = new WebDriverWait(driver, 5);

        String[] productsToBeAdded = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};


        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");                            //Typing username
        driver.findElement(By.id("password")).sendKeys("learning");                                      //Typing password
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();                                        //Clicking the radio button
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        Select select = new Select(driver.findElement(By.cssSelector("select.form-control")));
        select.selectByVisibleText("Consultant");                                                                       //Select an item from the drop-down menu
        driver.findElement(By.id("terms")).click();                                                                     //Clicking on the checkbox
        driver.findElement(By.id("signInBtn")).click();                                                                 //Clicking on the Sign-In button
        w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));                     //Adding explicit wait

        addItemsToCart(driver, productsToBeAdded);                                                                      //Adding the items to the cart
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();                                       //Clicking on Checkout button
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
        driver.findElement(By.id("country")).sendKeys("Macedonia");

    }

    public void addItemsToCart(WebDriver driver, String[] productsToBeAdded) {

        int a = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

        for (int i = 0; i < products.size(); i++) {

            String nameOfProduct = products.get(i).getText();
            List<String> productsToBeAddedList = Arrays.asList(productsToBeAdded);

            if (productsToBeAddedList.contains(nameOfProduct)) {
                driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
                a++;
                if (a == productsToBeAdded.length) break;
            }
        }
    }
}
