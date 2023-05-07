package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void switchToWindow() throws InterruptedException {
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        driver.findElement(By.id("openwindow")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        for (String handle:allWindowHandles) {
            if(!handle.equals(parentWindowHandle)){
               driver.switchTo().window(handle);
               Thread.sleep(3000);
               WebElement searchtab = driver.findElement(By.xpath("//input[@name='course']"));
               searchtab.click();
               searchtab.sendKeys("selenium");
               Thread.sleep(3000);
               searchtab.sendKeys(Keys.ENTER);
               driver.close();
            }
        }
        driver.switchTo().window(parentWindowHandle);
        WebElement radioButton = driver.findElement(By.id("bmwradio"));
        radioButton.click();
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
