package helper.resource;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ResourceHelper {

    final static Logger log = LogManager.getLogger(ResourceHelper.class);

    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        log.info(basePath + "/" + path);
        return basePath + "/" + path;
    }
}