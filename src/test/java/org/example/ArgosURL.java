package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArgosURL {
    @Test
    public void openArgos() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.argos.co.uk/");
        driver.findElement(By.id("consent_prompt_submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("searchTerm")).click();
        driver.findElement(By.name("searchTerm")).sendKeys("toys");
        driver.findElement(By.xpath("//button[@class='_2mKaC']")).click();
        driver.findElement(By.xpath("//button[@class='Buttonstyles__Button-sc-42scm2-2 iducRP btn-cta']")).click();

        Thread.sleep(3000);
        driver.close();


    }
}
