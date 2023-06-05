package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginButton() {
        driver.get("https://fslc-dev.outsystemsenterprise.com/AtamaiFreight/Landing");

        // Wait until element exists
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("userinfo-container")));

        loginButton.click();

        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        // Get current URL after clicking login button
        String currentUrl = driver.getCurrentUrl();

        // Assert.assertNotEquals("https://fslc-dev.outsystemsenterprise.com/AtamaiFreight/Landing", currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}