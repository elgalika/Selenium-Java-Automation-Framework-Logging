package com.detyre.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.detyre.utils.DriverFactory;

public class ShoppingCartPage extends HomePage {

    @FindBy(className = "continue-shopping-button")
    private WebElement continueShoppingButton;

    @FindBy(id = "open-estimate-shipping-popup")
    private WebElement estimateShippingButton;

    @FindBy(css = "span.product-subtotal")
    private List<WebElement> productSubtotals;

    @FindBy(css = "span.value-summary strong")
    private WebElement totalElement;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    public String shopingCartPageTitleVerification() {
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title for verification we are in notebooks page: " + title);
        return title;
    }

    public boolean continueShoppingButtonIsDisplayed() {
        try {
            return continueShoppingButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean estimateShippingButtonIsDisplayed() {
        try {
            return estimateShippingButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<Double> getProductSubtotals() {
        List<Double> subtotals = new ArrayList<>();
        for (WebElement subtotal : productSubtotals) {
            String subtotalText = subtotal.getText().replace("$", "").replace(",", "");
            subtotals.add(Double.parseDouble(subtotalText));
        }
        return subtotals;
    }

    public double getTotalValue() {
        String totalText = totalElement.getText().replace("$", "").replace(",", "");
        return Double.parseDouble(totalText);
    }

    public void termsofserviceAgreementButonClick() {
        termsOfServiceCheckbox.click();
    }

    public void checkOutButtonClick() {
        checkOutButton.click();
    }

}
