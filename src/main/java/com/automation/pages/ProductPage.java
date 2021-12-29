package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage() {PageFactory.initElements(driver, this);}

    @CacheLookup
    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "group_1")
    WebElement selectSize;

    @CacheLookup
    @FindBy(className = "attribute_list")
    WebElement color;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeButton;

    @CacheLookup
    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public void addProductAttribute(String qty, String size, String colour) {
        doSendTextToElement(quantity, Keys.BACK_SPACE + qty);
        CustomListeners.test.log(Status.PASS,"Enter quantity: " + qty);

        doSelectByVisibleTextFromDropDown(selectSize, size);
        CustomListeners.test.log(Status.PASS,"Select size from dropdown: " + size);

        doclickOnElement(color, colour);
        CustomListeners.test.log(Status.PASS,"Click on colour " + colour);
    }

    public void clickOnAddToCartButton(){
        doClickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click on Add to cart button ");
    }

    public void verifyProductAddedToCartMessage(String text){
        verifyThatTextIsDisplayed(popUpDisplay, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Product added to cart' message " + text);
    }

    public void clickOnCloseButton(){
        doClickOnElement(closeButton);
        CustomListeners.test.log(Status.PASS,"Click on close button ");
    }

    public void clickOnProceedToCheckoutButton(){
        doClickOnElement(proceedToCheckoutButton);
        CustomListeners.test.log(Status.PASS,"Click on Proceed to Checkout Button ");
    }

}
