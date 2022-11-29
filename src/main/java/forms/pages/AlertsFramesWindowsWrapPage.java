package forms.pages;

import forms.LeftMenuForm;
import forms.base.BaseForm;
import org.openqa.selenium.By;

public class AlertsFramesWindowsWrapPage extends BaseForm {
    public AlertsFramesWindowsWrapPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Alerts, Frame')]"), "Alerts, frames and windows page");
    }

    public LeftMenuForm getLeftMenuForm() {
        return new LeftMenuForm();
    }
}
