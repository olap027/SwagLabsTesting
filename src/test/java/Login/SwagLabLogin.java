package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static configuration.DriverConfig.getChromeConfig;
import static configuration.DriverConfig.getDriverWait;
import static constant.Login.*;
import static utils.AppUtil.getElementWithPolling;

public class SwagLabLogin {

    private static WebDriver chromeConfig = null;
    private static WebDriverWait webDriverWait = null;


    public static void gotoSwag() {
        chromeConfig = getChromeConfig();
        webDriverWait = getDriverWait(chromeConfig);

    }

    public  static void credentials (){
        WebElement usernameField = getElementWithPolling(webDriverWait, By.xpath(USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = getElementWithPolling(webDriverWait, By.xpath(PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys("secret_sauce");

        WebElement loginBtn = getElementWithPolling(webDriverWait, By.xpath(LOGIN_BTN));
        loginBtn.click();
    }

    public static void productsPage(){
        WebElement passwordField = getElementWithPolling(webDriverWait, By.xpath(PASSWORD_FIELD));
        passwordField.click();
    }

}
