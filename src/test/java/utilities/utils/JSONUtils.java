package utilities.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtils {
    static final Logger log = LogManager.getLogger(JSONUtils.class);

    public static void writeJSONObjectToFile(JSONObject jsonObject, String filePath)
            throws IOException {
        // Create a new FileWriter object
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(jsonObject.toString());
        fileWriter.close();
        log.info("JSON Object Successfully written to the file!!");
    }

    public static JSONObject parseJsonFile(String fileName) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert content != null;
        return new JSONObject(content);
    }
}
