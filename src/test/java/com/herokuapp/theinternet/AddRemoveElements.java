package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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


    @Test
    public void addElement()
    {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        String curr_url = driver.getCurrentUrl();
        Assert.assertEquals(curr_url, "https://the-internet.herokuapp.com/add_remove_elements/", "Incorrect URL." );

        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        wait.until(ExpectedConditions.visibilityOf(addElement));
        String addElement_content = addElement.getText();
        Assert.assertEquals(addElement_content, "Add Element", "Incorrect content of the button.");


        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        int init_elements_count = elements.size();
        System.out.println("Initial size of the elements list: " + (init_elements_count) );

        // Click and add a new element:
        addElement.click();
        List<WebElement> updated_elements = driver.findElements(By.className("added-manually"));
        System.out.println("Updated size of the elements list: " + (updated_elements.size()) );
        Assert.assertEquals(updated_elements.size(), init_elements_count+1, "Elements already exist.");

    }

    @Test
    public void deleteElement()
    {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        String curr_url = driver.getCurrentUrl();
        Assert.assertEquals(curr_url, "https://the-internet.herokuapp.com/add_remove_elements/", "Incorrect URL." );

        // Add a bunch of elements:
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        wait.until(ExpectedConditions.visibilityOf(addElement));
        String addElement_content = addElement.getText();
        Assert.assertEquals(addElement_content, "Add Element", "Incorrect content of the button.");
        for(int i = 0; i < 3; i++)
        {
            addElement.click();
        }


        List<WebElement> avail_elements = driver.findElements(By.className("added-manually"));
        if (avail_elements.isEmpty())
        {
            System.out.println("No elements added!");
        }
        int count_el = avail_elements.size();
        System.out.println("Number of elements: " + count_el);

        WebElement deleteElement = driver.findElement(By.xpath("//*[@id='elements']/button[3]"));
        deleteElement.click();

        List<WebElement> updated_els = driver.findElements(By.className("added-manually"));
        System.out.println("Num of elements after deletion: " + updated_els.size());
        Assert.assertEquals(updated_els.size(), (count_el-1), "Incorrect number of elements.");
    }
}
