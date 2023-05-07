package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
public class RadioButton {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    public void testBmwRadioButton() throws InterruptedException{
    driver.findElement(By.id("bmwradio")).click();
    boolean ans = driver.findElement(By.id("bmwradio")).isSelected();
    Thread.sleep(3000);
    assertEquals(true,ans);
    }
    @Test
    public void testBenzRadioButton() throws InterruptedException{
        driver.findElement(By.id("benzradio")).click();
        boolean ans2 = driver.findElement(By.id("benzradio")).isSelected();
        Thread.sleep(3000);
        assertEquals(true,ans2);
    }
    @Test
    public  void testHondaRadioButton() throws InterruptedException{
        boolean ans3 = driver.findElement(By.id("hondaradio")).isSelected();
        Thread.sleep(3000);
        assertEquals(false,ans3);
    }
    @After
    public void tearDown(){
    driver.close();
    }
}
