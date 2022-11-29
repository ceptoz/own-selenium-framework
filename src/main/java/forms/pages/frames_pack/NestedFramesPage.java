package forms.pages.frames_pack;

import forms.LeftMenuForm;
import forms.base.BaseForm;
import forms.base.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static browser.Browser.getDriver;

public class NestedFramesPage extends BaseForm {
    By parentFrameLocator = By.xpath("//body[text()='Parent frame']");
    Label parentFrame = new Label(parentFrameLocator, "Parent frame");
    By childFrameLocator = By.xpath("//p[text()='Child Iframe']");
    Label childFrame = new Label(childFrameLocator, "Parent frame");

    public NestedFramesPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"), "Nested frames page");
    }

    public boolean isParentTextPresent() {
        return parentFrame.isElementDisplayed();
    }

    public WebElement getParentiFrame() {
        return getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
    }

    public boolean isChildTextPresent() {
        return childFrame.isElementDisplayed();
    }

    public WebElement getChildiFrame() {
        return getDriver().findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
    }

    public LeftMenuForm getLeftMenuForm() {
        return new LeftMenuForm();
    }
}
