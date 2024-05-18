package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterPage extends BasePage {

    public LoginRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signUpName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signUpEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    public void fillSignUpForm(AccountObject accountObject) {
        elementMethods.fillElement(signUpName, accountObject.getAccountInfo().getName());
        elementMethods.fillElement(signUpEmail, accountObject.getEmail());
        elementMethods.clickOnElement(signUpButton);
    }
}
