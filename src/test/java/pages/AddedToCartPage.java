package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartPage extends BasePage {
    
    @FindBy(xpath = "//span[contains(@class, 'subtotal')]//span[contains(@class, 'a-text-bold')]")
    private WebElement addedSubtotalItemPrice;
    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    private WebElement buttonCart;


    public AddedToCartPage(WebDriver driver) {
        super(driver);
    }

    public double getCartSubtotal() {
        waitVisibilityOfElement(15, addedSubtotalItemPrice);
        return Double.parseDouble(addedSubtotalItemPrice.getText().substring(1));
    }

    public void clickButtonCart() {
        waitVisibilityOfElement(15, buttonCart);
        buttonCart.click();
    }
}
