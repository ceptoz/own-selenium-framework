package forms.pages;

import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

import static browser.Browser.scrollViaJS;

public class StartPage extends BaseForm {
    private final By alertSectionLocator = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private final Button alertSection = new Button(alertSectionLocator, "Alerts section");
    By elementsSectionLocator = By.xpath("//h5[text()='Elements']//parent::div");
    Button elementSection = new Button(elementsSectionLocator, "Alert section");
    public StartPage() {
        super(By.xpath("//div[@class='home-banner']"), "Home page");
    }

    public void clickAlertSection() {
        scrollViaJS(alertSectionLocator);
        alertSection.click();
    }

    public void clickElementSection() {
        scrollViaJS(elementsSectionLocator);
        elementSection.click();
    }

}
