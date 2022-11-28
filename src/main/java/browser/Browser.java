package browser;

import org.openqa.selenium.WebDriver;

import static browser.DriverFactory.defineDriver;
import static browser.DriverSingleton.stopDriver;
import static utils.Constants.*;
import static utils.JSONUtils.getValueFromJSON;

public class Browser {
    private static WebDriver driver;

    public static void startBrowser() {
        driver = defineDriver(CURRENT_BROWSER).getDriverInstance();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        stopDriver();
    }

    public static void goToStartUrl() {
        driver.get(DEFAULT_URL);
    }

//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//
//
//    public void goToStartUrl() {
////        LoggerUtil.infoLog("INFO: opening the first page");
//        driver.get(getValueFromJSON(PATH_TO_TEST_DATA, "defaultUrl"));
//    }
}
