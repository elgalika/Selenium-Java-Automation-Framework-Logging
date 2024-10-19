package com.detyre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.detyre.utils.DriverFactory;

public class RegisterPage extends HomePage {

    @FindBy(id = "gender-female")
    public WebElement genderFemaleButtonWebElement;

    @FindBy(id = "FirstName")
    public WebElement inputFirstNameWebElement;

    @FindBy(id = "LastName")
    public WebElement inputLastNameWebElement;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDaySelectWebElement;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement dateOfBirthMonthSelectWebElement;

    @FindBy(name = "DateOfBirthYear")
    public WebElement dateOfBirthYearSelectWebElement;

    @FindBy(id = "Email")
    public WebElement emailInputWebElement;

    @FindBy(id = "Company")
    public WebElement companyInputWebElement;

    @FindBy(id = "Newsletter")
    public WebElement newsletterCheckboxWebElement;

    @FindBy(id = "Password")
    public WebElement passwordInputWebElement;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordInputWebElement;

    @FindBy(id = "register-button")
    public WebElement registerButtonWebElement;

    @FindBy(className = "result")
    private WebElement registrationResultElement;

    public void clickGenderFemale() {
        genderFemaleButtonWebElement.click();
    }

    public void registrationForm(String firstName, String lastName, String day, String month, String year, String email,
            String company, boolean subscribeToNewsletter, String password, String confirmPassword) {
        clickGenderFemale();
        inputFirstNameWebElement.sendKeys(firstName);
        inputLastNameWebElement.sendKeys(lastName);

        Select daySelect = new Select(dateOfBirthDaySelectWebElement);
        Select monthSelect = new Select(dateOfBirthMonthSelectWebElement);
        Select yearSelect = new Select(dateOfBirthYearSelectWebElement);

        daySelect.selectByVisibleText(day);
        monthSelect.selectByVisibleText(month);
        yearSelect.selectByVisibleText(year);

        emailInputWebElement.sendKeys(email);
        companyInputWebElement.sendKeys(company);

        if (subscribeToNewsletter && !newsletterCheckboxWebElement.isSelected()) {
            newsletterCheckboxWebElement.click();
        }

        passwordInputWebElement.sendKeys(password);

        confirmPasswordInputWebElement.sendKeys(confirmPassword);
    }

    public void submitRegistrationForm() {
        registerButtonWebElement.click();
    }

    public void printRegisterPageTitle() {
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title after clicking register button: " + title);
    }

}
