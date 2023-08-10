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

    private static WebDriver driver;
    public static WebDriverWait webDriverWait = null;
    public static WebDriver chromeConfig = null;
    public SwagLabLogin (WebDriver driver){
        this.driver = driver;
    }

    public void credentials() {

        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys("secret_sauce");

        WebElement loginBtn =  driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();

    }

}
