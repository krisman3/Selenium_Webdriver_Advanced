package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes extends BaseClass {

   @BeforeTest
    public void setUpTest()
    {

        setUp("chrome");
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void toggleCheckboxes()
    {
        // Go to page
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        String curr_url = driver.getCurrentUrl();
        Assert.assertEquals(curr_url, "https://the-internet.herokuapp.com/checkboxes", "Incorrect URL!");
        WebElement boxes = driver.findElement(By.id("checkboxes"));
        wait.until(ExpectedConditions.visibilityOf(boxes));

        List<WebElement> checked_boxes = driver.findElements(By.xpath("//input[@checked]"));
        if(checked_boxes.size() != 1)
        {
            System.out.println("Only one box must be checked!");
        }
        System.out.println("Current number of checked boxes: " + checked_boxes.size());

        // Locate both checkboxes

        WebElement box1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        box1.click();
        Assert.assertTrue(box1.isSelected(), "The checkbox is not selected.");

        // Click on checkbox 1

        // Click on checkbox 2
    }


}
