package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputsTest extends BaseClass{

    @BeforeTest
    public void setUpTest(){
        setUp("edge", true);
    }

    @AfterTest
    public void tearDownTest(){
        tearDown();
    }


    @Test
    public void inputTestUp(){

        // Grab the page
        driver.get(PagesNames.INPUTS_PAGE);

        // Click on the number input field
        WebElement input_field = driver.findElement(By.cssSelector("div > input[type='number']"));

        // Type a number (e.g. 236)

        // Find the button UP

        // Click it

        // Verify that the number input is increased by one
    }


    // Find the button DOWN

    // Click it

    // Verify that the number input is decreased by one
}
