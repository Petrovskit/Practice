package windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        java.util.Set<String> windows = driver.getWindowHandles();                                                      //Getting how many window tabs are open in the browser
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();                                                                                //This has the index of the parent window
        String childWindow = it.next();                                                                                 //This has the index of the child window
        driver.switchTo().window(childWindow);                                                                          //Giving a command for the driver to switch to the child window
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0].trim();           //Splitting the text to extract only the needed Email
        System.out.println(emailId);
        driver.switchTo().window(parentWindow);                                                                         //Switching the driver to look for elements at the Parent window
        driver.findElement(By.id("username")).sendKeys(emailId);

    }
}
