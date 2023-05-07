package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertAndConfirmButton {
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
    public void testAlertButton() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Bhumika Patel");
        Thread.sleep(3000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
    @Test
    public void testConfirmButton() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys("Bhumika Patel");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
