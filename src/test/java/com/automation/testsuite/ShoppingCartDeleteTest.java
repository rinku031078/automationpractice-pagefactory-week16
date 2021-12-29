package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.ShoppingCartPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ShoppingCartDeleteTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    WomenCategoryPage womenCategoryPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod (groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        productPage = new ProductPage();
        womenCategoryPage = new WomenCategoryPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test (groups = {"regression"}, dataProvider = "product", dataProviderClass = TestData.class)
    public void verifyUserShouldRemoveProductFromCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
        homePage.selectMenu("Women");
        womenCategoryPage.selectProduct(product);
        productPage.addProductAttribute(qty, size, colour);
        productPage.clickOnAddToCartButton();
        productPage.verifyProductAddedToCartMessage("Product successfully added to your shopping cart");
        productPage.clickOnProceedToCheckoutButton();
        shoppingCartPage.clickOnDeleteButton();
        shoppingCartPage.verifyShoppingCartEmptyMessage("Your shopping cart is empty.");
    }

}
