package one.challenge.literalura.utilities;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {
    public static String encodeText(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    public static <T> T dataProcess(String json, Class<T> type) {
        try {
            return new ObjectMapper().readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

