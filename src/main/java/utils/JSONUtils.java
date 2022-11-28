package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class JSONUtils {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public JSONUtils() {}

    private static HashMap<String, String> getMapFromJSONFile(Path path) {
        String data;
        try {
            data = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<>() {};
        try {
            return JSON_MAPPER.readValue(data, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValueFromJSON(Path path, String key) {
        HashMap<String, String> mapJSON = getMapFromJSONFile(path);
        return mapJSON.get(key);
    }
}
