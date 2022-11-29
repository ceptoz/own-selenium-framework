package forms.pages;

import forms.base.BaseForm;
import forms.base.Button;
import forms.base.Label;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import static utils.WaitingUtils.waitForAlert;

public class AlertsPage extends BaseForm {
    By simpleAlertLocator = By.xpath("//button[@id='alertButton']");
    Button simpleAlertBtn = new Button(simpleAlertLocator, "Alert button");
    By optionalAlertLocator = By.xpath("//button[@id='confirmButton']");
    Button optionalAlertBtn = new Button(optionalAlertLocator, "Optional alert button");
    By promptBoxLocator = By.xpath("//button[@id='promtButton']");
    Button promptBoxBtn = new Button(promptBoxLocator, "Prompt alert");
    By promptResultLocator = By.xpath("//span[@id='promptResult']");
    Label promptResult = new Label(promptResultLocator, "Prompt result text");
    By resultBoxLocator = By.xpath("//span[@id='confirmResult']");
    Label resultBox = new Label(resultBoxLocator, "Result box");

    public AlertsPage() {
        super(By.xpath("//div[@class='main-header' and contains(text(),'Alerts')]"), "Alerts page");
    }

    public Alert getAlert() {
        try {
            return waitForAlert();
        } catch (TimeoutException e) {
            return null;
        }
    }

    public void clickSimpleAlertBtn(){
        simpleAlertBtn.click();
    }

    public void clickOptionalAlertBtn(){
        optionalAlertBtn.click();
    }

    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    public String getResultBoxText() {
        return resultBox.getText();
    }

    public void clickPromptBoxBtn(){
        promptBoxBtn.click();
    }

    public void inputPromptBox(Alert alert, String text) {
        alert.sendKeys(text);
    }

    public String getPromptResultText() {
        return promptResult.getText();
    }
}
