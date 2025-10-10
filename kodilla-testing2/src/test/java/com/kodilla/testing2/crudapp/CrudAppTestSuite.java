package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        final String TRELLO_URL = "https://trello.com/login";
        final String XPATH_EMAIL_INPUT = "//form[@data-testid='form-login']//input[@data-testid='username']";
        final String XPATH_PASSWORD_INPUT = "//form[@data-testid='form-login']//input[@data-testid='password']";
        final String XPATH_LOGIN_BUTTON = "//form[@data-testid='form-login']//button[@data-testid='login-submit-idf-testid']";
        final String XPATH_KODILLA_BOARD_LINK = "//a[@aria-label='Kodilla Application']";
        Dotenv dotenv = Dotenv.load();
        final String email = dotenv.get("TRELLO_EMAIL");
        final String password = dotenv.get("TRELLO_PASSWORD");

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(TRELLO_URL);
        threadSleep(4000);

        WebElement emailInput = driver.findElement(By.xpath(XPATH_EMAIL_INPUT));
        emailInput.sendKeys(email);
        threadSleep(1000);

        WebElement button = driver.findElement(By.xpath(XPATH_LOGIN_BUTTON));
        button.click();
        threadSleep(1000);

        WebElement passwordInput = driver.findElement(By.xpath(XPATH_PASSWORD_INPUT));
        passwordInput.sendKeys(password);
        threadSleep(1000);

        button.click();
        threadSleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement kodillaBoardLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(XPATH_KODILLA_BOARD_LINK))
        );
        kodillaBoardLink.click();
        threadSleep(4000);

    }

}
