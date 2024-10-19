package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmOrderPage extends HomePage {

    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong")
    private WebElement totalElement;

    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
    private WebElement continueButton;

    public double getTotalValueConfirmation() {
        String totalText = totalElement.getText().replace("$", "").replace(",", "");
        return Double.parseDouble(totalText);
    }

    public void continueButtonClick() {
        continueButton.click();
    }
}
