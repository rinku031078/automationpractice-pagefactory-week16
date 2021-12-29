package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class SummerDressesTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    WomenCategoryPage womenCategoryPage;
    ShoppingCartPage shoppingCartPage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        productPage = new ProductPage();
        womenCategoryPage = new WomenCategoryPage();
        shoppingCartPage = new ShoppingCartPage();
        summerDressesPage = new SummerDressesPage();
    }

    @Test (groups = {"sanity"})
    public void verifyUserShouldNavigateToSummerCollection(){
        homePage.mouseHoverOnWomenTab();
        homePage.clickOnSummerDresses();
        summerDressesPage.verifySummserDressesText("Summer Dresses");
    }

}
