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

public class LoginTests {
    private static final Logger logger = Logger.getLogger(LoginTests.class.getName());

    private LoginPage loginPage;
    private HomePage homePage;
    private DashboardPage dashboardPage;

    public LoginTests(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @BeforeClass
    public void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("login-tests-report.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfulLoginTest(){
        homePage.navigateToHomePage();
        logger.info("Navigated to Home Page.");

        homePage.clickLogInMenuButton();
        logger.info("Clicked on Log In Menu Button.");

        loginPage.loginForm("e.l@edu.al", "password123");
        logger.info("Entered login credentials.");

        loginPage.clickLoginButton();
        logger.info("Clicked on Login Button.");

        assertAndLog(dashboardPage.getWelcomeMessage().contains("Welcome to our store"), 
                     "Welcome message displayed.", 
                     "Welcome message not displayed");

        assertAndLog(dashboardPage.isLogOutButtonDisplayed(), 
                     "Log out menu displayed.", 
                     "Log out menu not displayed");

        dashboardPage.logOutButtonClick();
        logger.info("Logged out.");
    }

    public void successfulLoginForDashboardTest(){
        homePage.navigateToHomePage();
        logger.info("Navigated to Home Page.");

        homePage.clickLogInMenuButton();
        logger.info("Clicked on Log In Menu Button.");

        loginPage.loginForm("e.l@edu.al", "password123");
        logger.info("Entered login credentials.");

        loginPage.clickLoginButton();
        logger.info("Clicked on Login Button.");

        assertAndLog(dashboardPage.getWelcomeMessage().contains("Welcome to our store"), 
                     "Welcome message displayed.", 
                     "Welcome message not displayed");

        assertAndLog(dashboardPage.isLogOutButtonDisplayed(), 
                     "Log out menu displayed.", 
                     "Log out menu not displayed");
    }

    private void assertAndLog(boolean condition, String successMessage, String failureMessage) {
        if (condition) {
            logger.info(successMessage);
        } else {
            logger.severe(failureMessage);
            Assert.fail(failureMessage);
        }
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Login test completed.");
    }
}
