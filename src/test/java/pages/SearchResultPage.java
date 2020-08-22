package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span/div[contains(@class, 'cf-section')]//span[contains(@class, 'base a-text-normal')]")
    private List<WebElement> searchResultsProductsList;

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 icp-link-style-2']")
    private WebElement changeLanguage;

    @FindBy(xpath = "//span[@class='nav-text'][contains(text(),'ES')]")
    private WebElement spanishLanguage;

    @FindBy(xpath = "//h1[@class='a-size-base a-color-base a-text-normal']")
    private WebElement textInPage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTextPresentInFirstResults(String containsText) {
        List<String> textElements = searchResultsProductsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .subList(0, 20);
        for (String text : textElements) {
            if (!text.contains(containsText)) {
                System.out.println(text);
                return false;
            }
        }
        return true;
    }

    public ProductPage clickOnFirsElement() {
        searchResultsProductsList.get(0).click();
        return new ProductPage(driver);
    }

    public void changeLanguageToSpain() {
        actionMoveToElement(changeLanguage);
        waitVisibilityOfElement(10, spanishLanguage);
        spanishLanguage.click();
    }

    public String getTextInPage() {
        return textInPage.getText();
    }

}
