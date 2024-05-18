package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ViewCartPage extends BasePage{

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='cart_info_table']//tr/td[@class='cart_description']//a")
    private List<WebElement> viewCartProductsList;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutElement;

    public void proceedCheckoutProcess(AccountObject accountObject){
        validateCartProducts(accountObject);
        clickProceedCheckout();
    }

    private void clickProceedCheckout(){
        elementMethods.clickOnElement(proceedToCheckoutElement);
    }

    private void validateCartProducts(AccountObject accountObject){
        for (int index = 0; index < viewCartProductsList.size(); index ++){
            String currentTextElement = viewCartProductsList.get(index).getText();
            Assert.assertTrue(accountObject.getProducts().contains(currentTextElement));
        }
    }
}
