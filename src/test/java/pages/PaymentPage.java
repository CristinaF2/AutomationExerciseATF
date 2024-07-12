package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/input[@name='name_on_card']")
    private WebElement cardNameElement;

    @FindBy(xpath = "//div/input[@name='card_number']")
    private WebElement cardNumberElement;

    @FindBy(xpath = "//div/input[@name='cvc']")
    private WebElement cvcNumberElement;

    @FindBy(xpath = "//div/input[@name='expiry_month']")
    private WebElement expirationMonthElement;

    @FindBy(xpath = "//div/input[@name='expiry_year']")
    private WebElement expirationYearElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    public void fillCardDetails(AccountObject accountObject){
        elementMethods.fillElement(cardNameElement,accountObject.getAccountAddress().getFirstName()+" "+accountObject.getAccountAddress().getLastName());
        elementMethods.fillElement(cardNumberElement,accountObject.getCardObject().getCardNumber());
        elementMethods.fillElement(cvcNumberElement,accountObject.getCardObject().getCvcNumber());
        elementMethods.fillElement(expirationMonthElement,accountObject.getCardObject().getExpirationMonth());
        elementMethods.fillElement(expirationYearElement,accountObject.getCardObject().getExpirationYear());
        elementMethods.clickOnElementWithJS(submitElement);
    }
}
