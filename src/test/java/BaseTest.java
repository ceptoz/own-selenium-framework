import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static browser.Browser.closeBrowser;
import static browser.Browser.startBrowser;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        startBrowser();
    }

    @AfterTest
    public void tearDown() {
        closeBrowser();
    }
}
