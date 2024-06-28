package com.herokuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NegativeTests
{
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUpTest()
    {
//           System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }

    /**
     * Putting an incorrect username and correct password
     */
    @Test(dataProvider = "incorrectUserDataProvider", dataProviderClass = MyDataProviders.class)
    public void incorrectUsernameTest(String usernames)
    {
        System.out.println("Incorrect username test started!");

        String BASE_URL = "https://the-internet.herokuapp.com/login";

        // Open test page
        driver.get(BASE_URL);

        driver.manage().window().maximize();

        // Check if we're on the correct page
        String curr_page = driver.getCurrentUrl();
        Assert.assertEquals(curr_page, BASE_URL);


        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.click();
        username.sendKeys(usernames);


        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys("SuperSecretPassword!");


        // Click Login button
        WebElement login_button = driver.findElement(By.cssSelector("#login > button > i"));
        login_button.click();


        WebElement invalid_username = driver.findElement(By.xpath("//div[@class='flash error']"));
        String text_invalid_usr = invalid_username.getText();
        Assert.assertEquals(text_invalid_usr, "Your username is invalid!\n×");
        System.out.println("Incorrect username test ended!");
    }

    @Test(dataProvider = "incorrectPassDataProvider", dataProviderClass = MyDataProviders.class)
    public void incorrectPasswordTest(String passwords)
    {
        System.out.println("Incorrect password test started!");

        String BASE_URL = "https://the-internet.herokuapp.com/login";


        // Open test page
        driver.get(BASE_URL);

        driver.manage().window().maximize();


        // Check if we're on the correct page
        String curr_page = driver.getCurrentUrl();
        Assert.assertEquals(curr_page, BASE_URL);


        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.click();
        username.sendKeys("tomsmith");


        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys(passwords);


        // Click Login button
        WebElement login_button = driver.findElement(By.cssSelector("#login > button > i"));
        login_button.click();


        WebElement invalid_username = driver.findElement(By.xpath("//div[@class='flash error']"));
        String text_invalid_usr = invalid_username.getText();
        Assert.assertEquals(text_invalid_usr, "Your password is invalid!\n×");
        System.out.println("Incorrect password test ended!");
    }




}
