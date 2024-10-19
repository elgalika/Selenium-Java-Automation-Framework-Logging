package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

    @FindBy(css = "button.button-1.register-button")
    public WebElement registerButtonWebElement;

    @FindBy(id = "Email")
    public WebElement emailInpuWebElement;

    @FindBy(id = "Password")
    public WebElement passwordInpuWebElement;

    @FindBy(id = "RememberMe")
    public WebElement rememberMeWebElement;

    @FindBy(css = "button.button-1.login-button")
    public WebElement logInButonWebElement;

    public void loginForm(String email, String password) {
        emailInpuWebElement.clear();
        emailInpuWebElement.sendKeys(email);
        passwordInpuWebElement.clear();
        passwordInpuWebElement.sendKeys(password);
        rememberMeWebElement.click();

    }
    public void clickRegisterButton() {
        registerButtonWebElement.click();
    }

    public void clickLoginButton() {
        logInButonWebElement.click();

    }

}
