package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookTestingApp {
    public static final String XPATH_ALLOW_COOKIES = "//div[@role='button' and @aria-label='Allow all cookies' and (not(@aria-disabled) or @aria-disabled='false' )]";
    public static final String XPATH_CREATE_ACCOUNT = "//a[@role='button' and @data-testid='open-registration-form-button']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        // allow cookies
        driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).click();

        // create account
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        // allow cookies again
        driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).click();
    }
}
