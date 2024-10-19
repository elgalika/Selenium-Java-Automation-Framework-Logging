package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends HomePage {

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement emailInput;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryDropdown;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityInput;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement addressInput;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipInput;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[@class='button-1 new-address-next-step-button' and @onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")
    private WebElement continueButton;

    public String getFirstNameValue() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastNameInput.getAttribute("value");
    }

    public String getEmailValue() {
        return emailInput.getAttribute("value");
    }

    public void fillBillingAddress(String country, String city, String address, String zip, String phone) {

        selectCountry(country);
        cityInput.sendKeys(city);
        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        phoneInput.sendKeys(phone);
        continueButton.click();

    }

    private void selectCountry(String countryName) {
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(countryName);
    }

}
