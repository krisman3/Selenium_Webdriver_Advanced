package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragNDropTest extends BaseClass{


    @BeforeTest
    public void setUpTest()
    {
        setUp("chrome", false);
    }

    @AfterTest
    public void tearDownTest()
    {
        tearDown();
    }

    @Test
    public void DragNDropTests()
    {
        Actions action = new Actions(driver);
        driver.get(PagesNames.DRAG_PAGE);

        // Grab the column A + the text of the current box
        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxA_header = driver.findElement(By.cssSelector("#column-a > header"));
        String boxA_text = boxA_header.getText();
        Assert.assertEquals(boxA_text, "A");

        // Grab the column B + the text of the current box
        WebElement boxB = driver.findElement(By.id("column-b"));
        WebElement boxB_header = driver.findElement(By.cssSelector("#column-b > header"));
        String boxB_text = boxB_header.getText();
        Assert.assertEquals(boxB_text, "B");

        // Drag and drop box A into box B

        action.dragAndDrop(boxA, boxB).perform();
        // Alternative way to do this:
//        action.clickAndHold(boxA).moveToElement(boxB).release().perform();

        // Check the new header texts
        WebElement boxA_header_new = driver.findElement(By.cssSelector("#column-a > header"));
        String boxA_text_new = boxA_header_new.getText();
        WebElement boxB_header_new = driver.findElement(By.cssSelector("#column-b > header"));
        String boxB_text_new = boxB_header_new.getText();

        // Confirm that column A now contains boxB
        Assert.assertEquals(boxA_text_new, "B", "Column A content incorrect.");
        Assert.assertEquals(boxB_text_new, "A", "Column A content incorrect.");


    }
}
