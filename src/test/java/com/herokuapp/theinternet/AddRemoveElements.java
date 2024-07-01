package com.herokuapp.theinternet;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AddRemoveElements extends BaseClass
{
    @BeforeTest
    public void setUpTest()
    {
        setUp("chrome");
    }
    @AfterTest
    public void tearDownTest()
    {
        tearDown();
    }
}
