package pages;

import objectData.AccountObject;
import objectData.ProductObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_product")
    private WebElement searchBar;
    @FindBy(id = "submit_search")
    private WebElement submitSearch;
    @FindBy(css = ".overlay-content .add-to-cart")
    private WebElement addToCartProduct;
    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//img[@alt='ecommerce website products']")
    private WebElement productPicture;

    public void addProductToCart(AccountObject accountObject) {
        for (ProductObject product : accountObject.getProducts()) {
            elementMethods.fillElement(searchBar, product.getTitle());
            elementMethods.clickOnElement(submitSearch);
            if (product.getQuantity() > 1) {
                for (int index = 0; index < product.getQuantity(); index++) {
                    elementMethods.hoverElement(productPicture);
                    elementMethods.clickOnElementWithJS(addToCartProduct);
                    elementMethods.clickOnElementWithJS(continueShoppingButton);
                }
            } else {
                elementMethods.hoverElement(productPicture);
                elementMethods.clickOnElementWithJS(addToCartProduct);
                elementMethods.clickOnElementWithJS(continueShoppingButton);
            }
            elementMethods.clearElement(searchBar);
        }
    }
}
