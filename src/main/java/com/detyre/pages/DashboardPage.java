package com.detyre.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.detyre.utils.DriverFactory;

public class DashboardPage extends HomePage {

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")
    public WebElement welcomeMessageWebElement;

    @FindBy(css = "body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")
    public WebElement logOutButtonWebElement;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > a")
    public WebElement hoverComputerButtonWebElement;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > ul > li:nth-child(2) > a")
    public WebElement notebooksWebElement;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")
    public WebElement notebookTextWebElement;

    public boolean isLogOutButtonDisplayed() {
        try {
            return logOutButtonWebElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void logOutButtonClick() {

        logOutButtonWebElement.click();
    }

    public void hoverComputerButton() {
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverComputerButtonWebElement).perform();
    }

    public void navigateToNotebooks() {
        notebooksWebElement.click();
    }

    public String getWelcomeMessage() {
        return welcomeMessageWebElement.getText();
    }

}
