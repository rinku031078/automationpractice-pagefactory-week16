package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDressesPage extends Utility {

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//span[@class='cat-name']")
    WebElement summerDressesText;

    @CacheLookup
    @FindBy (xpath = "//div[@id='left_column']//a[2]")
    WebElement slider;

    public void verifySummserDressesText(String message){
        verifyThatTextIsDisplayed(summerDressesText, message);
        CustomListeners.test.log(Status.PASS, "Verify Summer Dresses Text: " + message);
    }

    public void moveSlider() throws InterruptedException {

        Actions action= new Actions(driver);
        action.click(slider).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 75; i++)
        {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
        CustomListeners.test.log(Status.PASS, "Move slider to desired price range " );

    }
}
