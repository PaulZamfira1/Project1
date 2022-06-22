package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class book1Page {

    @FindBy(xpath = "add-to-cart-button-37")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//h1[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"product_enteredQuantity_37\"]")
    private WebElement productQuantity;

    @FindBy(xpath = "//*[@id=\"price-value-37\"]")
    private WebElement productPrice;

    @FindBy(id = "checkout_attribute_1")
    private WebElement giftWrapping;

    @FindBy(xpath = "//strong[contains(text(),'$37.00')]")
    private static WebElement priceConfirmationMessage4;

}
