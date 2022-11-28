package baseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
//    By uniqueLocator;
//    String elementName;
//
//    public BaseElement(By uniqueLocator, String elementName) {
//        this.uniqueLocator = uniqueLocator;
//        this.elementName = elementName;
//    }
//    public By getUniqueLocator() {
//        return uniqueLocator;
//    }
//    public String getElementName() {
//        return elementName;
//    }
//    public WebElement getElement() {
//        Browser.getWait().waitForPresence(uniqueLocator);
//        return Browser.getDriver().findElement(uniqueLocator);
//    }
//    public void click(){
//        LoggerUtil.debugLog("Clicking ", getElementName());
//        Browser.getWait().waitToBeClickable(uniqueLocator);
//        getElement().click();
//    }
//    public String getText() {
//        LoggerUtil.debugLog("Reading text of ", getElementName());
//        Browser.getWait().waitForVisibility(uniqueLocator);
//        return getElement().getText();
//    }
//    public boolean isElementDisplayed() {
//        LoggerUtil.debugLog("Checking visibility of ", getElementName());
//        return (Browser.getWait().waitForVisibility(uniqueLocator)).isDisplayed();
//    }
}
