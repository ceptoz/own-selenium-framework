package forms.pages.windows_pack;

import forms.LeftMenuForm;
import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

import static browser.Browser.scrollViaJS;

public class WindowsPage extends BaseForm {
    By newTabLocator = By.xpath("//button[@id='tabButton']");
    Button newTabBtn = new Button(newTabLocator, "New tab button");

    public WindowsPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Browser Windows')]"), "Windows pages");
    }

    public void clickNewTab() {
        scrollViaJS(newTabLocator);
        newTabBtn.click();
    }

    public LeftMenuForm getLeftMenuForm() {
        return new LeftMenuForm();
    }
}
