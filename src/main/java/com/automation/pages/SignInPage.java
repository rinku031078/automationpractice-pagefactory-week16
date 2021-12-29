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

public class SignInPage extends Utility {

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationMessage;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement createAccountEmail;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement emailRequiredError;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Password is required.')]")
    WebElement passwordRequiredError;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement invalidEmail;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authenticationFailed;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;


    public void verifyAuthenticationMessage(String text) {
        verifyThatTextIsDisplayed(authenticationMessage, text);
        CustomListeners.test.log(Status.PASS, "Verify 'Authentication' message is displayed " + text);
    }

    public void inputEmailAddress(String text) {
        doSendTextToElement(emailAddressField, text);
        CustomListeners.test.log(Status.PASS, "Enter email address: " + text);
    }

    public void inputPassword(String text) {
        doSendTextToElement(passwordField, text);
        CustomListeners.test.log(Status.PASS, "Enter password: " + text);
    }

    public void clickOnSignInButton() {
        doClickOnElement(signInButton);
        CustomListeners.test.log(Status.PASS, "Click on Sign In button ");
    }

    public void verifySignOutLinkIsVisible() {
        verifyThatElementIsDisplayed(logoutButton);
        CustomListeners.test.log(Status.PASS, "Verify Sign Out link is visible ");
    }

    public void clickOnSignOutLink() {
        doClickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS, "Click on Sign Out button ");
    }

    public void verifySignInLinkVisible() {
        verifyThatElementIsDisplayed(signInLink);
        CustomListeners.test.log(Status.PASS, "Verify Sign In link is visible ");
    }

    public void inputEmailToCreateAccount(String text) {
        doSendTextToElement(createAccountEmail, text);
        CustomListeners.test.log(Status.PASS, "Enter email to create account: " + text);
    }

    public void clickOnCreateAccountButton() {
        doClickOnElement(createAccountButton);
        CustomListeners.test.log(Status.PASS, "Click on Create Account button ");
    }

    public void inputCredentials(String username, String password) {
        doSendTextToElement(emailAddressField, username);
        CustomListeners.test.log(Status.PASS, "Enter username: " + username);

        doSendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password: " + password);
    }

    // This method will get error message
    public void verifyErrorMessage(String errorMessage) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMessage)) {
                break;
            }
        }
    }
}
