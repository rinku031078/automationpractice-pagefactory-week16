package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurStoresPage extends Utility {

    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement popUpOkButton;

    @CacheLookup
    @FindBy(id = "map")
    WebElement map;

    @CacheLookup
    @FindBy (xpath = "//button[@title='Zoom out']")
    WebElement zoomOutButton;


    public void clickOnOkButtonForPopUp() throws InterruptedException {
        Thread.sleep(1000);
        doClickOnElement(popUpOkButton);
        CustomListeners.test.log(Status.PASS,"Click ok on Pop Up ");
    }

    public void scrollThroughMap() throws InterruptedException {
        Thread.sleep(1000);
        doClickOnElement(zoomOutButton);
        doClickOnElement(zoomOutButton);
        Actions builder = new Actions(driver);
        Action dragTheMap = builder.clickAndHold(map).moveByOffset(20, -200).moveToElement(map)
                .release(map)
                .build();
        dragTheMap.perform();
        CustomListeners.test.log(Status.PASS,"Scroll through map ");
//        Action dragTheMap2 = builder.clickAndHold(map).moveByOffset(50, -600).moveToElement(map)
//                .release(map)
//                .build();
//        dragTheMap2.perform();
    }

    public void takeScreenshot(){
        javaExecutorScriptExecuteScriptToPerformScroll();
        takeScreenShot();
        CustomListeners.test.log(Status.PASS,"Take Screenshot ");
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void javaExecutorScriptExecuteScriptToPerformScroll()
    {
        js.executeScript("window.scrollBy(0,300)");
    }

}
