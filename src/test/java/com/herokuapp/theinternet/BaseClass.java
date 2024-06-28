package com.herokuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    /**
     * Stop execution for the given amount of time.
     *
     * @param seconds
     */
    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
        }
}
