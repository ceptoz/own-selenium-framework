package forms.pages.windows_pages_pack;

import browser.Browser;
import forms.base.BaseForm;
import forms.base.Button;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    By homeButtonLocator = By.xpath("//a[@id='simpleLink']");
    Button homeButton = new Button(homeButtonLocator, "Home button");

    public LinksPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Links')]"), "Links pages");
    }

    public void homeButtonClick() {
        Browser.scrollViaJS(homeButtonLocator);
        homeButton.click();
    }

}
