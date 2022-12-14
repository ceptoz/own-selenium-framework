package utils;

import java.util.Random;

import static utils.Constants.PATH_TO_CONFIG_DATA;
import static utils.JSONUtils.getValueFromJSON;

public class RandomProviderUtils {
    private static final int LOWERCASE_A_UNICODE_NUMBER = Character.codePointOf("LATIN SMALL LETTER A");
    private static final int LOWERCASE_Z_UNICODE_NUMBER = Character.codePointOf("LATIN SMALL LETTER Z");
    private static final int RANDOM_STRING_LENGTH = Integer.parseInt(getValueFromJSON(PATH_TO_CONFIG_DATA, "randomStringLength"));

    public static String createRandomString() {
        Random random = new Random();
        return random.ints(LOWERCASE_A_UNICODE_NUMBER, LOWERCASE_Z_UNICODE_NUMBER + 1)
                .limit(RANDOM_STRING_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
