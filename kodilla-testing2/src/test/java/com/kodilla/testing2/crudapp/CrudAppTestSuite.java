package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

class CrudAppTestSuite {
    private static final String BASE_URL = "https://marcin-dolecki.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
        final String XPATH_INPUT_TASK_NAME = "//form[@data-task-add-form]//input[@name='title']";
        final String XPATH_INPUT_TASK_CONTENT = "//form[@data-task-add-form]//textarea[@name='content']";
        final String XPATH_ADD_TASK_BUTTON = "//form[@data-task-add-form]//button[@type='submit']";
        String taskName = "Task number " + String.format("%05d", generator.nextInt(100000));
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_INPUT_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_INPUT_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_TASK_BUTTON));
        addButton.click();

        Thread.sleep(2000);
    }

}
