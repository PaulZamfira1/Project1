package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftStorePage {
    @FindBy(id = "giftcard_43_RecipientName")
    private WebElement recipientNameInput;

    @FindBy(id = "giftcard_43_RecipientEmail")
    private WebElement recipientEmailInput;

    @FindBy(id = "giftcard_43_SenderName")
    private WebElement nameInput;

    @FindBy(id = "giftcard_43_SenderEmail")
    private WebElement emailInput;

    @FindBy(id = "giftcard_43_Message")
    private WebElement messageInput;

    @FindBy(id = "product_enteredQuantity_43")
    private WebElement quantityInput;

    public WebDriver driver;

    public GiftStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void PurchaseAs(String recipientName, String recipientEmail, String name, String email, String message, String quantity) {
        recipientNameInput.sendKeys(recipientName);
        recipientEmailInput.sendKeys(recipientEmail);
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
        quantityInput.sendKeys(quantity);
    }

    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    private static WebElement confirmationMessage;

    public static String getValidMessage() {
        return confirmationMessage.getText();
    }
}
