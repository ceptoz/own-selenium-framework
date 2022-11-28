package browser;

import org.openqa.selenium.WebDriver;

public abstract class DriverSingleton {
    private static WebDriver driver;

    public abstract WebDriver startDriver();

    public WebDriver getDriverInstance() {
        if (driver == null) {
            driver = startDriver();
        }
        return driver;
    }

    public static void stopDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
