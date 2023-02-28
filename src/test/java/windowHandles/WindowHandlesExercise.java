package windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlesExercise {

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator <String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
    }
}
