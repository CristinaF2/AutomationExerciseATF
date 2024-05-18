package pages;

import helpMethods.ElementMethods;
import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AccountCreatedPage extends BasePage {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedMessage;
    @FindBy(xpath = "//div/a[@data-qa='continue-button']")
    private WebElement continueButton;


    public void validateAccountCreated(AccountObject accountObject){
        Assert.assertEquals(accountObject.getAccountInfo().getAccountCreatedMessage(),accountCreatedMessage.getText());
        elementMethods.clickOnElement(continueButton);
    }
}
