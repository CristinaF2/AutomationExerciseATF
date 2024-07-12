package pages;

import objectData.AccountObject;
import objectData.ProductObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage extends  BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id='address_delivery']/li")
    private List<WebElement> deliveryAddressDetails;

    @FindBy(xpath = "//ul[@id='address_invoice']/li")
    private List<WebElement> billingAddressDetails;

    @FindBy(xpath = "//div/textarea[@name='message']")
    private WebElement messageElement;

    @FindBy(xpath = "//a[text()='Place Order']")
    private WebElement placeOrderElement;

    private void validateDeliveryAddressDetails(AccountObject accountObject){

        Assert.assertEquals(accountObject.getAccountInfo().getTitle()+" "+accountObject.getAccountAddress().getFirstName()+" "+accountObject.getAccountAddress().getLastName(), deliveryAddressDetails.get(1).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCompany(),deliveryAddressDetails.get(2).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getAddress1(),deliveryAddressDetails.get(3).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getAddress2(),deliveryAddressDetails.get(4).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCity()+" "+accountObject.getAccountAddress().getState()+" "+accountObject.getAccountAddress().getZipCode(),deliveryAddressDetails.get(5).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCountry(),deliveryAddressDetails.get(6).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getMobileNumber(),deliveryAddressDetails.get(7).getText());
    }
    private void validateBillingAddressDetails(AccountObject accountObject){

        Assert.assertEquals(accountObject.getAccountInfo().getTitle()+" "+accountObject.getAccountAddress().getFirstName()+" "+accountObject.getAccountAddress().getLastName(), deliveryAddressDetails.get(1).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCompany(),deliveryAddressDetails.get(2).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getAddress1(),deliveryAddressDetails.get(3).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getAddress2(),deliveryAddressDetails.get(4).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCity()+" "+accountObject.getAccountAddress().getState()+" "+accountObject.getAccountAddress().getZipCode(),deliveryAddressDetails.get(5).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getCountry(),deliveryAddressDetails.get(6).getText());
        Assert.assertEquals(accountObject.getAccountAddress().getMobileNumber(),deliveryAddressDetails.get(7).getText());
    }

    private void addComment(AccountObject accountObject){
        elementMethods.fillElement(messageElement,accountObject.getAccountAddress().getComment());
        elementMethods.clickOnElementWithJS(placeOrderElement);
    }

    public void validateCheckoutPage(AccountObject accountObject){
        validateBillingAddressDetails(accountObject);
        validateDeliveryAddressDetails(accountObject);
        validateCartProducts(accountObject);
        validateTotalPrice(accountObject);
        addComment(accountObject);
    }
}
