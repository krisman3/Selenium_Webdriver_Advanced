package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class InfiniteScrollTest extends BaseClass{

    @Parameters({"browser","false"})
    @BeforeTest
    public void setUpTest(@Optional("edge") String browser, @Optional("false") String headless){
        setUp(browser, false);
    }

    public void InfiniteScrollingTest(){
        // Open the page
        driver.get(PagesNames.INF_SCROLL);
        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals(currentPage, PagesNames.INF_SCROLL);
        // Make sure there's only 2 paragraphs visible
        // Scroll down and assert that a new paragraph popped up
        // Scroll down again and assert that new paragraphs keep coming
    }
}
