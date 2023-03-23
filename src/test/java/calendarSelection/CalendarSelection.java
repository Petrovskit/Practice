package calendarSelection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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
        dateOfTravelField.click();

        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        List<WebElement> dates = driver.findElements(By.className(".flatpickr-day"));                                   //Getting all the dates into List of WebElements
        int count = driver.findElements(By.className(".flatpickr-day")).size();

        //Grab common attribute, put it into list and iterate

        for (int i = 0; i < count; i++) {                                                                                     //Iterating through all the dates
            String dataText = driver.findElements(By.className(".flatpickr-day")).get(i).getText();                     //Getting the text of the dates

            if (dataText.equalsIgnoreCase("23")) {
                driver.findElements(By.className(".flatpickr-day")).get(i).click();                                     //When we have a match click on that date
                break;
            }
        }
    }
}
