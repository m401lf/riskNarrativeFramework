package maps;

import java.util.HashMap;
import java.util.Map;

public class PageHeadings {
    private static final Map<String, String> pageHeadingMap;

    static {
        pageHeadingMap = new HashMap<>();
        pageHeadingMap.put("Professional and vocational training table", "Professional and vocational training");
        pageHeadingMap.put("Applications", "Your applications");
        pageHeadingMap.put("Tell us your immigration status", "Tell us your immigration status");
    }

    public static String getHeadingForPage(String pageName) {
        String pageHeading = pageHeadingMap.get(pageName);
        return pageHeading != null ? pageHeading : pageName;
    }

}
