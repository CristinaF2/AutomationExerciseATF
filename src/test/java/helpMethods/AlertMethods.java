package helpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertMethods {

    private WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    public void interractWithAlertsOk() {
        //ne mutam cu focusul pe alerta
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

}
