package screens.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.BaseClass;

public class LoginScreen extends BaseClass {

    @FindBy(linkText ="Form Authentication")
    private WebElement formAuthenticationLink;
    @FindBy(id="username")
    private WebElement userField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(css = "#login button")
    private WebElement loginButton;

    @FindBy(xpath="//*[@id=\"content\"]/div/h2")
    private WebElement loginPageTitle;

    @FindBy(id = "flash")
    private WebElement logoutAlertText;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(loginPageTitle)).getText();
    }
    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOf(logoutAlertText)).getText();
    }
    public void accessLoginForm(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(formAuthenticationLink)).click();
    }
    public void enterUsername(String user){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(userField)).clear();
        userField.sendKeys(user);
    }
    public void enterPassword(String pass){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(pass);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void setCredentials(String user,String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }

}
