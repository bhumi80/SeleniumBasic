package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NopCommerceMultipleTab {
    public WebDriver driver;
    public String url = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void multipleTabs() throws InterruptedException {
        WebElement homeTab = driver.findElement(By.xpath("//a[@href='/computers']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).moveToElement(homeTab).click().perform();
        Thread.sleep(3000);

        WebElement secondTab = driver.findElement(By.xpath("//a[@href='/desktops']"));
        action.keyDown(Keys.CONTROL).moveToElement(secondTab).click().perform();
        Thread.sleep(3000);

        Set<String> allWindowHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>();
        handles.addAll(allWindowHandles);
        System.out.println("All window handles :"+ " "+allWindowHandles);

        driver.switchTo().window(handles.get(1));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/lenovo-ideacentre-600-all-in-one-pc']")).click();
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(handles.get(0));

    }
    @After
    public void tearDown(){

        driver.close();
    }
}
