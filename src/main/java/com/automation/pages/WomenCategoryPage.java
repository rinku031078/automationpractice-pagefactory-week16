package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends Utility {

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='category-name']")
    WebElement womenText;

    @CacheLookup
    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productsList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Blouse']")
    WebElement blouse;

    @CacheLookup
    @FindBy(xpath = "(//a[@title='Printed Dress'][normalize-space()='Printed Dress'])[1]")
    WebElement printedDress;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement priChiDress;

    @CacheLookup
    @FindBy(xpath = "(//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress'])[2]")
    WebElement summerDress;

    @CacheLookup
    @FindBy (xpath = "(//a[@class='product_img_link']//img)[1]")
    WebElement faddedshortSleeveTShirt;

    public void verifyWomenText(String text) {
        verifyThatTextIsDisplayed(womenText, text);
        CustomListeners.test.log(Status.PASS, "Verify Women text is visible " + text);
    }


    public void selectProduct(String proName) {
        if (proName.equalsIgnoreCase("Blouse")) {
            doClickOnElement(blouse);
            CustomListeners.test.log(Status.PASS, "Click on Blouse " + blouse);

        } else if (proName.equalsIgnoreCase("Printed Dress")) {
            doMouseHoverAndClick(printedDress);
            CustomListeners.test.log(Status.PASS, "Click on Printed Dress " + printedDress);

        } else if (proName.equalsIgnoreCase("Printed Chiffon Dress")) {
            doClickOnElement(priChiDress);
            CustomListeners.test.log(Status.PASS, "Click on Add product to cart " + priChiDress);

        } else if (proName.equalsIgnoreCase("Printed Summer Dress with Price $28.98")) {
            doClickOnElement(summerDress);
            CustomListeners.test.log(Status.PASS, "Click on Summer Dress " + summerDress);

        }else if (proName.equalsIgnoreCase("Faded Short Sleeve T-shirts")){
            doClickOnElement(faddedshortSleeveTShirt);
            CustomListeners.test.log(Status.PASS, "Click on Fadded Short Sleeve T-Shirt " + faddedshortSleeveTShirt);
        }
    }
}
