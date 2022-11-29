package forms.pages;

import forms.LeftMenuForm;
import forms.base.BaseForm;
import org.openqa.selenium.By;

public class ElementsWrapperPage extends BaseForm {
    public ElementsWrapperPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Elements')]"), "Elements page");
    }

    public LeftMenuForm getLeftMenuForm() {
        return new LeftMenuForm();
    }
}
