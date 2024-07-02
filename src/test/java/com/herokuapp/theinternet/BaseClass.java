package com.herokuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters({"browser"})
    public void setUp(String browser)
    {
        switch (browser)
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");

                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Don't know how to start "+ browser + ", starting Chrome instead!");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
        }
}
