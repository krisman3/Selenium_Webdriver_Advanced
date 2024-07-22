package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollTest extends BaseClass{

    @Parameters({"browser","false"})
    @BeforeTest
    public void setUpTest(@Optional("edge") String browser, @Optional("false") String headless){
        setUp(browser, false);
        driver.manage().window().maximize();
        // Need to implement a new implicit wait as the page in not loading fast enough
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void InfiniteScrollingTest(){
        // Open the page
        driver.get(PagesNames.INF_SCROLL);
        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals(currentPage, PagesNames.INF_SCROLL);
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        action.scrollByAmount(0,500);

        // Make sure there's only 2 paragraphs visible
        // Need to implement a new implicit wait as the page in not loading fast enough
        // It takes roughly 1-2 seconds for the page to load properly, this is why I'm using an explicit wait
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".jscroll-inner > .jscroll-added"), 1));
        List<WebElement> initParagraphs = driver.findElements(By.cssSelector(".jscroll-inner > .jscroll-added"));
        int initialSize = initParagraphs.size();
        Assert.assertEquals(initialSize, 2, "Incorrect number of paragraphs loaded upon start!");

        // Scroll down and assert that a new paragraph popped up
//        js.executeScript("window.scrollBy(0,1500)", "");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".jscroll-inner > .jscroll-added"), initialSize + 1));

        // Scroll down again and assert that new paragraphs keep coming
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".jscroll-inner > .jscroll-added"), initialSize + 1));

        List<WebElement> loadedParagraphs = driver.findElements(By.cssSelector(".jscroll-inner > .jscroll-added"));
        // The paragraph may load a bit slowly - this is why I am putting a wait here:
        wait.until(ExpectedConditions.visibilityOfAllElements(loadedParagraphs));
        List<WebElement> upd1_Paragraphs = driver.findElements(By.cssSelector(".jscroll-inner > .jscroll-added"));
        Assert.assertEquals(upd1_Paragraphs.size(), upd1_Paragraphs.size()+1, "Incorrect number of paragraphs after 1st scroll!");


    }
}
