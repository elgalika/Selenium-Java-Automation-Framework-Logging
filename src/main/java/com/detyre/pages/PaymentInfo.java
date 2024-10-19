package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentInfo extends HomePage{

        @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
    private WebElement continueButton;

    public void continueButtonClick(){
        continueButton.click();
    }
}
