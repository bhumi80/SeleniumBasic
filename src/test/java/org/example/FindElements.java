package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindElements {
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
    public void getElements(){
       List<WebElement> labelElements = driver.findElements(By.xpath("//div[@id='radio-btn-example']/fieldset/label"));
        ArrayList<String> actualtext = new ArrayList<String>();

        for (WebElement labelElement:labelElements) {
            System.out.println(labelElement.getText());
        }
        for (WebElement labelElement:labelElements) {
          actualtext.add(labelElement.getText());
        }
        System.out.println(actualtext);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
