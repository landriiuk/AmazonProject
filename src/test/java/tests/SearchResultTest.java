package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SearchResultTest extends BaseTest {
    private static final String SEARCH_KEYWORD = "PUMA Women's Tee";
    private static final String SEARCH_KEYWORD_CONTAINS = "PUMA";


    public static final String INVALID_KEYWORD = "fhddnf";
    private static final String TEXT_MESSAGE = "El precio y otros detalles pueden variar según el tamaño y el color.";

    @Test
    public void checkIfFirstResultsContainSearchKeyword() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getSearchResultPage().isTextPresentInFirstResults(SEARCH_KEYWORD_CONTAINS),
                "Search result is not present");
    }

    @Test
    public void checkIfInvalidElementNotFound() {
        getHomePage().searchByKeyword(INVALID_KEYWORD);
        assertTrue(getHomePage().isMessageDisplayed(), "Result is displayed");
    }

    @Test
    public void CheckLanguageChange() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().changeLanguageToSpain();
        assertEquals(getSearchResultPage().getTextInPage(), TEXT_MESSAGE);
    }
}
