package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceItem {
    @Test
    public void searchProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("small-searchterms")).click();
        driver.findElement(By.id("small-searchterms")).sendKeys("Gift Cards");
        driver.close();
    }
    @Test
    public void changeCurrency()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("customerCurrency")).click();
        driver.findElement(By.id("customerCurrency")).sendKeys("Euro");
        Thread.sleep(3000);

    }
}
