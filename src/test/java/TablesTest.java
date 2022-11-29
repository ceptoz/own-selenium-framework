import forms.RegistrationForm;
import forms.pages.ElementsWrapperPage;
import forms.pages.StartPage;
import forms.pages.WebTablesPage;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static browser.Browser.goToStartUrl;
import static utils.Constants.USERS_FILE;
import static utils.Constants.USER_NUMBER;
import static utils.JSONUtils.getObjectsFromJSON;

public class TablesTest extends BaseTest{
    @Test
    public void checkTablesTest() {
        goToStartUrl();
        StartPage startPage = new StartPage();
        Assert.assertTrue(startPage.isFormOpen(), "Start page is not open");

        startPage.clickElementSection();
        ElementsWrapperPage elementsWrapperPage = new ElementsWrapperPage();
        Assert.assertTrue(elementsWrapperPage.isFormOpen(), "Elements page is not open");

        elementsWrapperPage.getLeftMenuForm().clickWebTablesTab();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isFormOpen(), "Web Tables page is not open");

        webTablesPage.clickAddBtn();
        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isFormOpen(), "Registration form is not open");

        List<UserModel> users = getObjectsFromJSON(USERS_FILE, UserModel.class);
        UserModel userToWork = users.get(USER_NUMBER);
        registrationForm.fillTheRegistrationField(userToWork);
        registrationForm.clickSubmitBtn();
        Assert.assertTrue(registrationForm.isFormClosed());

        List<UserModel> usersFromPage = webTablesPage.getValuesFromTable();
        Assert.assertTrue(usersFromPage.contains(userToWork), "User is not present in the table");

        int entryIndex = webTablesPage.getIndexOfEqualUser(usersFromPage, userToWork) + 1;
        webTablesPage.clickDeleteEntry(entryIndex);
        List<UserModel> refreshedUsersFromPage = webTablesPage.getValuesFromTable();
        Assert.assertFalse(refreshedUsersFromPage.contains(userToWork), "User is still present in the table");
    }
}
