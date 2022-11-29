package forms.pages.frames_pack;

import forms.base.BaseForm;
import forms.base.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static browser.Browser.getDriver;

public class FramesPage extends BaseForm {
    By frameTextLocator = By.xpath("//h1[@id='sampleHeading']");
    Label frameText = new Label(frameTextLocator, "Upper frame text");

    public FramesPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Frames')]"), "Frames page");
    }

    public String getFrameText() {
        return frameText.getText();
    }

    public WebElement getUpperiFrame() {
        return getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
    }

    public WebElement getLoweriFrame() {
        return getDriver().findElement(By.xpath("//iframe[@id='frame2']"));
    }
}
