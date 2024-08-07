package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()='Consent']")
    protected WebElement consentButton;


    public void clickConsentButton(AccountObject accountObject){
        elementMethods.clickOnElement(consentButton);
    }


}
