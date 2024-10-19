package com.detyre.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletedPage extends HomePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]/strong")
    public WebElement completedTitleText;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div/div[2]/div[1]/strong")
    public WebElement orderNumberText;

    public String completedSuccessfulMessage() {
        return completedTitleText.getText();
    }

    public boolean orderNumberTextIsDisplayed() {
        try {
            return orderNumberText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
