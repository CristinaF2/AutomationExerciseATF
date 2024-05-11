package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ElementMethods {

    private WebDriver driver;


    private JavascriptExecutor js;

    private Actions actions;

    public ElementMethods(WebDriver driver) {

        this.driver = driver;
        js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);


    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);

    }

    public void uploadPicture(WebElement element, String path) {
        File file = new File("src/test/resources/" + path);
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value) {
        for (int i = 0; i < elementsList.size(); i++) {
            if (elementsList.get(i).getText().equals(value)) {
                clickOnElement(elementsList.get(i));
                break;
            }

        }

    }



    public void scrollOnPage(Integer x, Integer y) {
        //facem scroll ca elementul sa fie vizibil
        //il folosim cand metodele standard din selenium nu ne ajuta
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickOnElementWithJS(WebElement webElement) {
        //aceasta metoda e necesara pt a putea face click pe element daca cumva e acoperit de o reclama
        js.executeScript("arguments[0].click();", webElement);
    }

    public void clickOnElementWithKeyboard(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }



    public void printText(WebElement webElement) {

        System.out.println("Textul este: " + webElement.getText());
    }



    public void changeElements(List<WebElement> list) {

        for (int index = 0; index < list.size(); index++) {
            // Actions actions = new Actions(driver);
            WebElement webElement = list.get(index);
            WebElement nextElement = list.get(index++);
            printText(webElement);
            actions.clickAndHold(webElement)
                    .moveToElement(nextElement)
                    .release()
                    .build()
                    .perform();

        }
        try {
            Thread.sleep(10000000);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillWithActions(WebElement webElement, String value) {
        actions.sendKeys(value).perform();
        //merge si cu build.perform
        waitVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void waitVisibilityElement(WebElement webElement) {
        //definim un wait explicit ca sa astepte dupa vizibilitatea elementului
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void fillMultipleValues(WebElement webElement, List<String> list) {
        for (String value : list) {
            webElement.sendKeys(value);
            webElement.sendKeys(Keys.ENTER);

        }


    }
    public void selectValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        //selectByValue- cand avem cifre/numere
        //selectByVisibleText -cand avem text, caractere
        select.selectByVisibleText(value);
    }

    public void clickMultipleValues(List<WebElement> webElements, List<String> list) {
        for (String value : list) {
            for (WebElement webElement : webElements) {
                //  verifica daca textul de pe ele....
                if (webElement.getText().equals(value)) {
                    webElement.click();
                }


            }


        }


    }

    public String formatCurrentDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public void hoverElement(WebElement webElement){
        waitVisibilityElement(webElement);
        Actions actions1=new Actions(driver);
        actions1.moveToElement(webElement).build().perform();


    }

    public void clearElement(WebElement webElement){
        waitVisibilityElement(webElement);
        webElement.clear();
    }

}
