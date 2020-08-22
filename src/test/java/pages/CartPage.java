package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement SubtotalProductPrice;

    @FindBy(xpath = "//div[@class='a-row sc-your-amazon-cart-is-empty']")
    private WebElement messageInCart;

    @FindBy(xpath = "//span[contains(@class, 'product-title')]")
    private WebElement productTitle;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double getSubtotalProductPrice() {
        return Double.parseDouble(SubtotalProductPrice.getText().substring(1));
    }

    public boolean isCartEmptyDisplayed() {
        waitVisibilityOfElement(15, messageInCart);
        messageInCart.isDisplayed();
        return true;
    }

    public String getProductTitle() {
        implicitWait(15);
        return productTitle.getText();
    }

    public void deleteProductInCart() {
        waitVisibilityOfElement(15, deleteButton);
        deleteButton.click();
    }
}


