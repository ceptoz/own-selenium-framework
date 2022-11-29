package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.LoggerUtils.errorLog;

public class JSONUtils {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public JSONUtils() {}

    private static HashMap<String, String> getMapFromJSONFile(Path path) {
        String data;
        try {
            data = Files.readString(path);
        } catch (IOException e) {
            errorLog("Cannot locate file. Check path");
            throw new RuntimeException(e);
        }
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<>() {};
        try {
            return JSON_MAPPER.readValue(data, typeReference);
        } catch (JsonProcessingException e) {
            errorLog("Cannot process data");
            throw new RuntimeException(e);
        }
    }

    public static String getValueFromJSON(Path path, String key) {
        HashMap<String, String> mapJSON = getMapFromJSONFile(path);
        return mapJSON.get(key);
    }

    public static <T> List<T> getObjectsFromJSON(Path path, Class<T> modelClass) {
        List<T> objects;
        String data;
        try {
            data = Files.readString(path);
        } catch (IOException e) {
            LoggerUtils.errorLog("File not found by specified path!");
            throw new RuntimeException(e);
        }
        CollectionType listType =
                JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, modelClass);
        try {
            objects = JSON_MAPPER.readValue(data, listType);
        } catch (JsonProcessingException e) {
            LoggerUtils.errorLog("Data cannot be deserialized");
            throw new RuntimeException(e);
        }
        return objects;
    }
}
