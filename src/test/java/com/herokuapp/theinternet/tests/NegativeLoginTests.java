package com.herokuapp.theinternet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeLoginTests extends BaseClass {

    @Parameters({"browser", "headless"})
    @BeforeTest
    public void setUpTest(@Optional("edge") String browser, @Optional("false") String headless) {
        setUp(browser, Boolean.parseBoolean(headless));
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }

    /**
     * Putting an incorrect username and correct password
     */
    @Test(dataProvider = "incorrectUserDataProvider", dataProviderClass = MyDataProviders.class, priority = 1)
    public void incorrectUsernameTest(String usernames) {

        String BASE_URL = "https://the-internet.herokuapp.com/login";

        // Open test page
        driver.get(BASE_URL);

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
    }

    @Test(dataProvider = "incorrectPassDataProvider", dataProviderClass = MyDataProviders.class, priority = 2)
    public void incorrectPasswordTest(String passwords) {
        String BASE_URL = "https://the-internet.herokuapp.com/login";

        // Open test page
        driver.get(BASE_URL);

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
    }
}
