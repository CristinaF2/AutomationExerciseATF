package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PaymentDonePage extends BasePage {
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    protected WebElement messageElement;

    @FindBy(xpath = "//a[text()='Continue']")
    protected WebElement continueButtonElement;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    protected WebElement downloadInvoiceButton;

    public void checkIfOrderIsConfirmed(AccountObject accountObject) {
        Assert.assertEquals(messageElement.getText(), accountObject.getAccountInfo().getConfirmedOrderMessage());
        elementMethods.clickOnElementWithJS(continueButtonElement);
    }
}
