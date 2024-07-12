package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputsTest extends BaseClass{

    @BeforeTest
    public void setUpTest(){
        setUp("edge", false);
    }

//    @AfterTest
//    public void tearDownTest(){
//        tearDown();
//    }


    @Test
    public void inputTestUp(){

        // Grab the page
        driver.get(PagesNames.INPUTS_PAGE);
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Click on the number input field
        WebElement input_field = driver.findElement(By.cssSelector("div > input[type='number']"));
        input_field.click();

        // Type a number (e.g. 236)
        input_field.sendKeys("236");

        // Find the button UP

        WebElement number_field = driver.findElement(By.cssSelector("input[type=number]"));
        js.executeScript();
        // Click it

        // Verify that the number input is increased by one
    }


    // Find the button DOWN

    // Click it

    // Verify that the number input is decreased by one
}
