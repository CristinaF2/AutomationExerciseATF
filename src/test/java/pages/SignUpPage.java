package pages;

import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> titleOptions;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(xpath = "//label[@for='newsletter']")
    private WebElement signUpForNewsletter;

    @FindBy(xpath = "//label[@for='optin']")
    private WebElement receiveSpecialOffers;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccount;

    public void fillSignUpForm(AccountObject accountObject) {

        if (accountObject.getAccountInfo().getTitle().equals("Mr")) {
            elementMethods.clickOnElement(titleOptions.get(0));
        } else {
            elementMethods.clickOnElement(titleOptions.get(1));
        }
        elementMethods.fillElement(password, accountObject.getPassword());
        elementMethods.selectValue(day, accountObject.getAccountInfo().getDay());
        elementMethods.selectValue(month, accountObject.getAccountInfo().getMonth());
        elementMethods.selectValue(year, accountObject.getAccountInfo().getYear());
        if (accountObject.getAccountInfo().getNewsletter()) {
            elementMethods.clickOnElement(signUpForNewsletter);
        }
        if (accountObject.getAccountInfo().getSpecialOffers()) {
            elementMethods.clickOnElement(receiveSpecialOffers);
        }
        elementMethods.fillElement(firstName,accountObject.getAccountAddress().getFirstName());
        elementMethods.fillElement(lastName,accountObject.getAccountAddress().getLastName());
        elementMethods.fillElement(company,accountObject.getAccountAddress().getCompany());
        elementMethods.fillElement(address1,accountObject.getAccountAddress().getAddress1());
        elementMethods.fillElement(address2,accountObject.getAccountAddress().getAddress2());
        elementMethods.selectValue(country,accountObject.getAccountAddress().getCountry());
        elementMethods.fillElement(state,accountObject.getAccountAddress().getState());
        elementMethods.fillElement(city,accountObject.getAccountAddress().getCity());
        elementMethods.fillElement(zipcode,accountObject.getAccountAddress().getZipCode());
        elementMethods.fillElement(mobileNumber,accountObject.getAccountAddress().getMobileNumber());
        elementMethods.clickOnElement(createAccount);
    }


}
