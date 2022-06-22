package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
    @FindBy(xpath = "//a[@class='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//span[@class='product-unit-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"itemquantity11245\"]")
    private WebElement productQuantity;

    @FindBy(id = "checkout_attribute_1")
    private WebElement giftWrapping;

    @FindBy(xpath = "//input[@id='termsofservice']")
    private WebElement termsOfService;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public WebDriver driver;

    public void selectGiftWrapping(String wrapping) {
        Select select = new Select(giftWrapping);
        select.selectByVisibleText(wrapping);
    }

    public void checkbox(boolean checkbox) {
        driver.findElement(By.id("termsofservice")).isSelected();
    }

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GiftWrappingAs(String gift) {
        giftWrapping.sendKeys(gift);
    }

}

