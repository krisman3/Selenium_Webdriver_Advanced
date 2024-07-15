package com.herokuapp.theinternet.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters({"browser", "headless"})
    public void setUp(String browser, boolean headless)
    {
        switch (browser)
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if(headless)
                {
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("disable-gpu");
                }

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);

                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(headless)
                {
                    edgeOptions.addArguments("headless");
                    edgeOptions.addArguments("disable-gpu");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Don't know how to start "+ browser + ", starting Chrome instead!");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }

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
