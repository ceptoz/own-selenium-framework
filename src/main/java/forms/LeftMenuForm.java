package forms;

import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

import static browser.Browser.scrollViaJS;

public class LeftMenuForm extends BaseForm {
    By alertSubTabLocator = By.xpath("//li//span[text()='Alerts']");
    Button alertSubTab = new Button(alertSubTabLocator, "Alert subtab");
    By framesSubTabLocator = By.xpath("//li//span[text()='Frames']");
    Button framesSubTabBtn = new Button(framesSubTabLocator, "Frames subtab");
    By nestedFramesTabLocator = By.xpath("//li//span[text()='Nested Frames']");
    Button nestedFramesTabBtn = new Button(nestedFramesTabLocator, "Nested frames sub tab");
    By webTablesTabLocator = By.xpath("//li//span[text()='Web Tables']");
    Button webTablesSubTab = new Button(webTablesTabLocator, "Web tables sub tab");
    By browserWindowsLocator = By.xpath("//li//span[text()='Browser Windows']");
    Button browserWindowsSubTab = new Button(browserWindowsLocator, "Browser windows subtab");
    By elementsTabLocator = By.xpath("//div[text()='Elements']");
    Button elementsTab = new Button(elementsTabLocator, "Elements tab button");
    By linksSubTabLocator = By.xpath("//li//span[text()='Links']");
    Button linksSubTab = new Button(linksSubTabLocator, "Links sub tab");

    public LeftMenuForm() {
        super(By.xpath("//div[@class='left-pannel']"), "Left side column with menu");
    }

    public void clickLinksTab() {
        scrollViaJS(linksSubTabLocator);
        linksSubTab.click();
    }

    public void clickAlertSubTab() {
        scrollViaJS(alertSubTabLocator);
        alertSubTab.click();
    }

    public void clickFramesSubTab() {
        scrollViaJS(framesSubTabLocator);
        framesSubTabBtn.click();
    }

    public void clickNestedFramesSubTab() {
        scrollViaJS(nestedFramesTabLocator);
        nestedFramesTabBtn.click();
    }

    public void clickWebTablesTab() {
        scrollViaJS(webTablesTabLocator);
        webTablesSubTab.click();
    }

    public void clickWindowsSubtab() {
        scrollViaJS(browserWindowsLocator);
        browserWindowsSubTab.click();
    }

    public void clickElementsTab() {
        scrollViaJS(elementsTabLocator);
        elementsTab.click();
    }
}
