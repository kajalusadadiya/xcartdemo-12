package shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.cssSelector("li[class='leaf has-sub'] li:nth-child(1) a:nth-child(1)"));

        String expectedMessage = "Sale";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Sale", expectedMessage, actualMessage);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(2000);
        //?add to cart
        clickOnElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));//click on avengers fabrikations
        Thread.sleep(2000);
        clickOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div[3]/ul/li[2]/label/div/input[2]")); //check box of product
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/form[2]/div[2]/div[1]/div[3]/button[1]"));


        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Verification failed for Text : Product has been added to your cart", expectedMsg, actualMsg);

//to close pop up
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//your cart
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));// view cart
//verfy message
        String expectedMsgcart = "Your shopping cart - 1 item";
        String actualMsgcart = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 1 item", expectedMsgcart, actualMsgcart);
        clickOnElement(By.cssSelector("#amount16")); //qnty box
        driver.findElement(By.id("amount16")).clear();// clear qty box
        Thread.sleep(2000);
        driver.findElement(By.id("amount16")).sendKeys("2");
        //verfy cart qty2
        String expectedMsgcart2 = "Your shopping cart - 2 item";
        String actualMsgcart2 = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 2 item", expectedMsgcart2, actualMsgcart2);

//verify subtotal
        String expectedTotal = "Subtotal: $29.98";
        String actualTotal = getTextElement(By.xpath("//ul[@class='totals']//li[@class='subtotal']"));
        Assert.assertEquals("Verification failed for Text : Subtotal: $29.98", expectedTotal, actualTotal);

        //36 verify
        String expectedTotal1 = "36";
        String actualTotal1 = getTextElement(By.xpath("//span[normalize-space()='36']"));
        Assert.assertEquals("Verification failed for Text : 36", expectedTotal1, actualTotal1);

        // clickOnElement(By.xpath("//span[normalize-space()='Go to checkout']"));
        // clickOnElement(By.xpath("//span[text()='Go to checkout']"));
        // clickOnElement(By.xpath("/button[contains(@class,'regular-button regular-main-button checkout')]"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));

        String expectedloginmsg = "Log in to your account";
        String actualloginmsg = getTextElement(By.xpath("//h3[normalize-space()='Log in to your account']"));
        Assert.assertEquals("Verification failed for Text : Log in to your account", expectedloginmsg, actualloginmsg);

        sendTextToElement(By.xpath("//input[@id='email']"), "ram123@yahoo.com");
        clickOnElement(By.xpath("//span[normalize-space()='Continue']"));

        String expectedchkmsg = " Secure Checkout";
        String actualchkmsg = getTextElement(By.xpath("//h1[normalize-space()='Secure Checkout']"));
        Assert.assertEquals("Verification failed for Text :  Secure Checkout", expectedchkmsg, actualchkmsg);

        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "kaju");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "patel");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "20 northway");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "Busy");
        selectValueFromdropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "FR");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Watford");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "nd19 3gr");
        sendTextToElement(By.xpath("//input[@id='email']"), "kaju123@gmail");
        clickOnElement(By.xpath("//input[@id='create_profile']")); // checkbox
        sendTextToElement(By.xpath("//input[@id='password']"), "kaju654");
        clickOnElement(By.cssSelector("#method128"));
        clickOnElement(By.cssSelector("#pmethod6"));

        String expectedTotalmsg = " Total:";
        String actualTotalmsg = getTextElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("Verification failed for Text :  Total:", expectedTotalmsg, actualTotalmsg);

        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        String expectedThkmsg = "Thank you for your order";
        String actualThkmsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Thank you for your order", expectedThkmsg, actualThkmsg);
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.linkText("Bestsellers"));
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));

        //add to cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));


        clickOnElement(By.xpath("//a[contains(@class,'product-thumbnail next-previous-assigned')]//img[contains(@alt,'Vinyl Idolz: Ghostbusters')]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        //green message

        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Verification failed for Text : Product has been added to your cart", expectedMsg, actualMsg);
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));

        clickOnElement(By.xpath("//a[@class='regular-button cart']"));

        String expectedMsgcart = "Your shopping cart - 1 item";
        String actualMsgcart = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 1 item", expectedMsgcart, actualMsgcart);
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));

        String emptyCartMsg = "Are you sure you want to clear your cart?";
        String realEmptyCartMsg = driver.switchTo().alert().getText();//to get text which we can not inspect
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartMsg, realEmptyCartMsg);
        driver.switchTo().alert().accept();//when ok is also not inspected
        String empryCartMsg = "Item(s) deleted from your cart";
        //checking green bar message
        String actualEmptyCartMsgIs = getTextElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empryCartMsg, actualEmptyCartMsgIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your  empty cart message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);


    }
}
