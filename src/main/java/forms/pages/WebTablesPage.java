package forms.pages;

import forms.base.BaseForm;
import forms.base.Button;
import models.UserModel;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static browser.Browser.getDriver;
import static utils.Constants.NUMBER_OF_COLUMNS;
import static utils.Constants.NUMBER_OF_ROWS;

public class WebTablesPage extends BaseForm {
    By addBtnLocator = By.id("addNewRecordButton");
    Button addBtn = new Button(addBtnLocator, "Add new record button");
    String cellLocatorTemplate = "//div[@class='rt-tr-group'][%d]//div[@role='gridcell'][%d]";
    String deleteRecordBtnTemplate = "//div[@class='rt-tr-group'][%d]//span[contains(@id,'delete-record')]";

    public WebTablesPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Web Tables')]"), "Web tables page");
    }

    public void clickAddBtn() {
        addBtn.click();
    }

    public List<UserModel> getValuesFromTable() {
        List<UserModel> objects = new ArrayList<>();
        for(int i = 1; i <= NUMBER_OF_ROWS; i++) {
            String[] values = new String[NUMBER_OF_COLUMNS];
            for(int j = 1; j <= NUMBER_OF_COLUMNS; j++) {
                values[j-1] = getDriver().findElement(By.xpath(String.format(cellLocatorTemplate, i, j))).getText();
            }
            objects.add(new UserModel(values));
        }
        return objects;
    }

    public void clickDeleteEntry(int index) {
        Button deleteRecord = new Button(By.xpath(String.format(deleteRecordBtnTemplate, index)), "Delete record button");
        deleteRecord.click();
    }

    public int getIndexOfEqualUser(List<UserModel> usersFromPage, UserModel user) {
        int index;
        for(index = 0; index < usersFromPage.size(); index++) {
            if(usersFromPage.get(index).equals(user)) {
                break;
            }
        }
        return index;
    }
}
//div[@class='rt-tr-group'][1]//div[@role='gridcell'][1]