package javaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SumExercise {

    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
        System.out.println("Number of rows in the table:" + rows.size());

        List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
        System.out.println("Number of columns in the table:" + columns.size());

        String secondRowContent = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
        System.out.println("Second row content:" + secondRowContent);
    }
}
