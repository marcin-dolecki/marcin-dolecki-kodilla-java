package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrudAppTestSuite {
    private static final String BASE_URL = "https://marcin-dolecki.github.io/";
    private WebDriver driver;
    private Random generator;
    private WebDriverWait wait;

    @BeforeEach
    public void initTests() throws InterruptedException {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

        WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_INPUT_TASK_NAME))
        );
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_INPUT_TASK_CONTENT));
        content.sendKeys(taskContent);
        Thread.sleep(1000);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_TASK_BUTTON));
        addButton.click();
        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(1000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) {
        final String XPATH_SELECT = "//select[1]";
        final String XPATH_FORMS = "//form[@class='datatable__row']";
        final String XPATH_FORM_VALUE = ".//p[@class='datatable__field-value']";
        final String XPATH_FORM_SELECT = ".//select[1]";
        final String XPATH_FORM_BUTTON = ".//button[@type='button' and contains(@class, 'card-creation')]";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_SELECT)));

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

                    try {
                        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                        System.out.println("Alert text: " + alert.getText());
                        threadSleep(1000);
                        alert.accept();
                    } catch (TimeoutException e) {
                        System.out.println("Alert is not there for 15 seconds");
                    }

                    threadSleep(1000);
                });
    }

    private boolean checkTaskExistsInTrello(String taskName) {
        final String TRELLO_URL = "https://trello.com/login";
        final String XPATH_EMAIL_INPUT = "//form[@data-testid='form-login']//input[@data-testid='username']";
        final String XPATH_PASSWORD_INPUT = "//form[@data-testid='form-login']//input[@data-testid='password']";
        final String XPATH_LOGIN_BUTTON = "//form[@data-testid='form-login']//button[@data-testid='login-submit-idf-testid']";
        final String XPATH_KODILLA_BOARD_LINK = "//a[@aria-label='Kodilla Application']";
        final String XPATH_KODILLA_CARD_NAME = "//a[@data-testid='card-name']";
        Dotenv dotenv = Dotenv.load();
        final String email = dotenv.get("TRELLO_EMAIL");
        final String password = dotenv.get("TRELLO_PASSWORD");
        boolean result = false;

        driver.get(TRELLO_URL);

        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_EMAIL_INPUT))
        );
        emailInput.sendKeys(email);
        threadSleep(1000);

        WebElement button = driver.findElement(By.xpath(XPATH_LOGIN_BUTTON));
        button.click();

        WebElement passwordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_PASSWORD_INPUT))
        );
        passwordInput.sendKeys(password);
        threadSleep(1000);

        button.click();
        threadSleep(1000);

        WebElement kodillaBoardLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(XPATH_KODILLA_BOARD_LINK))
        );
        kodillaBoardLink.click();
        threadSleep(1000);

        result = driver.findElements(By.xpath(XPATH_KODILLA_CARD_NAME)).stream()
                .anyMatch(card -> card.getText().equals(taskName));

        return result;
    }

    private void removeTestTaskFromCrudApp(String taskName) {
        final String XPATH_FORM = "//form[@class='datatable__row'][1]";
        final String XPATH_FORMS = "//form[@class='datatable__row']";
        final String XPATH_FORM_VALUE = ".//p[@class='datatable__field-value']";
        final String XPATH_DELETE_BUTTON = ".//button[@type='button' and @data-task-delete-button]";

        driver.get(BASE_URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_FORM)));

        driver.findElements(By.xpath(XPATH_FORMS)).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(XPATH_FORM_VALUE))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDeleteCard = theForm.findElement(By.xpath(XPATH_DELETE_BUTTON));
                    threadSleep(1000);
                    buttonDeleteCard.click();
                    threadSleep(1000);
                });
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
        String taskName = createCrudAppTestTask();
        System.out.println(taskName);
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        removeTestTaskFromCrudApp(taskName);
    }
}
