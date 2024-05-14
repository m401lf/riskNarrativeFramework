package webelementdata;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableData {

    private final WebElement tableBody;
    private final List<WebElement> tableHeaders = new ArrayList<WebElement>();
    private final List<String> actualHeaderTitles = new ArrayList<String>();
    private final List<String> actualTableBodyContent = new ArrayList<String>();
    private final List<WebElement> tableRows = new ArrayList<>();
    private final List<List<String>> tableContentWithinAllRows = new ArrayList<>();
    private WebElement tableHeadersRow;
    private List<String> expectedOrderOfHeaderIds;
    private List<String> expectedHeaderTitles;
    private List<String> expectedTableBodyContent;
    private List<String> expectedOrderOfTableBodyContentIds;

    public TableData(WebElement tableHeadersRow, WebElement tableBody, List<String> expectedOrderOfHeaderIds,
                     List<String> expectedHeaderTitles, List<String> expectedTableBodyContent,
                     List<String> expectedOrderOfTableBodyContentIds) {
        this.tableBody = tableBody;
        this.tableHeadersRow = tableHeadersRow;
        this.expectedOrderOfHeaderIds = expectedOrderOfHeaderIds;
        this.expectedHeaderTitles = expectedHeaderTitles;
        this.expectedTableBodyContent = expectedTableBodyContent;
        this.expectedOrderOfTableBodyContentIds = expectedOrderOfTableBodyContentIds;
    }

    public TableData(WebElement tableBody) {
        this.tableBody = tableBody;
    }

/*	public List<String> getActualTableBodyContentForRow(int rowNumber) throws TableRowDoesNotExistException {
		if (actualTableBodyContent.isEmpty()) {

			List<WebElement> childElements = WebElementFinderUtils
					.findAllChildElementsOfParentElementInActualOrder(getTableBodyRowWebElement(rowNumber));
			for (WebElement element : childElements) {
				if (childElementIsACellWithText(element)) {
					actualTableBodyContent.add(element.getText());
				}
			}
		}

		return actualTableBodyContent;
	}*/

/*	public WebElement getTableBodyRowWebElement(int rowNumber) throws TableRowDoesNotExistException {
		return WebElementFinderUtils.findTableRow(getTableBodyId(), rowNumber);
	}*/

    private boolean childElementIsACellWithText(WebElement element) {
        return element.getText() != null && childElementIsACell(element);
    }

    private boolean childElementIsACell(WebElement element) {
        return element.getTagName().equals("th") || element.getTagName().equals("td");
    }

    public String getTableBodyId() {
        return tableBody.getAttribute("id");
    }

	/*public List<String> getActualHeaderTitles() {
		if (actualHeaderTitles.isEmpty()) {
			List<WebElement> childElements = WebElementFinderUtils
					.findAllChildElementsOfParentElementInActualOrder(getTableHeadersRowId());
			for (WebElement element : childElements) {
				if (element.getText() != null) {
					actualHeaderTitles.add(element.getText());
				}
			}
		}

		return actualHeaderTitles;
	}*/

    public String getTableHeadersRowId() {
        return tableHeadersRow.getAttribute("id");
    }

    public List<String> getExpectedTableBodyContent() {
        return expectedTableBodyContent;
    }

    public List<String> getExpectedOrderOfHeaderIds() {
        return expectedOrderOfHeaderIds;
    }

    public List<String> getExpectedHeaderTitles() {
        return expectedHeaderTitles;
    }

    public List<String> getExpectedOrderOfTableBodyContentIds() {
        return expectedOrderOfTableBodyContentIds;
    }

	/*public List<WebElement> getAllActualTableCells() {
		List<WebElement> rows = getAllActualTableRows();
		List<WebElement> rowCells = new ArrayList<>();
		for (WebElement element : rows) {
			if (childElementIsACell(element)) {
				rowCells.add(element);
			}
		}

		return rowCells;
	}*/

	/*public List<WebElement> getAllActualTableRows() {
		if (tableRows.isEmpty()) {
			tableRows = WebElementFinderUtils.findAllTableRows(getTableBodyId());
		}
		return tableRows;
	}*/

	/*public List<List<String>> getActualTableBodyContentForAllRows() throws TableRowDoesNotExistException {
		if (tableContentWithinAllRows.isEmpty()) {
			for (int i = 0; i < getAllActualTableRows().size(); i++) {
				tableContentWithinAllRows.add(getActualTableBodyContentForRow(i));
			}
		}
		return tableContentWithinAllRows;
	}*/

}
