package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.OurStoresPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class OurStoresTest extends TestBase {

    HomePage homePage;
    OurStoresPage ourStoresPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        ourStoresPage = new OurStoresPage();
    }

    @Test (groups = {"sanity"})
    public void verifyUserShouldBrowseOurStorePage() throws InterruptedException {
        homePage.clickOnOurStoresLink();
        ourStoresPage.clickOnOkButtonForPopUp();
        ourStoresPage.scrollThroughMap();
        ourStoresPage.takeScreenshot();
    }
}
