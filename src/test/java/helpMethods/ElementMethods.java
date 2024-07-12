package helpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

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
    public void uploadFile(WebElement element,String path){
        File file=new File(path);
        fillElement(element,file.getAbsolutePath());
    }

    public void checkText(WebElement element, String text){
        Assert.assertEquals(element.getText(),text);
    }
    public void scrollOnPage(Integer x, Integer y) {
        //facem scroll ca elementul sa fie vizibil
        //il folosim cand metodele standard din selenium nu ne ajuta
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickOnElementWithJS(WebElement webElement) {
        //aceasta metoda e necesara pt a putea face click pe element daca cumva e acoperit de o reclama
        waitVisibilityElement(webElement);
        js.executeScript("arguments[0].click();", webElement);
    }

    public void printText(WebElement webElement) {
        System.out.println("Textul este: " + webElement.getText());
    }

    public void waitVisibilityElement(WebElement webElement) {
        //definim un wait explicit ca sa astepte dupa vizibilitatea elementului
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void selectValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        //selectByValue- cand avem cifre/numere
        //selectByVisibleText -cand avem text, caractere
        select.selectByVisibleText(value);
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
