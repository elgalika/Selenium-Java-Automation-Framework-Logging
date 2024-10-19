package com.detyre;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.detyre.pages.HomePage;
import com.detyre.pages.LoginPage;
import com.detyre.pages.Register2Page;
import com.detyre.pages.RegisterPage;

public class RegisterTest{

    private static final Logger logger = Logger.getLogger(RegisterTest.class.getName());

    private LoginPage loginPage;
    private HomePage homePage;
    private RegisterPage registerPage;
    private Register2Page register2Page;

    public RegisterTest(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        register2Page = new Register2Page();
    }

    @BeforeClass
    public void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("register-tests-report.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfulRegistrationForm() {
        homePage.navigateToHomePage();
        logger.info("Navigated to Home Page.");

        homePage.clickLogInMenuButton();
        logger.info("Clicked on Log In Menu Button.");

        loginPage.clickRegisterButton();
        logger.info("Clicked on Register Button.");

        registerPage.printRegisterPageTitle();
        logger.info("Printed Register Page Title.");

        registerPage.registrationForm("E", "L", "10", "January", "1990", "e.l@edu.al", "F", true, "password123", "password123");
        logger.info("Filled registration form.");

        registerPage.submitRegistrationForm();
        logger.info("Submitted registration form.");

        assertAndLog(register2Page.isRegistrationSuccessful(), 
                     "Registration was successful.", 
                     "Registration was not successful");

        register2Page.logOutButtonClick();
        logger.info("Logged out.");
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
        logger.info("Registration test completed.");
    }
}
