package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

public class CheckIframe {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        Actions actions = new Actions(driver);
    }
    @Test
    public void testIframe() throws InterruptedException {
        WebElement iframe =  driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);

        WebElement searchtab = driver.findElement(By.xpath("//input[@name='course']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",searchtab );
        searchtab.click();
        searchtab.sendKeys("selenium");
        Thread.sleep(3000);
        searchtab.sendKeys(Keys.ENTER);

        driver.switchTo().defaultContent();
        driver.findElement(By.id("hondaradio")).click();
        Thread.sleep(3000);
    }
    @Test
    public void getSignInText() throws InterruptedException {
        WebElement iframe =  driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);

        WebElement signin = driver.findElement(By.xpath("//a[@href='/login']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",signin );
        Thread.sleep(3000);
        signin.click();
        Thread.sleep(3000);
        String getText =driver.findElement(By.xpath("//h4[@class='dynamic-heading']")).getText();
        System.out.println(getText);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
