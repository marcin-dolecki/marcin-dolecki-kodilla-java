package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrudAppTestingApp {
    public static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://marcin-dolecki.github.io/");

        WebElement inputTaskNameField = driver.findElement(By.xpath(XPATH_INPUT));
        inputTaskNameField.sendKeys("New robotic task");

        WebElement textAreaTaskContentField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textAreaTaskContentField.sendKeys("The robotic content");
    }
}
