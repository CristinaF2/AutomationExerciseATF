package pages;



import objectData.AccountObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement nameFieldElement;

    @FindBy(xpath = "//div/input[@name='email']")
    private WebElement emailFieldElement;

    @FindBy(id = "message")
    private WebElement messageFieldElement;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButtonElement;

    @FindBy(xpath = "//div/input[@name='subject']")
    private WebElement subjectFieldElement;

    @FindBy(xpath = " //input[@name='submit']")
    private WebElement submitButtonElement;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successfullySentContactMessageElement;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homeButtonElement;


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(AccountObject accountObject){
        elementMethods.fillElement(nameFieldElement,accountObject.getAccountAddress().getFirstName()+" "+accountObject.getAccountAddress().getLastName());
        elementMethods.fillElement(subjectFieldElement,accountObject.getAccountInfo().getSubject());
        elementMethods.fillElement(emailFieldElement, accountObject.getEmail());
        elementMethods.fillElement(messageFieldElement,accountObject.getAccountInfo().getContactMessage());
        elementMethods.uploadFile(uploadFileButtonElement,"src/test/resources/invoice.txt");
        elementMethods.clickOnElementWithJS(submitButtonElement);
        alertMethods.interractWithAlertsOk();
        elementMethods.checkText(successfullySentContactMessageElement,accountObject.getAccountInfo().getSuccessfullySentContactMessage());
        elementMethods.clickOnElementWithJS(homeButtonElement);
    }
}
