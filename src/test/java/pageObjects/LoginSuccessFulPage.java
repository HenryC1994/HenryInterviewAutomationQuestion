package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginSuccessFulPage extends LoginPage{
    public LoginSuccessFulPage(WebDriver driver) {
        super(driver);
    }

    // Web elements
    @FindBy(xpath = "//*[@id=\"content\"]/div/h4")
    WebElement txtLoginSuccessful;

    public String getLoginSuccessFullTxt() {
        return wait.until(ExpectedConditions.visibilityOf(txtLoginSuccessful)).getText();
    }

}
