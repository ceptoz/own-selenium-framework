package forms.base;

import org.openqa.selenium.By;
import utils.LoggerUtils;

import static utils.WaitingUtils.waitForNotDisplayed;
import static utils.WaitingUtils.waitForVisibility;

public abstract class BaseForm {
    By uniqueFormLocator;
    String formName;
    public BaseForm (By locator, String name) {
        uniqueFormLocator = locator;
        formName = name;
    }

    public boolean isFormOpen() {
        LoggerUtils.debugLog("Checking if the page object is open ", formName);
        return waitForVisibility(uniqueFormLocator).isDisplayed();
    }
    public boolean isFormClosed() {
        LoggerUtils.debugLog("Checking if the page object is closed", formName);
        return waitForNotDisplayed(uniqueFormLocator);
    }
}
