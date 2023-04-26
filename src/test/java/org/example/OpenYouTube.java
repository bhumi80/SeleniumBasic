package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenYouTube {
       @Test
    public void searchProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("search_query")).click();
        driver.findElement(By.name("search_query")).sendKeys("relaxing music");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']")).click();


        //driver.findElement(By.xpath("//input[@id = 'search']")).click();
        //driver.findElement(By.xpath("//input[@id = 'search']")).sendKeys("BBC news");
        //driver.findElement(By.className("style-scope ytd-searchbox")).click();
           // driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope yt-chip-cloud-chip-renderer']")).click();
    }


}
