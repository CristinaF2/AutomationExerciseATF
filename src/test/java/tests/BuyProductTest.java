package tests;

import objectData.AccountInfoObject;
import objectData.AccountObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;

public class BuyProductTest extends SharedData {

    @Test
    public void testMethod(){

        PropertyUtility propertyUtility=new PropertyUtility("testData/BuyProductData");
        AccountObject accountObject=new AccountObject(propertyUtility.getAllData());

        HomePage homePage=new HomePage(getWebDriver());
        homePage.navigateMenuOption("Signup / Login");

        LoginRegisterPage loginRegisterPage=new LoginRegisterPage(getWebDriver());
        loginRegisterPage.fillSignUpForm(accountObject);

        SignUpPage signUpPage=new SignUpPage(getWebDriver());
        signUpPage.fillSignUpForm(accountObject);

        AccountCreatedPage accountCreatedPage=new AccountCreatedPage(getWebDriver());
        accountCreatedPage.validateAccountCreated(accountObject);
        accountCreatedPage.navigateMenuOption("Products");

        ProductsPage productsPage=new ProductsPage(getWebDriver());
        productsPage.addProductToCart(accountObject);

    }


}
