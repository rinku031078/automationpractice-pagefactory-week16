package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//a[@title='View my customer account']")
    WebElement myAccountName;

    public void verifyMyAccountName(String name){
        verifyThatTextIsDisplayed(myAccountName,name);
        CustomListeners.test.log(Status.PASS,"Verify My Account is displayed: " + name);
    }
}
