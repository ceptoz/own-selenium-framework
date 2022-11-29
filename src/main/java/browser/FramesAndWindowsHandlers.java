package browser;

import org.openqa.selenium.WebElement;
import utils.LoggerUtils;

import static utils.WaitingUtils.isNewTabOpen;
import static utils.WaitingUtils.isOneTabLeft;

public class FramesAndWindowsHandlers extends Browser{
    public static void switchToFrameByElement(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    public static void quitFrame() {
        LoggerUtils.infoLog("Switching from the frame.");
        getDriver().switchTo().defaultContent();
    }

    public static String getCurrentWindowHandle() {
        isNewTabOpen();
        return getDriver().getWindowHandle();
    }

    public static void switchToNewTab(String thisWindow) {
        LoggerUtils.infoLog("Switching to other tab.");
        for (String window : getDriver().getWindowHandles()) {
            if(!thisWindow.contentEquals(window)) {
                getDriver().switchTo().window(window);
                break;
            }
        }
    }

    public static void closeTab() {
        LoggerUtils.infoLog("Closing the tab");
        getDriver().close();
        isOneTabLeft();
    }

    public static void goToWindow(String windowID) {
        LoggerUtils.infoLog("Switching to the specified tab.");
        getDriver().switchTo().window(windowID);
    }
}
