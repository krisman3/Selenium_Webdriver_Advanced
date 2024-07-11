package com.herokuapp.theinternet.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InputsTest extends BaseClass{

    @BeforeTest
    public void setUpTest(){
        setUp("edge", true);
    }

    @AfterTest
    public void tearDownTest(){
        tearDown();
    }


    // Grab the page

    // Click on the number input field

    // Type a number (e.g. 236)

    // Find the button UP

    // Click it

    // Verify that the number input is increased by one

    // Find the button DOWN

    // Click it

    // Verify that the number input is decreased by one
}
