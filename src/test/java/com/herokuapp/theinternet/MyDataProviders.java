package com.herokuapp.theinternet;

import org.testng.annotations.DataProvider;

public class MyDataProviders
{
    @DataProvider(name = "incorrectPassDataProvider")
    public static Object[][] incorrectPassDataProvider()
    {
        return new Object[][]
                {
                        {"1234"},
                        {""},
                        {"asdbsas"}
                };
    }
}
