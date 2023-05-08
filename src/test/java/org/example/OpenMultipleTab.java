package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenMultipleTab {
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
    public void CheckMultipleTabs() throws InterruptedException {
      WebElement main =  driver.findElement(By.xpath("//a[@href='/home']"));
      Actions action = new Actions(driver);
      action.keyDown(Keys.CONTROL).moveToElement(main).click().perform();
      Thread.sleep(3000);
      System.out.println("Main page title:" + " " +driver.getTitle());

      WebElement secondTab = driver.findElement(By.xpath("//a[@href='/courses']"));
      Thread.sleep(3000);
      System.out.println("Second page tab title :" + " "+ driver.getTitle());

      action.keyDown(Keys.CONTROL).moveToElement(secondTab).click().perform();
      System.out.println("Third page tab title :" + " "+driver.getTitle());

      //set window handles and put in to arraylist to print
        Set<String > windowHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>();
        handles.addAll(windowHandles);
        System.out.println("Print all handles" + " "+ windowHandles);

        //switch from one tab to another
        driver.switchTo().window(handles.get(1));
        Thread.sleep(3000);

        driver.close();
        driver.switchTo().window(handles.get(2));
        Thread.sleep(3000);

        driver.switchTo().parentFrame();
        Thread.sleep(3000);


    }
    @After
    public void tearDown(){
      driver.close();
    }
}
