package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCheckoutTest {
    book1Page book1page;
    CheckoutPage checkout;
    GiftStorePage giftstorepage;
    ShoesPage shoespage;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/fahrenheit-451-by-ray-bradbury");
        book1page = new book1Page();
        checkout = new CheckoutPage(driver);
        giftstorepage = new GiftStorePage(driver);
        shoespage = new ShoesPage(driver);

    }

    @Test
    //Check if we can successfully purchase a product
    public void canBuyProduct() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-37")).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkout.CheckoutAs("asd", "asd", "vrajeala@mailnesia.com", "Romania", "", "asd", "asd123", "123123", "123123123");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement((By.xpath("//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]"))).click();
        Thread.sleep(1000);
        driver.findElement((By.xpath("//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]"))).click();
        Thread.sleep(1000);
        driver.findElement((By.xpath("//button[contains(text(),'Confirm')]"))).click();
        Thread.sleep(1000);
        assertEquals(CheckoutPage.getValidMessage(), "Thank you");
    }

    @Test
    //Check if we can purchase MULTIPLE pairs of shoes & GIFT WRAPPING  & credit card
    public void canBuyShoesWithCredit() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-37")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Digital downloads')]")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Night Visions')]")).click();
        driver.findElement(By.id("add-to-cart-button-34")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Electronics')]")).click();
        driver.findElement((By.xpath("//img[@alt='Picture for category Camera & photo']"))).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nikon D5500 DSLR')]")).click();
        driver.findElement((By.id("add-to-cart-button-14"))).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Apparel')]")).click();
        driver.findElement(By.xpath("//img[@alt='Picture for category Shoes']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'adidas Consortium Campus 80s Running Shoes')]")).click();
        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.SelectSizeAs("10");
        driver.findElement(By.xpath("//label[@for='product_attribute_10_26']//span[@class='attribute-square-container']//span[@class='attribute-square']")).click();
        driver.findElement((By.id("add-to-cart-button-25"))).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        ShoppingCartPage shoppingcartpage = new ShoppingCartPage(driver);
        shoppingcartpage.GiftWrappingAs("Yes [+$10.00]");
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkout.CheckoutAs("asd", "asd", "vrajeala@mailnesia.com", "Romania", "", "asd", "asd123", "123123", "123123123");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("paymentmethod_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        checkout.CreditCardAs("asdf", "4929313593510560", "03", "2027", "847");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        Thread.sleep(1000);
        assertEquals(CheckoutPage.getValidMessage(), "Thank you");
    }

    @Test
    //Check if we can successfully add multiple products to cart
    public void canBuyMultipleProducts() {
        driver.findElement(By.id("add-to-cart-button-37")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Digital downloads')]")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Night Visions')]")).click();
        driver.findElement(By.id("add-to-cart-button-34")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Electronics')]")).click();
        driver.findElement((By.xpath("//img[@alt='Picture for category Camera & photo']"))).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nikon D5500 DSLR')]")).click();
        driver.findElement((By.id("add-to-cart-button-14"))).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        assertEquals(CheckoutPage.getValidPrice(), "$699.80");
    }

    @Test
    //Check if we can purchase MULTIPLE Gift Cards
    public void canBuyGiftCard() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Gift Cards')]")).click();
        driver.findElement((By.xpath("//h2[@class='product-title']//a[contains(text(),'$25 Virtual Gift Card')]"))).click();
        giftstorepage.PurchaseAs("asd", "altavrajeala@mailnesia.com", "asd", "vrajeala@mailnesia.com", "Happy Birthday!", "4");
        driver.findElement((By.id("add-to-cart-button-43"))).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        assertEquals(CheckoutPage.getpriceConfirmationMessage2(), "$350.00");

    }

    @Test
    //Check if we can customize our order
    public void canCustomizeOrder() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Apparel')]")).click();
        driver.findElement(By.xpath("//img[@alt='Picture for category Shoes']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'adidas Consortium Campus 80s Running Shoes')]")).click();
        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.SelectSizeAs("10");
        driver.findElement(By.xpath("//label[@for='product_attribute_10_26']//span[@class='attribute-square-container']//span[@class='attribute-square']")).click();
        driver.findElement((By.id("add-to-cart-button-25"))).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        assertEquals(ShoesPage.getpriceConfirmationMessage3(), "$27.56");
    }

    @Test
    //Check if we can add Gift Wrapping and if the total price will include gift wrapping
    public void canAddGiftWrapping() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li//a[contains(text(),'Apparel')]")).click();
        driver.findElement(By.xpath("//img[@alt='Picture for category Shoes']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'adidas Consortium Campus 80s Running Shoes')]")).click();
        ShoesPage shoespage = new ShoesPage(driver);
        shoespage.SelectSizeAs("10");
        driver.findElement(By.xpath("//label[@for='product_attribute_10_26']//span[@class='attribute-square-container']//span[@class='attribute-square']")).click();
        driver.findElement((By.id("add-to-cart-button-25"))).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        ShoppingCartPage shoppingcartpage = new ShoppingCartPage(driver);
        shoppingcartpage.GiftWrappingAs("Yes [+$10.00]");
        Thread.sleep(1000);
        assertEquals(ShoesPage.getpriceConfirmationMessage4(), "$37.56");
    }

    @Test
    //Check if we can checkout as guest and add billing Address
    public void canAddBillingAddress() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-37")).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkout.CheckoutAs("asd", "asd", "vrajeala@mailnesia.com", "Romania", "", "asd", "asd123", "123123", "123123123");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        assertEquals(CheckoutPage.getbillingAddressConfirmationMessage(), "Ground ($0.00)");
    }

    @Test
    //Check if we can pay with Credit Card
    public void canPayWithCreditCard() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-37")).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkout.CheckoutAs("asd", "asd", "vrajeala@mailnesia.com", "Romania", "", "asd", "asd123", "123123", "123123123");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("paymentmethod_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        checkout.CreditCardAs("asdf", "4929313593510560", "03", "2027", "847");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]")).click();
        Thread.sleep(1000);
        assertEquals(CheckoutPage.getcreditCardConfirmationMessage(), "CONFIRM");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
