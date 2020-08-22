package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageTest extends BaseTest {
    private static final String SIZE_PRODUCT = "Medium";
    private static final String SEARCH_KEYWORD = "B07Y1R1KN3";

    @Test
    public void checkIfItemAddedToCart() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnFirsElement();
        getProductPage().selectSizeElement(SIZE_PRODUCT);
        getProductPage().clickAddToCartButton();
        Assert.assertTrue(getProductPage().isMessageAddedDisplayed());
    }

    @Test
    public void checkCartItemPrice() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnFirsElement();
        getProductPage().selectSizeElement(SIZE_PRODUCT);
        double productPrice = getProductPage().getProductPrice();
        getProductPage().clickAddToCartButton();
        assertEquals(getAddedToCartPage().getCartSubtotal(), productPrice);
        getAddedToCartPage().clickButtonCart();
        assertEquals(getCartPage().getSubtotalProductPrice(), productPrice);
    }

    @Test
    public void checkQuantityPriceCounting() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnFirsElement();
        getProductPage().selectSizeElement(SIZE_PRODUCT);
        double productPrice = roundToDecimal(getProductPage().getProductPrice() * 3);
        getProductPage().selectQuantity(3);
        getProductPage().clickAddToCartButton();
        assertEquals(getAddedToCartPage().getCartSubtotal(), productPrice);
        getAddedToCartPage().clickButtonCart();
        assertEquals(getCartPage().getSubtotalProductPrice(), productPrice);
    }

    @Test
    public void checkIfCartIsEmpty() {
        getHomePage().clickOnTheCart();
        Assert.assertTrue(getCartPage().isCartEmptyDisplayed(),
                "Cart not empty");
    }

    @Test
    public void checkIfProductAddedToCart() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnFirsElement();
        getProductPage().selectSizeElement(SIZE_PRODUCT);
        String productTitle = getProductPage().getProductTitle();
        getProductPage().clickAddToCartButton();
        getAddedToCartPage().clickButtonCart();
        Assert.assertTrue(getCartPage().getProductTitle().contains(productTitle));
    }

    @Test
    public void checkDeletedProduct() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnFirsElement();
        getProductPage().selectSizeElement(SIZE_PRODUCT);
        getProductPage().clickAddToCartButton();
        getAddedToCartPage().clickButtonCart();
        getCartPage().deleteProductInCart();
        assertTrue(getCartPage().isCartEmptyDisplayed(), "");

    }
}