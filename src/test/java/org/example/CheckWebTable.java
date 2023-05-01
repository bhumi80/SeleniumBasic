package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckWebTable {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//div[@class='cancel-button cookie_box_close']")).click();
        Actions actions = new Actions(driver);
    }
    @Test
    public void testWebTable() throws InterruptedException {
        WebElement mousehover = driver.findElement(By.id("mousehover"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",mousehover );
        driver.findElement(By.xpath("//table[@class='table-display']"));
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@id='product']/tbody/tr[2]/td[1]")).getText() +"  ");
        System.out.println (driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/fieldset/table/tbody/tr[2]/td[2]")).getText() +"  ");
        System.out.println(driver.findElement(By.xpath("//*[@id='product']/tbody/tr[2]/td[3]")).getText());
        Thread.sleep(2000);


    }
    @After
    public void tearDown(){
       driver.close();
    }
}
