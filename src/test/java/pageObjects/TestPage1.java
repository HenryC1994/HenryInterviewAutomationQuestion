package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestPage1 extends BasePage {

    public TestPage1(WebDriver driver) {
        super(driver);
    }

    // Link = https://the-internet.herokuapp.com/

    //WebElements
    @FindBy(xpath = "/html/body/div[2]/div/ul/li[21]/a")
    WebElement formAuthenticationButton;

    // Action Methods
    public TestPage1 clickFormAuthenticationButton() {
        wait.until(ExpectedConditions.visibilityOf(formAuthenticationButton)).click();
        return this;
    }

}
