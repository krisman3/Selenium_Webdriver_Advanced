package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class MyDataProviders
{
    @DataProvider(name = "userDataProvider")
    public static Object[][] userDataProvider()
    {
        return new Object[][]
                {
                        {"1234"},
                        {""},
                        {"asdbsas"}
                };
    }
}
