package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage {

    //billing address
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement emailInput;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryInput;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    private WebElement stateInput;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityInput;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement addressInput;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement postalCodeInput;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]")
    private WebElement continueButton;

    //shipping method
    @FindBy(id = "shippingoption_0")
    List<WebElement> shippingOptionInput;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")
    private WebElement continue1Button;

    //payment method
    @FindBy(id = "paymentmethod_0")
    private WebElement paymentMethodButton;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")
    private WebElement continue2Button;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]")
    private WebElement continue3Button;

    //confirm order
    @FindBy(xpath = "//a[@class='product-name']")
    private WebElement productName;

    @FindBy(xpath = "//span[@class='product-unit-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//span[@class='product-quantity']")
    private WebElement productQuantity;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private WebElement confirmButton;

    //Credit Card
    @FindBy(id = "CardholderName")
    private WebElement cardHolderNameInput;

    @FindBy(id = "CardNumber")
    private WebElement cardNumberInput;

    @FindBy(id = "ExpireMonth")
    private WebElement monthInput;

    @FindBy(id = "ExpireYear")
    private WebElement yearInput;

    @FindBy(id = "CardCode")
    private WebElement cardCodeInput;

    public void selectCountry(String country) {
        Select select = new Select(countryInput);
        select.selectByVisibleText(country);
    }

    public void selectState(String state) {
        Select select = new Select(stateInput);
        select.selectByVisibleText(state);
    }

    public void selectExpMonth(String month) {
        Select select = new Select(monthInput);
        select.selectByVisibleText(month);
    }

    public void selectExpYear(String year) {
        Select select = new Select(yearInput);
        select.selectByVisibleText(year);
    }

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckoutAs(String firstName, String lastName, String email, String country, String state, String city, String address, String postalCode, String phoneNumber) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        countryInput.sendKeys(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        addressInput.sendKeys(address);
        postalCodeInput.sendKeys(postalCode);
        phoneInput.sendKeys(phoneNumber);
        continueButton.click();
    }

    public void CreditCardAs(String name, String cardNumber, String month, String year, String code) {
        cardHolderNameInput.sendKeys(name);
        cardNumberInput.sendKeys(cardNumber);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
        cardCodeInput.sendKeys(code);
    }

    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    private static WebElement confirmationMessage;

    public static String getValidMessage() {
        return confirmationMessage.getText();
    }

    @FindBy(xpath = "//span[@class='value-summary']//strong[contains(text(),'$699.80')]")
    private static WebElement priceConfirmationMessage1;

    public static String getValidPrice() {
        return priceConfirmationMessage1.getText();
    }

    @FindBy(xpath = "//span[@class='value-summary']//strong[contains(text(),'$350.00')]")
    private static WebElement priceConfirmationMessage2;

    public static String getpriceConfirmationMessage2() {
        return priceConfirmationMessage2.getText();
    }

    @FindBy(xpath = "//label[@for='shippingoption_0']")
    private static WebElement billingAddressConfirmationMessage;

    public static String getbillingAddressConfirmationMessage() {
        return billingAddressConfirmationMessage.getText();
    }

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private static WebElement creditCardConfirmationMessage;

    public static String getcreditCardConfirmationMessage() {
        return creditCardConfirmationMessage.getText();
    }

}
