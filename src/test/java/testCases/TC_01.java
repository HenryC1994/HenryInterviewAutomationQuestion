package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.LoginSuccessFulPage;
import pageObjects.TestPage1;
import testBase.BaseTestClass;

import java.io.IOException;
import java.util.ResourceBundle;

public class TC_01 extends BaseTestClass{

    @Test
    public void clickFormAuthenticationTest() throws IOException {
        // navigate to https://the-internet.herokuapp.com/
        String url = ResourceBundle.getBundle("config").getString("appURL");
        driver.get(url);
        TestPage1 testPage1 = new TestPage1(driver);

        //click form authentication
        testPage1.clickFormAuthenticationButton();

        // insert username & password then click login button
        String username = ResourceBundle.getBundle("config").getString("username");
        String password = ResourceBundle.getBundle("config").getString("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username).inputPassword(password).clickLoginButton();

        LoginSuccessFulPage loginSuccessFulPage = new LoginSuccessFulPage(driver);
        System.out.println(loginSuccessFulPage.getLoginSuccessFullTxt());

        //Assert
         String ExpectedLoginSuccessfulText = ResourceBundle.getBundle("config").getString("expectedResultText");
         Assert.assertEquals(loginSuccessFulPage.getLoginSuccessFullTxt(), ExpectedLoginSuccessfulText);

         captureScreen("screenshots");
    }



}
