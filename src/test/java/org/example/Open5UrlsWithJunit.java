package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open5UrlsWithJunit {
    public WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void OpenArgos(){
        driver.get("https://www.argos.co.uk/");
    }
    @Test
    public void OpenNext(){
        driver.get("https://www.next.co.uk/");
    }
    @Test
    public void OpenAsda(){
        driver.get("https://www.asda.com/");
    }
    @Test
    public void OpenCurrys(){
        driver.get("https://www.currys.co.uk/");
    }
    @Test
    public void OpenTesco(){
        driver.get("https://www.tesco.com/");
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
