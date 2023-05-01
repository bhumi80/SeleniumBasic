package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestCase.assertEquals;

public class TextValidationWithImplicitWait {
    public WebDriver driver;
    public String url = "https://www.letskodeit.com/practice";
    String expectedText = "SIGN IN";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }
    @Test
    public void testSignInText() throws InterruptedException {
        Thread.sleep(3000);
        String actualText = driver.findElement(By.xpath("//a[@style = 'font-size: 14px;padding: 25px 15px;text-transform: uppercase;letter-spacing: 1px']")).getText();
        System.out.println(actualText);

        assertEquals("Test falied",expectedText,actualText);

    }
    @After
    public void tearDown(){
        driver.close();
    }


}
