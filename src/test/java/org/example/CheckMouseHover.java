package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckMouseHover {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void TestMouseHover () throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.id("mousehover"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mousehover);
        actions.moveToElement(mousehover).perform();
        Thread.sleep(3000);

        WebElement Top = driver.findElement(By.xpath("//a[@href ='#top']"));
        actions.moveToElement(Top).click().perform();
        Thread.sleep(3000);
    }
    @Test
    public void testReload() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mousehover = driver.findElement(By.id("mousehover"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",mousehover );
        actions.moveToElement(mousehover).perform();
        Thread.sleep(3000);

        WebElement Reload = driver.findElement(By.partialLinkText("Reload"));
        actions.moveToElement(Reload).click().perform();
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
    driver.close();
    }

    }
