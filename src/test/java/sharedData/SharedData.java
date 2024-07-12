package sharedData;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

@Getter
public class SharedData {

    private WebDriver webDriver;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        webDriver=new ChromeDriver(options);
        webDriver.get("https://automationexercise.com/");
        webDriver.manage().window().maximize();
        webDriver.navigate().refresh();
    }
}
