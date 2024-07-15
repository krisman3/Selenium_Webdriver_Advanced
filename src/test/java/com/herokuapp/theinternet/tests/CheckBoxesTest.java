package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTest extends BaseClass {

    @BeforeTest
    public void setUpTest() {

        setUp("chrome", true);
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void toggleCheckboxes() {
        // Go to page
        driver.get(PagesNames.CHECKBOX_PAGE);
        String curr_url = driver.getCurrentUrl();

        // Double-checking if the page we opened is the correct one:
        Assert.assertEquals(curr_url, PagesNames.CHECKBOX_PAGE, "Incorrect URL!");
        WebElement boxes = driver.findElement(By.id("checkboxes"));
        wait.until(ExpectedConditions.visibilityOf(boxes));

        List<WebElement> checked_boxes = driver.findElements(By.xpath("//input[@checked]"));
        Assert.assertEquals(checked_boxes.size(), 1, "Only one box must be checked!");

        // Locate both checkboxes
        WebElement box1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        box1.click();
        Assert.assertTrue(box1.isSelected(), "The checkbox is not selected.");

        // Click on checkbox 1

        // Click on checkbox 2
    }


}
