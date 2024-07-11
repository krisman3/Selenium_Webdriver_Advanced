package com.herokuapp.theinternet.tests;

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

    @DataProvider(name = "incorrectUserDataProvider")
    public static Object[][] incorrectUserDataProvider()
    {
        return new Object[][]
                {
                        {"user1"},
                        {""},
                        {"1235"},
                        {"..//-"}
                };
    }
}
