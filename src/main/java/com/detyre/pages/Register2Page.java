package com.detyre.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register2Page extends HomePage {
    @FindBy(css = "body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")
    public WebElement logOutButtonWebElement;

    @FindBy(className = "result")
    private WebElement registrationResultElement;

    public void logOutButtonClick() {
        logOutButtonWebElement.click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            return registrationResultElement.isDisplayed()
                    && registrationResultElement.getText().equals("Your registration completed");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getRegistrationResultText() {
        String divText = registrationResultElement.getText();
        System.out.println("Registration Result: " + divText);
    }

}
