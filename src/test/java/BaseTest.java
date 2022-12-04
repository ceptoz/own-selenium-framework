import org.testng.annotations.*;

import static browser.Browser.closeBrowser;
import static browser.Browser.startBrowser;
import static utils.LoggerUtils.debugLog;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        debugLog("Starting browser");
        startBrowser();
    }

    @AfterTest
    public void tearDown() {
        closeBrowser();
    }
}
