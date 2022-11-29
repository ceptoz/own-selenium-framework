package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.JSONUtils.getValueFromJSON;

public class Constants {
    private static final String RESOURCES_PATH = "src/main/resources";
    public static final Path PATH_TO_CONFIG_DATA = Paths.get(String.format("%s/config_data.json", RESOURCES_PATH));
    public static final Path CHROME_SETTINGS = Paths.get(String.format("%s/configs/chrome_settings.json", RESOURCES_PATH));
    public static final Path FIREFOX_SETTINGS = Paths.get(String.format("%s/configs/firefox_settings.json", RESOURCES_PATH));
    public static final Path USERS_FILE = Paths.get(String.format("%s/users.json", RESOURCES_PATH));
    public static final String CURRENT_BROWSER = getValueFromJSON(PATH_TO_CONFIG_DATA, "currentBrowser");
    public static final String DEFAULT_URL = getValueFromJSON(PATH_TO_CONFIG_DATA, "defaultUrl");
    public static final int NUMBER_OF_ROWS = Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "numberOfRowsInTable"));
    public static final int NUMBER_OF_COLUMNS = Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "numberOfColumnsInTable"));
    public static final int USER_NUMBER = Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "numberOfUserToChoose"));
}
