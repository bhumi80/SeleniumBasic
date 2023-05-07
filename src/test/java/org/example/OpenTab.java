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
import java.util.concurrent.TimeUnit;

public class OpenTab {
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
    public void openNewTab() throws InterruptedException {
        WebElement firstLink = driver.findElement(By.xpath("//a[@href='/courses']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).moveToElement(firstLink).click().perform();
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
