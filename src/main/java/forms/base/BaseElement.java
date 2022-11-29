package forms.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LoggerUtils;

import static browser.Browser.getDriver;
import static utils.WaitingUtils.*;

public abstract class BaseElement {
    By uniqueLocator;
    String elementName;

    public BaseElement(By uniqueLocator, String elementName) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
    }
    public By getUniqueLocator() {
        return uniqueLocator;
    }
    public String getElementName() {
        return elementName;
    }
    public WebElement getElement() {
        waitForPresence(uniqueLocator);
        return getDriver().findElement(uniqueLocator);
    }

    public void click(){
        LoggerUtils.debugLog("Clicking ", getElementName());
        waitToBeClickable(uniqueLocator);
        getElement().click();
    }

    public String getText() {
        LoggerUtils.debugLog("Reading text of ", getElementName());
        waitForVisibility(uniqueLocator);
        return getElement().getText();
    }

    public boolean isElementDisplayed() {
        LoggerUtils.debugLog("Checking visibility of ", getElementName());
        return waitForVisibility(uniqueLocator).isDisplayed();
    }
}
