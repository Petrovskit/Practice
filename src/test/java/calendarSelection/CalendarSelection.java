package calendarSelection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSelection {

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.path2usa.com/travel-companion/");

        WebElement dateOfTravelField = driver.findElement(By.name("form_fields[travel_comp_date]"));
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",dateOfTravelField); */
        Actions actions = new Actions(driver);
        actions.moveToElement(dateOfTravelField).click().build().perform();
        List<WebElement> dates = driver.findElements(By.className(".flatpickr-day"));                                   //Getting all the dates into List of WebElements
        int count = driver.findElements(By.className(".flatpickr-day")).size();

        for (int i=0;i<count;i++) {                                                                                     //Iterating through all the dates
            String dataText = driver.findElements(By.className(".flatpickr-day")).get(i).getText();                     //Getting the text of the dates

            if(dataText.equalsIgnoreCase("23")){
                driver.findElements(By.className(".flatpickr-day")).get(i).click();                                     //When we have a match click on that date
                break;
            }
        }
    }
}
