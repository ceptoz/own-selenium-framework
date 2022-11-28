import browser.Browser;
import org.testng.annotations.Test;

import static browser.Browser.goToStartUrl;

public class ExampleTest extends BaseTest{
    @Test
    public void checkingFun(){
        goToStartUrl();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
