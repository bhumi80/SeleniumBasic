package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MultipleSelect {
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
    public void testMultipleSelect() throws InterruptedException {
        WebElement multiple = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiple);
        select.selectByValue("apple");
        Thread.sleep(2000);

        select.selectByIndex(1);
        Thread.sleep(2000);

        select.selectByVisibleText("Peach");
        Thread.sleep(2000);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
        @After
    public void tearDown(){
        driver.close();
    }
}
