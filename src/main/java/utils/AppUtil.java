package utils;

import enums.ElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AppUtil {

    public static final Integer POLLING_TIME = 1;

    public static By getBy(String path, ElementType type) {
        switch (type){
            case ID:
                return By.id(path);
            case NAME:
                return By.name(path);
            case X_PATH:
                return By.xpath(path);
            case TAG_NAME:
                return By.tagName(path);
            case CSS_SELECTOR:
                return By.cssSelector(path);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {
        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
        return element;
    }

}
