package webDriverLimitedScope;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LimitWebDriverScope_OpenTabs {

    @Test
    public void test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        /* Get all the links on the page*/
        System.out.println(driver.findElements(By.tagName("a")).size());                                                //Get all the links that are present on the Website

        /* Get all the links present on the footer of the page*/
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));                                                  //Limiting WebDriver scope to the footer section
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        /* Get all the links present on the first column of the footer*/
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));        //Limiting WebDriver scope to the first column of the footer
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        /* Click on each link on the first column of the footer and check if pages are opening*/
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {                                   //For loop for clicking on all the links on the first column of the footer

            String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);                                                 //Utilizing Keys class to open links in new tab

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
            Thread.sleep(2000);
        }
            Set<String> windowHandles = driver.getWindowHandles();                                                      //Getting the number of opened windows
            Iterator<String> it = windowHandles.iterator();                                                             //Iterator will help us navigate to the opened windows

            while (it.hasNext()) {                                                                                      //Creating a while loop to switch to next windows starting from the 0th index
                driver.switchTo().window(it.next());                                                                    //Moving through the windows
                System.out.println(driver.getTitle());                                                                  //Printing the title of the pages
            }
        }
    }
