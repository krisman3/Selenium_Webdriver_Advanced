package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputsTestNOTWORKING extends BaseClass{

    @BeforeTest
    public void setUpTest(){
        setUp("chrome", false);
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

        // Since these are not buttons per se - JS script should be used:

        WebElement number_field = driver.findElement(By.cssSelector("div > input[type='number']"));
        String number_field_num = number_field.getText();
        int init_num = Integer.parseInt(number_field_num);

        // Exec. the script here:
        js.executeScript("arguments[0].stepUp();" , number_field);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", number_field);


        WebElement updated_number_field = driver.findElement(By.cssSelector("div > input[type='number']"));
        String upd_field_num = number_field.getText();
        int upd_num = Integer.parseInt(upd_field_num);

        Assert.assertEquals(upd_num,(init_num + 1), "There was no change from the initial number!");

        // Verify that the number input is increased by one
    }


    // Find the button DOWN

    // Click it

    // Verify that the number input is decreased by one
}
