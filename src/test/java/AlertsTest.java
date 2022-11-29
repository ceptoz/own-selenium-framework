import forms.pages.AlertsFramesWindowsWrapPage;
import forms.pages.AlertsPage;
import forms.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static browser.Browser.goToStartUrl;
import static utils.RandomProviderUtils.createRandomString;

public class AlertsTest extends BaseTest{
    @Test
    public void checkAlertsTest() {
        goToStartUrl();
        StartPage startPage = new StartPage();
        Assert.assertTrue(startPage.isFormOpen(), "Start page is not open");

        startPage.clickAlertSection();
        AlertsFramesWindowsWrapPage alertsWrapPage = new AlertsFramesWindowsWrapPage();
        Assert.assertTrue(alertsWrapPage.isFormOpen(), "Alerts page is not open");

        alertsWrapPage.getLeftMenuForm().clickAlertSubTab();
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isFormOpen(), "Alerts page is not open");

        alertsPage.clickSimpleAlertBtn();
        Assert.assertEquals(alertsPage.getAlert().getText(), "You clicked a button", "Alert clicking is unsuccessful");

        alertsPage.acceptAlert(alertsPage.getAlert());
        Assert.assertNull(alertsPage.getAlert(), "Alert isn't closed");

        alertsPage.clickOptionalAlertBtn();
        Assert.assertEquals(alertsPage.getAlert().getText(), "Do you confirm action?", "Prompt opening is unsuccessful");

        alertsPage.acceptAlert(alertsPage.getAlert());
        Assert.assertNull(alertsPage.getAlert(), "Alert isn't closed");

        Assert.assertEquals(alertsPage.getResultBoxText(), "You selected Ok", "Actual text is not equal to the expected one");

        alertsPage.clickPromptBoxBtn();
        Assert.assertEquals(alertsPage.getAlert().getText(), "Please enter your name", "Actual text is not equal to the expected one");

        String name = createRandomString();
        alertsPage.inputPromptBox(alertsPage.getAlert(), name);
        alertsPage.acceptAlert(alertsPage.getAlert());
        Assert.assertNull(alertsPage.getAlert(), "Alert isn't closed");
        Assert.assertEquals(alertsPage.getPromptResultText(), "You entered " + name, "Actual text is not equal to the expected one");
    }
}
