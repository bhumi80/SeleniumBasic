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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisableAndEnableButton {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//div[@class='cancel-button cookie_box_close']")).click();
       // driver.manage().window().fullscreen();
    }
    @Test
    public void testDisableButton() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement disable = driver.findElement(By.id("disabled-button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",disable );
        driver.findElement(By.id("disabled-button")).click();
        boolean ans = driver.findElement(By.id("enabled-example-input")).isEnabled();
        assertFalse(ans);
        Thread.sleep(3000);
    }
    @Test
    public void testEnableButton() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement enable = driver.findElement(By.id("enabled-example-input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enable );
        driver.findElement(By.id("enabled-button")).click();
        boolean ans = driver.findElement(By.id("enabled-example-input")).isEnabled();
        assertTrue(ans);
        driver.findElement(By.id("enabled-example-input")).sendKeys("checkbox enable");
        Thread.sleep(3000);
    }


    @After
    public void tearDown(){
        driver.close();
    }
}
