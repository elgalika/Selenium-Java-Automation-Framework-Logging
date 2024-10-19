package com.detyre.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.detyre.utils.DriverFactory;

public class NotebooksPage extends HomePage {
    // public NotebooksPage() {
    // PageFactory.initElements(DriverFactory.getDriver(), this);
    // }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[3]")
    public WebElement secondIWebElement;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[3]")
    public WebElement thirdIWebElement;

    // @FindBy(css = "#main > div > div.center-2 > div > div.page-body >
    // div.products-container > div.products-wrapper > div > div > div:nth-child(4)
    // > div > div.details > div.add-info > div.buttons >
    // button.button-2.product-box-add-to-cart-button")
    // private WebElement fourthItemAddToCartButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement fourthItemAddToCartButton;

    // @FindBy(css = "#main > div > div.center-2 > div > div.page-body >
    // div.products-container > div.products-wrapper > div > div > div:nth-child(5)
    // > div > div.details > div.add-info > div.buttons >
    // button.button-2.product-box-add-to-cart-button")
    // public WebElement fifthItemAddToCartButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[5]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement fifthItemAddToCartButton;

    // @FindBy(css = "#main > div > div.center-2 > div > div.page-body >
    // div.products-container > div.products-wrapper > div > div > div:nth-child(6)
    // > div > div.details > div.add-info > div.buttons >
    // button.button-2.product-box-add-to-cart-button")
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[6]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement sixthItemAddToCartButton;

    @FindBy(css = "#bar-notification > div > p")
    public WebElement notificationMessageAddedItem;

    @FindBy(css = "#bar-notification > div > span")
    public WebElement closeNotificationButton;

    @FindBy(css = "body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(3) > a > span.wishlist-qty")
    public WebElement wishlistCountElement;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[2]")
    public WebElement cartCountElement;

    @FindBy(css = "#topcartlink > a > span.cart-label")
    public WebElement cartLabelElementHover;

    @FindBy(css = "#flyout-cart > div > div.buttons > button")
    public WebElement goToCartElementButton;

    @FindBy(css = "body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")
    public WebElement logOutButtonWebElement;
    
    public void notebookPageTitleVerification() {
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("Page Title for verification we are in notebooks page: " + title);

    }

    public void addSecondItemToWishlist() {
        secondIWebElement.click();
    }

    public void addThirdItemToWishlist() {
        thirdIWebElement.click();
    }

    public void addFourthItemToCart() {
        waitFor(5);

        fourthItemAddToCartButton.click();
    }

    public void addFifthItemToCart() {
        fifthItemAddToCartButton.click();
        waitFor(3);

    }

    public void addSixthItemToCart() {
        sixthItemAddToCartButton.click();
        waitFor(3);
        closeNotificationButton.click();
    }

    public int getWishlistCount() {
        String countText = wishlistCountElement.getText();
        int count = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
        return count;
    }

    public int getCartCount() {
        String countText = cartCountElement.getText();
        int count = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
        return count;
    }

    public String getNotificationMessage() {
        String notificationMessage = notificationMessageAddedItem.getText();
        System.out.println("Notification Message: " + notificationMessage);
        if (notificationMessage.contains("shopping cart")) {
            return "The product has been added to your shopping cart";
        } else if (notificationMessage.contains("wishlist")) {
            return "The product has been added to your wishlist";
        } else {
            return "unknown notification message";
        }
    }

    public void closeNotification() {
        closeNotificationButton.click();
    }

    public void hoverShoppingCartButton() {
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(cartLabelElementHover).perform();
        waitFor(3);
    }

    public boolean goToCartElementButtonIsDisplayed() {
        hoverShoppingCartButton();
        try {
            return goToCartElementButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToCartClick() {
        goToCartElementButton.click();
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
