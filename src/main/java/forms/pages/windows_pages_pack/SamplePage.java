package forms.pages.windows_pages_pack;

import forms.base.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    public SamplePage() {
        super(By.xpath("//h1[@id='sampleHeading']"), "Sample page");
    }
}
