package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AppUtil {

    public static final Integer POLLING_TIME = 1;


    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {
        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
        return element;
    }

}
