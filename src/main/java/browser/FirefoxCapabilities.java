package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static utils.Constants.FIREFOX_SETTINGS;
import static utils.JSONUtils.getValueFromJSON;

public class FirefoxCapabilities extends DriverSingleton {
    static FirefoxOptions options = new FirefoxOptions();

    @Override
    public WebDriver startDriver() {
        WebDriverManager.chromedriver().setup();
        options.addArguments(getValueFromJSON(FIREFOX_SETTINGS, "mode"));
        return new FirefoxDriver(options);
    }
}
