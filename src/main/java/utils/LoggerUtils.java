package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
    private static final Logger LOG = LogManager.getLogger(LoggerUtils.class);

    public static void infoLog(String msg) {
        LOG.info(msg);
    }

    public static void debugLog(String action, String elementName) {
        LOG.debug(action + elementName);
    }

    public static void debugLog(String msg) {
        LOG.debug(msg);
    }

    public static void errorLog(String msg) {
        LOG.error(msg);
    }
}
