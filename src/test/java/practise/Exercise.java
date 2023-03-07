package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exercise {

    @Test
    public void exercise() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        String checkboxLabel = driver.findElement(By.xpath("//label[@for='bmw']")).getText();
        System.out.println(checkboxLabel);
        checkbox.click();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);
        dropdown.click();
        s.selectByVisibleText(checkboxLabel);

        WebElement alertInputField = driver.findElement(By.id("name"));
        alertInputField.click();
        alertInputField.sendKeys(checkboxLabel);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        if (alertText.contains(checkboxLabel)) {
            System.out.println(alertText);
        } else {
            System.out.println("Wrong Label");
        }
    }
}