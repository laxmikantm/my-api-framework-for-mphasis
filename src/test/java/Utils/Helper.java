package Utils;
/**************************
 *  (C) L Somni            *
 ***************************/

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Helper {

    public static final String URL = "https://jsonplaceholder.typicode.com";
    public static final String LOCAL_URL = "https://localhost:8080.typicode.com";
    public static final String POSTS = "/posts";
    public static final String COMMENTS = "/comments";
    public static final String USERS_LIST = "/users";


    public static class ConfigurationException extends RuntimeException {

        public ConfigurationException(final String message) {
            super(message);
        }
    }

    public enum ENDPOINTS {
        POSTS("posts"),
        COMMENTS("comments"),
        USERS_LIST("users");
        private String item;
        ENDPOINTS(String item) {
            this.item = item;
        }
        public String getItem() {
            return item;
        }
    }

    public static Map<String, Object> json_to_map(File sampleJson) throws JsonParseException, JsonMappingException,
            IOException {

        Map<String, Object> map;

        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(sampleJson,
                new TypeReference<HashMap<String, Object>>() {
                });

        return map;
    }
}


