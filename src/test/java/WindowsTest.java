import forms.pages.AlertsFramesWindowsWrapPage;
import forms.pages.StartPage;
import forms.pages.windows_pages_pack.LinksPage;
import forms.pages.windows_pages_pack.SamplePage;
import forms.pages.windows_pages_pack.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static browser.Browser.goToStartUrl;
import static browser.FramesAndWindowsHandlers.*;

public class WindowsTest extends BaseTest{
    @Test
    public void checkWindowsTest() {
        goToStartUrl();
        StartPage startPage = new StartPage();
        Assert.assertTrue(startPage.isFormOpen(), "Start page is not open");

        startPage.clickAlertSection();
        AlertsFramesWindowsWrapPage alertsWrapPage = new AlertsFramesWindowsWrapPage();
        Assert.assertTrue(alertsWrapPage.isFormOpen(), "Alerts page is not open");

        alertsWrapPage.getLeftMenuForm().clickWindowsSubtab();
        WindowsPage windowsPage = new WindowsPage();
        Assert.assertTrue(windowsPage.isFormOpen(), "Windows page is not open");

        windowsPage.clickNewTab();
        String browserWindowsPageHandle = getCurrentWindowHandle();
        switchToNewTab(browserWindowsPageHandle);
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.isFormOpen(), "Sample page is not open");

        closeTab();
        goToWindow(browserWindowsPageHandle);
        Assert.assertTrue(windowsPage.isFormOpen(), "Browser Windows page is not open");

        windowsPage.getLeftMenuForm().clickElementsTab();
        windowsPage.getLeftMenuForm().clickLinksTab();
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isFormOpen(), "Links page is not open");

        linksPage.homeButtonClick();
        String linksPageHandle = getCurrentWindowHandle();
        switchToNewTab(linksPageHandle);
        Assert.assertTrue(startPage.isFormOpen(), "Main page in new tab is not open");

        goToWindow(linksPageHandle);
        Assert.assertTrue(linksPage.isFormOpen(), "Links page is not open");


    }
}
