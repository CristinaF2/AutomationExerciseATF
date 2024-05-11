package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(driver);
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


}
