package org.example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TitleTest {
    private WebDriver driver;
    @Before
    public void setUp() {
         driver = new ChromeDriver();
    }
    @Test
    public void getTitle() {
        driver.get("https://fslc-dev.outsystemsenterprise.com/AtamaiFreight/Landing");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        String title = driver.getTitle();

        System.out.println("Title: " + title);
        //Assert.assertEquals("Home", title);

    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
