package com.detyre;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.detyre.pages.DashboardPage;
import com.detyre.pages.HomePage;
import com.detyre.pages.LoginPage;
import com.detyre.pages.NotebooksPage;

public class DashboardTest {

    private static final Logger logger = Logger.getLogger(DashboardTest.class.getName());

    private LoginPage loginPage;
    private HomePage homePage;
    private DashboardPage dashboardPage;
    private NotebooksPage notebooksPage;
    private LoginTests loginTests;

    public DashboardTest() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        notebooksPage = new NotebooksPage();
        loginTests = new LoginTests();
    }

    @BeforeClass
    public void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("dashboard-tests-report.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfulDashboardTest() {
        loginTests.successfulLoginForDashboardTest();
        logger.info("Successfully logged in for Dashboard Test.");

        dashboardPage.hoverComputerButton();
        logger.info("Hovered over Computer button.");

        dashboardPage.navigateToNotebooks();
        logger.info("Navigated to Notebooks page.");

        notebooksPage.notebookPageTitleVerification();
        logger.info("Verified Notebooks page title.");

        notebooksPage.addSecondItemToWishlist();
        assertAndLog(notebooksPage.getNotificationMessage().contains("The product has been added to your wishlist"), 
                     "Second item added to wishlist successfully.", 
                     "Wishlist notification for second item not displayed.");

        notebooksPage.addThirdItemToWishlist();
        assertAndLog(notebooksPage.getNotificationMessage().contains("The product has been added to your wishlist"), 
                     "Third item added to wishlist successfully.", 
                     "Wishlist notification for third item not displayed.");

        notebooksPage.addFourthItemToCart();
        assertAndLog(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), 
                     "Fourth item added to cart successfully.", 
                     "Cart notification for fourth item not displayed.");

        notebooksPage.addFifthItemToCart();
        assertAndLog(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), 
                     "Fifth item added to cart successfully.", 
                     "Cart notification for fifth item not displayed.");

        notebooksPage.addSixthItemToCart();
        assertAndLog(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), 
                     "Sixth item added to cart successfully.", 
                     "Cart notification for sixth item not displayed.");

        assertAndLog(notebooksPage.getWishlistCount() == 2, 
                     "Wishlist count matches expected value.", 
                     "Wishlist count mismatch.");

        assertAndLog(notebooksPage.getCartCount() == 3, 
                     "Shopping Cart count matches expected value.", 
                     "Shopping Cart count mismatch.");

        dashboardPage.logOutButtonWebElement.click();
        logger.info("Logged out successfully after Dashboard Test.");
    }

    private void assertAndLog(boolean condition, String successMessage, String failureMessage) {
        if (condition) {
            logger.info(successMessage);
        } else {
            logger.severe(failureMessage);
            Assert.fail(failureMessage);
        }
    }



    @Test
    public void successfulDashboardForShoppingCartTest() {
        loginTests.successfulLoginForDashboardTest();
        dashboardPage.hoverComputerButton();
        dashboardPage.navigateToNotebooks();
        notebooksPage.notebookPageTitleVerification();
        
        // notebooksPage.addSecondItemToWishlist();
        // Assert.assertTrue(notebooksPage.getNotificationMessage().contains("The product has been added to your wishlist"), "Wishlist notification not displayed");
        
        // notebooksPage.addThirdItemToWishlist();
        // Assert.assertTrue(notebooksPage.getNotificationMessage().contains("The product has been added to your wishlist"), "Wishlist notification not displayed");

        // notebooksPage.addFourthItemToCart();
        // Assert.assertTrue(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), "Cart notification not displayed");

        // notebooksPage.addFifthItemToCart();
        // Assert.assertTrue(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), "Cart notification not displayed");

        // notebooksPage.addSixthItemToCart();
        // Assert.assertTrue(notebooksPage.getNotificationMessage().contains("The product has been added to your shopping cart"), "Cart notification not displayed");

        Assert.assertEquals(notebooksPage.getWishlistCount(), 2, "Wishlist count mismatch");
        Assert.assertEquals(notebooksPage.getCartCount(), 3, "Shopping Cart count mismatch");


    }


    @AfterMethod
    public void tearDown() {
        logger.info("Dashboard test completed.");
    }
}
