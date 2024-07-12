package pages;

import objectData.AccountObject;
import objectData.ProductObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ViewCartPage extends BasePage{

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutElement;

    public void proceedCheckoutProcess(AccountObject accountObject){
        validateCartProducts(accountObject);
        elementMethods.clickOnElement(proceedToCheckoutElement);
    }
}
