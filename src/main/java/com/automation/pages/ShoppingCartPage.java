package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends Utility {

    public ShoppingCartPage() {PageFactory.initElements(driver, this);}

    @CacheLookup
    @FindBy (xpath = "//i[@class='icon-trash']")
    WebElement deleteButton;

    @CacheLookup
    @FindBy (xpath = "//p[contains(text(),'Your shopping cart is empty.')]")
    WebElement cartEmptyMessage;


    public void clickOnDeleteButton(){
        doClickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS,"Click on Delete button ");
    }

    public void verifyShoppingCartEmptyMessage(String message){
//        verifyThatTextIsDisplayed(cartEmptyMessage,message);
        System.out.println(doGetTextFromElement(cartEmptyMessage));
        doVerifyElements(cartEmptyMessage,"Your shopping cart is empty.","Your shopping cart is empty.");
        CustomListeners.test.log(Status.PASS,"Your Verify 'Shopping cart is empty' message: " + cartEmptyMessage);
    }

}
