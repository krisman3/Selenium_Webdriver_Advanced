package com.herokuapp.theinternet;

import com.herokuapp.theinternet.pages.PagesNames;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
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

    }
}
