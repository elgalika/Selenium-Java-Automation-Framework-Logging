package com.detyre.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.detyre.enums.BrowserType;

public class DriverFactory {

    private static WebDriver driver = initDriver(BrowserType.CHROME);

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver initDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
                driver = new FirefoxDriver(options);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(optionsChrome);
                break;
        }

        DriverFactory.getDriver().manage().window().maximize();
        // DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
