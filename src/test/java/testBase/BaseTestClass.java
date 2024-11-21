package testBase;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTestClass {

    public WebDriver driver;
    public ChromeOptions chromeOptions;
    public FirefoxOptions firefoxOptions;

    @Parameters("browser")
    @BeforeClass
    public void testPrep(String browser) {
        if (browser.equals("chrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
            // chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("moz:firefoxOptions",
                    ImmutableMap.of("marionette", false));
            // firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }

        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public void afterTest() {
        driver.close();
    }

    public String captureScreen(String screenShotName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        var takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = "screenshots/" + screenShotName + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return destination;
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }


}
