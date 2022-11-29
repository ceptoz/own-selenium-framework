package forms.base;

import org.openqa.selenium.By;
import utils.LoggerUtils;

import static utils.WaitingUtils.waitToBeClickable;

public class TextBox extends BaseElement {
    public TextBox(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void typeText(String text) {
        LoggerUtils.debugLog("Typing text in: ", getElementName());
        waitToBeClickable(getUniqueLocator());
        getElement().clear();
        getElement().sendKeys(text);
    }
}
