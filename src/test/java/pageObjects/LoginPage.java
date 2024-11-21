package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestPage1 {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Web elements
    @FindBy(xpath = "//input[@id='username']")
    WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/button")
    WebElement buttonLogin;


    // Action Methods
    public LoginPage inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(inputUsername)).sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword)).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(buttonLogin)).click();
        return this;
    }
}
