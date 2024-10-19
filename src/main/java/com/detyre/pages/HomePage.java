package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.detyre.utils.DriverFactory;
import com.detyre.utils.GlobalConfig;

public class HomePage {

     public HomePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(linkText =  "Log in")
        public WebElement logInButtonWebElement;


    public void clickLogInMenuButton(){
        // navigateToHomePage();
        logInButtonWebElement.click();

    }

    public void navigateToHomePage() {
        DriverFactory.getDriver().get(GlobalConfig.BASE_URL);
    }

}
