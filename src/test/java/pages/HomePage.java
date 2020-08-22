package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='nav-search-field ']/input")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement iconCart;

    @FindBy(xpath = "//div[@class='a-section a-spacing-base a-spacing-top-medium']")
    private WebElement noResultForMessage;

   
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnTheCart() {
        iconCart.click();
    }

    public boolean isMessageDisplayed() {
        return noResultForMessage.isDisplayed();
    }


}
