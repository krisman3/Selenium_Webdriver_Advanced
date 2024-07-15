package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class CheckBoxesTest extends BaseClass {

    @Parameters({"browser", "headless"})
    @BeforeTest
    public void setUpTest(@Optional("edge") String browser, @Optional("true") String headless) {
        setUp(browser, Boolean.parseBoolean(headless));
    }

    @AfterTest
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void toggleCheckboxes() {
        // Go to page
        driver.get(PagesNames.CHECKBOX_PAGE);
        String curr_url = driver.getCurrentUrl();

        // Double-checking if the page we opened is the correct one:
        Assert.assertEquals(curr_url, PagesNames.CHECKBOX_PAGE, "Incorrect URL!");

        // Finding the form "checkboxes" as an element (if it's present)
        WebElement boxes = driver.findElement(By.id("checkboxes"));
        wait.until(ExpectedConditions.visibilityOf(boxes));

        // Confirming that there's only one checked box upon opening the page:
        List<WebElement> checked_boxes = driver.findElements(By.xpath("//input[@checked]"));
        Assert.assertEquals(checked_boxes.size(), 1, "Only one box must be checked!");

        // Locating and clicking box 1 (top)
        WebElement box1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        box1.click();
        Assert.assertTrue(box1.isSelected(), "The checkbox is not selected.");

        // Locating and clicking box 2 (bottom)
        WebElement box2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        box2.click();
        Assert.assertFalse(box2.isSelected(), "The checkbox is still selected.");
    }
}
