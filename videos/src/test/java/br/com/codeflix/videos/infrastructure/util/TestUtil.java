package br.com.codeflix.videos.infrastructure.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class TestUtil {

    public static final UUID ID = UUID.fromString("b60e59c0-bc9e-4249-b358-f841542d0733");
    public static final UUID ID2 = UUID.fromString("6b457c92-c9c2-432b-92f2-b48d0aefc7e4");

    public static String NAME = "Name test";
    public static String DESCRIPTION = "Description test";
    public static Boolean IS_ACTIVE_TRUE = true;
    public static Boolean IS_ACTIVE_FALSE = false;
    public static LocalDateTime CREATED_AT = LocalDateTime.now();
    public static LocalDateTime UPDATE_AT = LocalDateTime.now();
    public static LocalDateTime DELETE_AT = LocalDateTime.now();

    /**
     * Convert an object to JSON byte array.
     *
     * @param object the object to convert
     * @return the JSON byte array
     * @throws IOException Exceção a ser lançada
     */
    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);

        return mapper.writeValueAsBytes(object);
    }


}
