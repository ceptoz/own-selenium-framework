package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.Constants.CHROME_SETTINGS;
import static utils.JSONUtils.getValueFromJSON;

public class ChromeCapabilities extends DriverSingleton {
    ChromeOptions options = new ChromeOptions();

    @Override
    public WebDriver startDriver() {
        WebDriverManager.chromedriver().setup();
        options.addArguments(getValueFromJSON(CHROME_SETTINGS, "lang"));
        options.addArguments(getValueFromJSON(CHROME_SETTINGS, "mode"));
        return new ChromeDriver(options);
    }
}
