package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceLocator {
    @Test
    public void CheckLogin() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("Email")).sendKeys("sutharbb80@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("Pass123");
        Thread.sleep(3000);
        driver.close();

    }


}
