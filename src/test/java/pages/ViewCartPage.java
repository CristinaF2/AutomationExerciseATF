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

    @FindBy(xpath = "//tr/td[@class='cart_description']//a")
    private List<WebElement> tableProductTitleList;
    @FindBy(xpath = "//tr/td[@class='cart_price']/p")
    private List<WebElement> tableProductsPriceList;
    @FindBy(xpath = "//tr/td[@class='cart_quantity']/button")
    private List<WebElement> tableProductsQuantityList;
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
        List<ProductObject> products = accountObject.getProducts();
        for(int index=0;index<accountObject.getProducts().size();index++){
            Assert.assertEquals(products.get(index).getTitle(), tableProductTitleList.get(index).getText());
            Assert.assertEquals(products.get(index).getPrice(), tableProductsPriceList.get(index).getText());
            Assert.assertEquals(products.get(index).getQuantity(), Integer.valueOf(tableProductsQuantityList.get(index).getText()));
        }
    }
}
