package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutShippingMethodPage extends HomePage {
    @FindBy(id = "shippingoption_1")
    private WebElement nextDayAirRadioButton;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    private WebElement continueButton;

    public void nextDayAirRadioButtonClick() {
        nextDayAirRadioButton.click();
    }

    public void continueButtonClick() {
        continueButton.click();
    }

}
