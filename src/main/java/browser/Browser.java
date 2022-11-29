package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.LoggerUtils;

import static browser.DriverFactory.defineDriver;
import static browser.DriverSingleton.stopDriver;
import static utils.Constants.CURRENT_BROWSER;
import static utils.Constants.DEFAULT_URL;
import static utils.WaitingUtils.waitForPresence;
import static utils.WaitingUtils.waitForVisibility;

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

    public static void scrollViaJS(By locator) {
        LoggerUtils.infoLog("Scrolling to the visibility of locator");
        waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        waitForVisibility(locator);
    }

    public static void clickViaJS(By locator) {
        waitForVisibility(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }
}
