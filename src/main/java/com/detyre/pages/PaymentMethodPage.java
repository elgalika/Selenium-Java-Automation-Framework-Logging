package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethodPage extends HomePage {

    @FindBy(id = "paymentmethod_0")
    private WebElement checkMoneyOrderRadioButton;

    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    private WebElement continueButton;

    public void checkMoneyOrderRadioButtonClick() {
        checkMoneyOrderRadioButton.click();
    }

    public void continueButtonClick() {
        continueButton.click();
    }
}
