package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//select[@name='dropdown_selected_size_name']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//input[@name='submit.add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//h1[@class='a-size-medium a-text-bold']")
    WebElement messageAddedElement;

    @FindBy(xpath = "//select[@name='quantity']")
    WebElement quantitySelect;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    WebElement productPrice;

    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement productTitle;

    @FindBy(xpath = "//input[@name='high-price']")
    WebElement inputHighPrice;

    @FindBy(xpath = "//span[@id='a-autoid-1']")
    WebElement goButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSizeElement(String size) {
        waitVisibilityOfElement(15, sizeSelect);
        new Select(sizeSelect)
                .selectByVisibleText(size);
    }

    public void selectQuantity(Integer quantity) {
        new Select(quantitySelect)
                .selectByVisibleText(quantity.toString());
    }

    public void clickAddToCartButton() {
        waitVisibilityOfElement(15, quantitySelect);
        addToCartButton.click();
    }

    public boolean isMessageAddedDisplayed() {
        waitVisibilityOfElement(15, messageAddedElement);
        return messageAddedElement.isDisplayed();
    }

    public double getProductPrice() {
        waitVisibilityOfElement(15, quantitySelect);
        return Double.parseDouble(productPrice.getText().substring(1));
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void enterHighFilterElement(String filterElement) {
        waitVisibilityOfElement(10, inputHighPrice);
        inputHighPrice.sendKeys(filterElement);
        waitVisibilityOfElement(10, goButton);
        goButton.click();
    }

}
