package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckboxButton {
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
    public void testBmwCheckButton() throws InterruptedException{
        driver.findElement(By.id("bmwcheck")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("bmwcheck")).isSelected();
        assertTrue(ans);

        boolean ans1 = driver.findElement(By.id("benzcheck")).isSelected();
        assertFalse(ans1);

        boolean ans2 = driver.findElement(By.id("hondacheck")).isSelected();
        assertFalse(ans2);
    }
    @Test
    public void testBenzCheckButton() throws InterruptedException{
        driver.findElement(By.id("benzcheck")).click();
        Thread.sleep(3000);
        boolean ans = driver.findElement(By.id("benzcheck")).isSelected();
        assertTrue(ans);

        boolean ans1 = driver.findElement(By.id("bmwcheck")).isSelected();
        assertFalse(ans1);

        boolean ans2 = driver.findElement(By.id("hondacheck")).isSelected();
        assertFalse(ans2);
    }
    @Test
    public void testHondaCheckButton() throws InterruptedException {
        driver.findElement(By.id("hondacheck")).click();
        driver.findElement(By.id("bmwcheck")).click();
        Thread.sleep(3000);

        boolean ans = driver.findElement(By.id("benzcheck")).isSelected();
        assertFalse(ans);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
