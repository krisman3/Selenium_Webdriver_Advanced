package com.herokuapp.theinternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PositiveLoginTests extends BaseClass {

    @Parameters({"browser"})
    @BeforeTest
    public void setUpTest(String browser) {
        setUp(browser, true);
    }

    @AfterTest
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void loginTest() {
        System.out.println("Test started!");

        String BASE_URL = "https://the-internet.herokuapp.com/login";
        String EXP_URL = "https://the-internet.herokuapp.com/secure";

        PageFactory.initElements(driver, this);

        // Open test page
        driver.get(BASE_URL);

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

        // Verifications
        wait.until(ExpectedConditions.urlToBe(EXP_URL));

        String act_url = driver.getCurrentUrl();
        Assert.assertEquals(act_url, EXP_URL, "The URLs don't match!");

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
    }
}
