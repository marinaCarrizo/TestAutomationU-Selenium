package screens.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.BaseClass;

public class SecureAreaScreen extends BaseClass {

    @FindBy(xpath="//*[@id=\"content\"]/div/h2")
    private WebElement secureAreaTitle;
    @FindBy(xpath = "//*[@id=\"flash\"]")
    private  WebElement loginAlertText;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h4")
    private WebElement welcomeText;
    @FindBy(linkText="Logout")
    private WebElement logoutButton;

    public SecureAreaScreen(WebDriver driver) {
        super(driver);
    }

    public String getLoginAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(loginAlertText)).getText();
    }
    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(secureAreaTitle)).getText();
    }
    public String getWelcomeText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(welcomeText)).getText();
    }
    public void clickLogoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
