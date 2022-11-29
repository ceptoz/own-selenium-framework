package utils;

import browser.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Constants.PATH_TO_CONFIG_DATA;
import static utils.JSONUtils.getValueFromJSON;

public class WaitingUtils {
    static WebDriverWait EXPLICIT_WAIT = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "explicitWaitingTimeout"))));
    static WebDriverWait alertWait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "alertsWaitingTimeout"))));

    public static void waitForPresence(By elementLocator) {
        EXPLICIT_WAIT.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public static void waitToBeClickable(By elementLocator) {
        EXPLICIT_WAIT.until(ExpectedConditions.elementToBeClickable(Browser.getDriver().findElement(elementLocator)));
    }

    public static WebElement waitForVisibility(By elementLocator) {
        return EXPLICIT_WAIT.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public static boolean waitForNotDisplayed(By elementLocator) {
        return EXPLICIT_WAIT.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
    }

    public static Alert waitForAlert(){
        return alertWait.until(ExpectedConditions.alertIsPresent());
    }

    public static void isNewTabOpen() {
        EXPLICIT_WAIT.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public static void isOneTabLeft() {
        EXPLICIT_WAIT.until(ExpectedConditions.numberOfWindowsToBe(1));
    }
}
