package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_ALLOW_COOKIES = "//div[@role='button' and @aria-label='Allow all cookies' and (not(@aria-disabled) or @aria-disabled='false' )]";
    public static final String XPATH_CREATE_ACCOUNT = "//a[@role='button' and @data-testid='open-registration-form-button']";
    public static final String XPATH_SELECT_MONTH = "//div[@id='birthday_wrapper']//select[@aria-label='Month']";
    public static final String XPATH_SELECT_DAY = "//div[@id='birthday_wrapper']//select[@aria-label='Day']";
    public static final String XPATH_SELECT_YEAR = "//div[@id='birthday_wrapper']//select[@aria-label='Year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        // allow cookies
        driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).click();

        // create account
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        // allow cookies again
        driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).click();

        // select month
        WebElement selectMonthField = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(selectMonthField);
        selectMonth.selectByValue("6");

        // select day
        WebElement selectDayField = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDay = new Select(selectDayField);
        selectDay.selectByValue("20");

        // select year
        WebElement selectYearField = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(selectYearField);
        selectYear.selectByValue("1991");
    }
}
