package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(xpath = "//button[contains(text(),'Checkout as Guest')]")
    private WebElement checkoutAsGuestButton;

    public void setCheckoutAsGuest() {
        checkoutAsGuestButton.click();
    }
}

