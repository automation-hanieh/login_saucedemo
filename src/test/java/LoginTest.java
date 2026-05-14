
import org.testng.annotations.*;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
        System.out.println("✅ Login successful!");
    }

    @Test
    public void testFailedLogin() {
        loginPage.navigateTo();
        loginPage.login("wrong_user", "wrong_pass");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg.contains("Epic sadface"));
        System.out.println("✅ Failed login handled correctly!");
    }

    @Test
    public void testAddToCart() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        String cartCount = inventoryPage.getCartCount();
        Assert.assertEquals(cartCount, "1");
        System.out.println("✅ Item added to cart!");
    }

    @Test
    public void testCheckoutFlow() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        cartPage.goToCart();
        cartPage.clickCheckout();

        checkoutPage.fillInfo("Hanieh", "Mousavian", "12345");
        checkoutPage.finish();

        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!");
        System.out.println("✅ Checkout completed!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}