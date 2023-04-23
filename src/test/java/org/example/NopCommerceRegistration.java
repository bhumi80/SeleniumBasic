package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceRegistration {
    @Test
    public void CheckRegistration() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.name("FirstName")).sendKeys("Bhumika");
        driver.findElement(By.name("LastName")).sendKeys("Suthar");
        Thread.sleep(3000);
        driver.findElement(By.name("Email")).sendKeys("sutharbb80@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Pass123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Pass123");
        Thread.sleep(3000);
        driver.findElement(By.name("register-button")).click();
        driver.close();


    }
}
