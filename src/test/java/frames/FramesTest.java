package frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FramesTest {

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
        WebElement topFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        WebElement main = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(main);
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
