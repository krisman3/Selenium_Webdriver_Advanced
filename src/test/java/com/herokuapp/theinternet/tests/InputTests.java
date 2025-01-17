package com.herokuapp.theinternet.tests;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputTests extends BaseClass {

    @BeforeTest
    public void setUpTest() {
        setUp("chrome", false);
    }

    @AfterTest
    public void tearDownTest()
    {
        tearDown();
    }


    @Test
    public void inputTestUp() {

        // Grab the page
        driver.get(PagesNames.INPUTS_PAGE);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Click on the number input field
        WebElement input_field = driver.findElement(By.cssSelector("div > input[type='number']"));
        input_field.click();

        // Type a number (e.g. 236)
        input_field.sendKeys("236");

        // Since these are not buttons per se - JS script should be used:
        // The getAttribute("value") method was used as there was an IMPLICITLY existing value field within the <input> element.

        String number_field_num = input_field.getAttribute("value");
        int init_num = Integer.parseInt(number_field_num);

        // Exec. the script here:
        js.executeScript("arguments[0].stepUp();", input_field);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", input_field);


        WebElement updated_number_field = driver.findElement(By.xpath("//div[@class='example']/input[@type='number']"));
        String upd_field_num = updated_number_field.getAttribute("value");
        int upd_num = Integer.parseInt(upd_field_num);

        // Verify that the number input is increased by one
        Assert.assertEquals(upd_num, (init_num + 1), "There was no change from the initial number!");

    }

    @Test
    public void inputTestDown() {

        driver.get(PagesNames.INPUTS_PAGE);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement input_field = driver.findElement(By.cssSelector("div > input[type='number']"));
        input_field.click();

        input_field.sendKeys("236");

        // Find the button DOWN (it's not an actual button, so we'll use a JS script)
        // Initially we're getting the content of the <input> as a String, so we need to cast it into int

        String number_field_num = input_field.getAttribute("value");

        int init_num = Integer.parseInt(number_field_num);
        js.executeScript("arguments[0].stepDown();", input_field);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", input_field);

        // Now we update the value by initiating
        WebElement updated_number_field = driver.findElement(By.xpath("//div[@class='example']/input[@type='number']"));
        String upd_field_num = updated_number_field.getAttribute("value");
        int upd_num = Integer.parseInt(upd_field_num);

        // Verify that the number input is decreased by one
        Assert.assertEquals(upd_num, (init_num - 1), "There was no change from the initial number!");

    }

}
