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

public class ElementHideAndDisplayed {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//div[@class='cancel-button cookie_box_close']")).click();
        Actions actions = new Actions(driver);
    }
    @Test
    public void testHideButton() throws InterruptedException{
        WebElement hide = driver.findElement(By.id("hide-textbox"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",hide );
        driver.findElement(By.id("hide-textbox")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("displayed-text")).isDisplayed();
        assertFalse(ans);
    }
    @Test
    public void testShowButton() throws InterruptedException{
        WebElement show = driver.findElement(By.id("show-textbox"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",show );
        driver.findElement(By.id("show-textbox")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("displayed-text")).isDisplayed();
        assertTrue(ans);
        driver.findElement(By.id("displayed-text")).sendKeys("Bhumika");
        Thread.sleep(2000);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
