package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import screens.Login.LoginScreen;
import screens.Login.SecureAreaScreen;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    public WebDriver driver;
    private LoginScreen loginScreen;
    private SecureAreaScreen secureAreaScreen;

    public LoginSteps(){
        driver = Hooks.driver;
        loginScreen= PageFactory.initElements(driver, LoginScreen.class);
        secureAreaScreen=PageFactory.initElements(driver, SecureAreaScreen.class);

    }

    @Given("I access the login form")
    public void iAccessTheLoginForm() {
        loginScreen.accessLoginForm();
    }

    @When("I attempt to login")
    public void iAttemptToLogin(DataTable dataTable) {
        List<Map<String,String>> users = dataTable.asMaps(String.class, String.class);
        for (Map<String, String>user:users)
            loginScreen.setCredentials(user.get("Username"), user.get("Password"));
    }

    @Then("I should see the Secure Area screen")
    public void iShouldSeeTheSecureAreaScreen(){
        Assert.assertTrue(secureAreaScreen.getTitle().contains("Secure Area"));
        Assert.assertTrue(secureAreaScreen.getLoginAlertText().contains("You logged into a secure area!"));
        Assert.assertTrue(secureAreaScreen.getWelcomeText()
                .contains("Welcome to the Secure Area. When you are done click logout below."));
    }

    @When("I attempt to logout")
    public void iAttemptToLogout() {
        secureAreaScreen.clickLogoutButton();
    }

    @Then("I should be redirected to the loginPage")
    public void iShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue(loginScreen.getTitle().contains("Login Page"));
        Assert.assertTrue(loginScreen.getAlertText().contains("You logged out of the secure area!"));

    }
}
