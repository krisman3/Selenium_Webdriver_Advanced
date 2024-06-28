package com.herokuapp.theinternet;

import com.google.gson.annotations.Until;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveTests extends BaseClass {

    @BeforeTest
    public void setUpTest()
    {
        setUp();
    }

    @AfterTest
    public void tearDownTest()
    {
        tearDown();
    }


    @Test
    public void loginTest() {
        System.out.println("Test started!");

        String BASE_URL = "https://the-internet.herokuapp.com/login";
        String EXP_URL = "https://the-internet.herokuapp.com/secure";



        PageFactory.initElements(driver, this);

        System.out.println("Browser started!");


        // Open test page
        driver.get(BASE_URL);

        driver.manage().window().maximize();
        System.out.println("Page is opened!");


        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.click();
        username.sendKeys("tomsmith");


        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.click();
        password.sendKeys("SuperSecretPassword!");


        // Click Login button
        WebElement login_button = driver.findElement(By.cssSelector("#login > button > i"));
        login_button.click();

        System.out.println("Verifying new page URL.");
        // Verifications
        wait.until(ExpectedConditions.urlToBe(EXP_URL));

        String act_url = driver.getCurrentUrl();
        Assert.assertEquals(act_url, EXP_URL, "The URLs don't match!");


        System.out.println("Verifying that we're on the right page");

        // Check for the green message!
        WebElement logged_message = driver.findElement(By.cssSelector("#flash"));
        try {
            wait.until(ExpectedConditions.visibilityOf(logged_message));
            String mess_content = logged_message.getText();
            Assert.assertEquals(mess_content, "You logged into a secure area!\n×", "Actual: " + mess_content);
        } catch (TimeoutException e) {
            System.out.println(e);
        }

        // Check for the logout button
        WebElement logout_button = driver.findElement(By.cssSelector("#content > div > a > i"));
        try {
            wait.until(ExpectedConditions.visibilityOf(logout_button));
        } catch (TimeoutException e) {
            System.out.println(e);
        }


        // Finish
        driver.manage().window().minimize();
        driver.close();
        System.out.println("Test finished!");
    }

}
