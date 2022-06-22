package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoesPage {

    @FindBy(id = "product_attribute_9")
    private WebElement sizeInput;

    @FindBy(id = "product_enteredQuantity_25")
    private WebElement quantityInput;

    public void selectSize(String size) {
        Select select = new Select(sizeInput);
        select.selectByVisibleText(size);
    }

    public WebDriver driver;

    public ShoesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SelectSizeAs(String size) {
        sizeInput.sendKeys(size);
    }

    @FindBy(xpath = "//span[@class='value-summary']//strong[contains(text(),'$27.56')]")
    private static WebElement priceConfirmationMessage3;

    public static String getpriceConfirmationMessage3() {
        return priceConfirmationMessage3.getText();
    }

    @FindBy(xpath = "//strong[contains(text(),'$37.56')]")
    private static WebElement priceConfirmationMessage4;

    public static String getpriceConfirmationMessage4() {
        return priceConfirmationMessage4.getText();
    }
}
