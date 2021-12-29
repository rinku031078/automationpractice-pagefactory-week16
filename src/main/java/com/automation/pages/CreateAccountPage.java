package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='radio']")
    WebElement selectTitle;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @CacheLookup
    @FindBy(id = "lastname")
    WebElement addressLastName;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement addressLine1;

    @CacheLookup
    @FindBy(id = "city")
    WebElement addressCity;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement addressState; // dropdown

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement addressPostcode;     // only 5 digits

    @CacheLookup
    @FindBy(id = "id_country")
    WebElement addressCountry;  // dropdown

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountText;


    public void enterPersonalInformation(String name, String lstName, String title, String passwrd){
        doclickOnElement(selectTitle, title);      // select title
        CustomListeners.test.log(Status.PASS,"Select title: " + title);

        doSendTextToElement(firstName, name);     // Input First Name
        CustomListeners.test.log(Status.PASS,"Enter First name: " + name);

        doSendTextToElement(lastName, lstName);     // Input Last Name
        CustomListeners.test.log(Status.PASS,"Enter Last name: " + lstName);

        doSendTextToElement(password, passwrd);     // Input password Name
        CustomListeners.test.log(Status.PASS,"Enter Password: " + passwrd);
    }

    public void enterAddressDetails(String fName, String lstName,
                                    String address, String city, String state, String postcode, String mobile){
        doSendTextToElement(addressFirstName, fName);      // Address first name
        CustomListeners.test.log(Status.PASS,"Enter First name for address field: " + fName);

        doSendTextToElement(addressLastName, lstName);       // Address last name
        CustomListeners.test.log(Status.PASS,"Enter Last name for address field: " + lstName);

        doSendTextToElement(addressLine1, address);       // Address
        CustomListeners.test.log(Status.PASS,"Enter first line of address: " + address);

        doSendTextToElement(addressCity, city);       // Address City name
        CustomListeners.test.log(Status.PASS,"Enter city: " + city);

        doSelectByVisibleTextFromDropDown(addressState, state);  // Address State
        CustomListeners.test.log(Status.PASS,"Select state from dropdown: " + state);

        doSendTextToElement(addressPostcode, postcode);   // Postalcode
        CustomListeners.test.log(Status.PASS,"Enter Postal code: " + postcode);

        doSendTextToElement(mobilePhone, mobile);     // mobile number
        CustomListeners.test.log(Status.PASS,"Enter mobile number: " + mobile);
    }

    public void clickOnRegisterButton(){
        doClickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS,"Click on register button ");
    }

    public void verifyMyAccountText(String text){
        verifyThatTextIsDisplayed(myAccountText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'My Account' text is displayed " + text);
    }

}
