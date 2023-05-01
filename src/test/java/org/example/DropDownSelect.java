package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class DropDownSelect {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    String expectedText = "Benz";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
    @Test
    public void testBenzSelect() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropDown);
        select.selectByValue("benz");
        Thread.sleep(3000);
        String actualText = select.getFirstSelectedOption().getText();
        assertEquals("Test failed",expectedText,actualText);
    }
    @Test
    public void testHondaSelect() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        Thread.sleep(3000);
    }
    @Test
    public void TestSelectAll() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropdown);
        select.selectByIndex(0);
        Thread.sleep(2000);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
