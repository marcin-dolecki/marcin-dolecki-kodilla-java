package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CrudAppTestSuite {
    private static final String BASE_URL = "https://marcin-dolecki.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() throws InterruptedException {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
        Thread.sleep(1000);
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_INPUT_TASK_NAME = "//form[@data-task-add-form]//input[@name='title']";
        final String XPATH_INPUT_TASK_CONTENT = "//form[@data-task-add-form]//textarea[@name='content']";
        final String XPATH_ADD_TASK_BUTTON = "//form[@data-task-add-form]//button[@type='submit']";
        String taskName = "Task number " + String.format("%05d", generator.nextInt(100000));
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_INPUT_TASK_NAME));
        name.sendKeys(taskName);
        Thread.sleep(1000);

        WebElement content = driver.findElement(By.xpath(XPATH_INPUT_TASK_CONTENT));
        content.sendKeys(taskContent);
        Thread.sleep(1000);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_TASK_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        final String XPATH_SELECT = "//select[1]";
        final String XPATH_FORMS = "//form[@class='datatable__row']";
        final String XPATH_FORM_VALUE = ".//p[@class='datatable__field-value']";
        final String XPATH_FORM_SELECT = ".//select[1]";
        final String XPATH_FORM_BUTTON = ".//button[@type='button' and contains(@class, 'card-creation')]";

        driver.navigate().refresh();

        while(!driver.findElement(By.xpath(XPATH_SELECT)).isDisplayed());

        driver.findElements(By.xpath(XPATH_FORMS)).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(XPATH_FORM_VALUE))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(XPATH_FORM_SELECT));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);
                    threadSleep(1000);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(XPATH_FORM_BUTTON));
                    buttonCreateCard.click();
                    threadSleep(2000);
                });
    }

    private boolean checkTaskExistsInTrello(String taskName) {
        final String TRELO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(TRELO_URL);
        threadSleep(4000);

        return result;
    }

    private void threadSleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldCreateTrelloCard() throws InterruptedException {
//        String taskName = createCrudAppTestTask();
//        sendTestTaskToTrello(taskName);
//        checkTaskExistsInTrello(taskName);
//        assertTrue(checkTaskExistsInTrello(taskName));

        _lauchTrello();
    }



    private void _lauchTrello() {
        final String TRELO_URL = "https://trello.com/login";
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(TRELO_URL);
    }

}
