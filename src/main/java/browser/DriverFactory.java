package browser;

public class DriverFactory {
    public static DriverSingleton defineDriver(String browserName) {
        switch (browserName) {
            case "chrome" -> {
                return new ChromeCapabilities();
            }
            case "firefox" -> {
                return new FirefoxCapabilities();
            }
            default -> {
                return null;
            }
        }
    }
}
