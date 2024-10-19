package com.detyre;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.detyre.pages.CheckOutPage;
import com.detyre.pages.CheckOutShippingMethodPage;
import com.detyre.pages.CompletedPage;
import com.detyre.pages.ConfirmOrderPage;
import com.detyre.pages.NotebooksPage;
import com.detyre.pages.PaymentInfo;
import com.detyre.pages.PaymentMethodPage;
import com.detyre.pages.RegisterPage;
import com.detyre.pages.ShoppingCartPage;
import com.detyre.utils.DriverFactory;

public class ShoppingCartTest {

    private static final Logger logger = Logger.getLogger(ShoppingCartTest.class.getName());

    NotebooksPage notebooksPage;
    ShoppingCartPage shoppingCartPage;
    DashboardTest dashboardTest;
    CheckOutPage checkOutPage;
    CheckOutShippingMethodPage checkOutShippingMethodPage;
    PaymentMethodPage paymentMethodPage;
    PaymentInfo paymentInfo;
    ConfirmOrderPage confirmOrderPage;
    CompletedPage completedPage;
    RegisterPage registerPage;

    public ShoppingCartTest() {
        notebooksPage = new NotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
        dashboardTest = new DashboardTest();
        checkOutPage = new CheckOutPage();
        checkOutShippingMethodPage = new CheckOutShippingMethodPage();
        paymentMethodPage = new PaymentMethodPage();
        paymentInfo = new PaymentInfo();
        confirmOrderPage = new ConfirmOrderPage();
        completedPage = new CompletedPage();
        registerPage = new RegisterPage();
    }

    @BeforeClass
    public void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("shopping-cart-tests-report.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shoppingCartTest() {
        dashboardTest.successfulDashboardForShoppingCartTest();
        logger.info("Successfully completed Dashboard Test for Shopping Cart.");

        Assert.assertTrue(notebooksPage.goToCartElementButtonIsDisplayed(), "Go to cart button not displayed");
        logger.info("Go to cart button displayed.");

        notebooksPage.goToCartClick();

        Assert.assertTrue(shoppingCartPage.shopingCartPageTitleVerification().contains("nopCommerce demo store. Shopping Cart"),
                "You are not in Shopping cart page");
        logger.info("Navigated to Shopping Cart page.");

        Assert.assertTrue(shoppingCartPage.continueShoppingButtonIsDisplayed(),
                "Continue Shopping button not displayed");
        logger.info("Continue Shopping button displayed.");

        Assert.assertTrue(shoppingCartPage.estimateShippingButtonIsDisplayed(),
                "Estimate Shipping button not displayed");
        logger.info("Estimate Shipping button displayed.");

        List<Double> productSubtotals = shoppingCartPage.getProductSubtotals();
        double totalValue = shoppingCartPage.getTotalValue();

        double sumOfSubtotals = 0.0;
        for (double subtotal : productSubtotals) {
            sumOfSubtotals += subtotal;
        }

        Assert.assertEquals(sumOfSubtotals, totalValue, "Total price mismatch");
        logger.info("Total price matches the sum of product subtotals.");

        shoppingCartPage.termsofserviceAgreementButonClick();
        shoppingCartPage.checkOutButtonClick();

        Assert.assertEquals(checkOutPage.getFirstNameValue(), "E", "First name does not match");
        Assert.assertEquals(checkOutPage.getLastNameValue(), "L", "Last name does not match");
        Assert.assertEquals(checkOutPage.getEmailValue(), "e.l@edu.al", "Email does not match");

        checkOutPage.fillBillingAddress("A", "T", "123 Main Street", "1000", "1234567890");
        checkOutShippingMethodPage.nextDayAirRadioButtonClick();
        checkOutShippingMethodPage.continueButtonClick();
        paymentMethodPage.checkMoneyOrderRadioButtonClick();
        paymentMethodPage.continueButtonClick();
        paymentInfo.continueButtonClick();

        Assert.assertEquals(confirmOrderPage.getTotalValueConfirmation(), totalValue, "Total price mismatch");

        confirmOrderPage.continueButtonClick();

        Assert.assertTrue(completedPage.completedSuccessfulMessage().contains("Your order has been successfully processed!"),
                "Element not found");
        logger.info("Order successfully processed.");

        Assert.assertTrue(completedPage.orderNumberTextIsDisplayed(), "Failed, Order number not displayed!!!!");
        logger.info("Order number displayed.");

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getDriver().quit();
        logger.info("WebDriver quit successfully.");
    }
}
