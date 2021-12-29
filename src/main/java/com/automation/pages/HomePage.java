package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[@title='Women']")
    WebElement women;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoLocator;

    @CacheLookup
    @FindBy (xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
    WebElement summerDresses;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'Our stores')]")
    WebElement ourStoresLink;

    public void clickOnWomenTab(){
        doClickOnElement(women);
        CustomListeners.test.log(Status.PASS,"Click on women tab ");
    }

    public void mouseHoverOnWomenTab(){
        doMouseHoverTo(women);
        CustomListeners.test.log(Status.PASS,"Mouse hover on women tab: " + women);
    }

    public void clickOnSummerDresses(){
        doMouseHoverAndClick(summerDresses);
        CustomListeners.test.log(Status.PASS,"Click on Summer Dresses link ");
    }

    public void clickOnSignInLink(){
        doClickOnElement(signInLink);
        CustomListeners.test.log(Status.PASS,"Click on Sign In button ");
    }

    public void verifyLogoisVisible(){
        verifyThatElementIsDisplayed(logoLocator);
        CustomListeners.test.log(Status.PASS,"Verify Logo is visible ");
    }

    public void clickOnOurStoresLink(){
        doClickOnElement(ourStoresLink);
        CustomListeners.test.log(Status.PASS,"Click on Our Stroes link " );
    }

    // This method will select top menu categroy
    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }

}
