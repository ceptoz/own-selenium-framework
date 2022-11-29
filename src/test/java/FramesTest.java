import forms.pages.AlertsFramesWindowsWrapPage;
import forms.pages.frames_pack.FramesPage;
import forms.pages.frames_pack.NestedFramesPage;
import forms.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static browser.Browser.*;
import static browser.FramesAndWindowsHandlers.quitFrame;
import static browser.FramesAndWindowsHandlers.switchToFrameByElement;

public class FramesTest extends BaseTest{
    @Test
    public void checkFramesTest() {
        goToStartUrl();
        StartPage startPage = new StartPage();
        Assert.assertTrue(startPage.isFormOpen(), "Start page is not open");

        startPage.clickAlertSection();
        AlertsFramesWindowsWrapPage alertsWrapPage = new AlertsFramesWindowsWrapPage();
        Assert.assertTrue(alertsWrapPage.isFormOpen(), "Alerts page is not open");

        alertsWrapPage.getLeftMenuForm().clickNestedFramesSubTab();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isFormOpen(), "Page with nested frames is not open");

        switchToFrameByElement(nestedFramesPage.getParentiFrame());
        Assert.assertTrue(nestedFramesPage.isParentTextPresent(), "\"Parent frame\" text is not presented on the current window");

        switchToFrameByElement(nestedFramesPage.getChildiFrame());
        Assert.assertTrue(nestedFramesPage.isChildTextPresent(), "\"Child frame\" text is not presented on the current window");

        quitFrame();
        nestedFramesPage.getLeftMenuForm().clickFramesSubTab();
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isFormOpen(), "Frames page is not open");

        switchToFrameByElement(framesPage.getUpperiFrame());
        String upperText = framesPage.getFrameText();
        quitFrame();

        switchToFrameByElement(framesPage.getLoweriFrame());
        String lowerText = framesPage.getFrameText();
        quitFrame();

        Assert.assertEquals(upperText, lowerText, "Messages from windows aren't equal");
    }
}
