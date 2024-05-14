package helper;

import java.util.List;

public interface WebElementOrderChecker {

    boolean areWebElementsOrderedLikeSpecifiedListByElementId(List<String> expectedOrder);

}
