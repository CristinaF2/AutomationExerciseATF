package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import objectData.AccountObject;
import objectData.ProductObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    //1.mostenire
    //daca o clasa mosteneste o alta clasa din acelasi pachet => apare protected
    //daca o clasa mosteneste o alta clasa din alt pachet => apare protected
    //2.obiect
    //daca o clasa este instantiata intr o alta clasa din acelasi pachet => apare protected
    //daca o clasa este instantiata intr o alta clasa din alt  pachet =>nu apare protected

    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected AlertMethods alertMethods;

    @FindBy(xpath = "//tr/td[@class='cart_description']//a")
    private List<WebElement> tableProductTitleList;
    @FindBy(xpath = "//tr/td[@class='cart_price']/p")
    private List<WebElement> tableProductsPriceList;
    @FindBy(xpath = "//tr/td[@class='cart_quantity']/button")
    private List<WebElement> tableProductsQuantityList;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutElement;
    @FindBy(xpath = "//tr/td/p[@class='cart_total_price']")
    private List<WebElement> tableProductsTotalPriceList;




    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(driver);
        alertMethods=new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a")
    protected List<WebElement> menuOptions;

    public void navigateMenuOption(String option) {
        for (int index = 0; index < menuOptions.size(); index++) {
            if (menuOptions.get(index).getText().contains(option)) {
                menuOptions.get(index).click();
                break;
            }
        }
    }

    protected void validateCartProducts(AccountObject accountObject){

        List<ProductObject> products = accountObject.getProducts();
        for(int index=0;index<accountObject.getProducts().size();index++){
            Assert.assertEquals(products.get(index).getTitle(), tableProductTitleList.get(index).getText());
            Assert.assertEquals(products.get(index).getPrice(), tableProductsPriceList.get(index).getText());
            Assert.assertEquals(products.get(index).getQuantity(), Integer.valueOf(tableProductsQuantityList.get(index).getText()));
            Assert.assertEquals("Rs. "+products.get(index).getFinalPrice(),tableProductsTotalPriceList.get(index).getText());
        }
    }
    protected void validateTotalPrice(AccountObject accountObject){

        Assert.assertEquals("Rs. "+accountObject.getTotalPrice(),tableProductsTotalPriceList.get((tableProductsTotalPriceList.size())-1).getText());

    }
}
