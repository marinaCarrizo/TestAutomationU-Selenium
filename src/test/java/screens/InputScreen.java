package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputScreen extends BaseClass {
   @FindBy(name = "Inputs")
   private WebElement inputsTitle;

   @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/input")
   private WebElement inputField;




    public InputScreen(WebDriver driver) {
        super(driver);
    }
}
