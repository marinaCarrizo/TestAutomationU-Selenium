package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
    private WebDriverWait wait;

    public BaseClass(WebDriver driver){
        this.driver = driver;

    }


}
