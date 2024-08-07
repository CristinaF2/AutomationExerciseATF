package tests;

import objectData.AccountObject;
import org.testng.annotations.Test;
import pages.*;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;

public class BuyProductTest extends SharedData {

    @Test
    public void testMethod(){
        PropertyUtility propertyUtility = new PropertyUtility("testData/BuyProductData");
        AccountObject accountObject=new AccountObject(propertyUtility.getAllData());

        HomePage homePage=new HomePage(getWebDriver());
        homePage.clickConsentButton(accountObject);
        homePage.navigateMenuOption(PageType.MENU_SIGNUPLOGIN);

        LoginRegisterPage loginRegisterPage=new LoginRegisterPage(getWebDriver());
        loginRegisterPage.fillSignUpForm(accountObject);

        SignUpPage signUpPage=new SignUpPage(getWebDriver());
        signUpPage.fillSignUpForm(accountObject);

        AccountCreatedPage accountCreatedPage=new AccountCreatedPage(getWebDriver());
        accountCreatedPage.validateAccountCreated(accountObject);
        accountCreatedPage.navigateMenuOption(PageType.MENU_PRODUCTS);
//
//        ProductsPage productsPage=new ProductsPage(getWebDriver());
//        productsPage.addProductToCart(accountObject);
//        productsPage.navigateMenuOption(PageType.MENU_CART);
//
//        ViewCartPage viewCartPage = new ViewCartPage(getWebDriver());
//        viewCartPage.proceedCheckoutProcess(accountObject);
//
//        CheckoutPage checkoutPage=new CheckoutPage(getWebDriver());
//        checkoutPage.validateCheckoutPage(accountObject);
//        //validari pe pagina de checkout
//
//        PaymentPage paymentPage=new PaymentPage(getWebDriver());
//        paymentPage.fillCardDetails(accountObject);
//
//        PaymentDonePage paymentDonePage=new PaymentDonePage(getWebDriver());
//        paymentDonePage.checkIfOrderIsConfirmed(accountObject);

        ContactUsPage contactUsPage=new ContactUsPage(getWebDriver());
        contactUsPage.navigateMenuOption(PageType.MENU_CONTACT);
        contactUsPage.fillContactForm(accountObject);
    }
}
