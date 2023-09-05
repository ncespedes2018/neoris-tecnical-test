package co.com.neoris.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public abstract class CommonTest {

    protected static ObjectMapper objectMapper = new ObjectMapper();

    protected CommonTest() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writerWithDefaultPrettyPrinter();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * @param objectList list of objects
     * @return return list as json string
     */
    protected String objectListToJson(List<?> objectList) {
        String arrayToJson;
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writerWithDefaultPrettyPrinter();
        try {
            arrayToJson = objectMapper.writeValueAsString(objectList);
            return arrayToJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Parses the json array.
     *
     * @param <T>                        the generic type
     * @param filename                   the filename
     * @param classOnWhichArrayIsDefined the class on which array is defined
     * @return the list
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> parseJsonArray(String filename, Class<T> classOnWhichArrayIsDefined) {
        try {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            objectMapper.setDateFormat(df);

            objectMapper.registerModule(new JavaTimeModule());

            BufferedReader br;
            Resource resource = new ClassPathResource(filename);
            br = new BufferedReader(new FileReader(resource.getFile()));
            Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
            T[] objects = objectMapper.readValue(br, arrayClass);
            return Arrays.asList(objects);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    protected String objectToJson(Object object) {
        String objectToJson;
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writerWithDefaultPrettyPrinter();
        try {
            objectToJson = objectMapper.writeValueAsString(object);
            return objectToJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static <T> T jsonToObject(String filename, Class<T> classObject) {
        T objectFromJson;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(df);

        objectMapper.registerModule(new JavaTimeModule());

        try {
            BufferedReader br;
            Resource resource = new ClassPathResource(filename);
            br = new BufferedReader(new FileReader(resource.getFile()));
            objectFromJson = objectMapper.readValue(br, classObject);
            return objectFromJson;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
