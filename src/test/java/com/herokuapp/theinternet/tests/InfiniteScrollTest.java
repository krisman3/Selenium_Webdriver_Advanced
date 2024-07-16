package com.herokuapp.theinternet.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class InfiniteScrollTest extends BaseClass{

    @Parameters({"browser","false"})
    @BeforeTest
    public void setUpTest(@Optional("edge") String browser, @Optional("false") String headless){
        setUp(browser, false);
    }
}
