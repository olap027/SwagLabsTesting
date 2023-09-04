package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.Login.*;


public class LoginMethods {
    private static WebDriver driver;

    public LoginMethods(WebDriver driver) {
        this.driver = driver;
    }


    public static void inputRegisteredUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys(username);
    }

    public void inputUnregisteredUsername() {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys("unregistered");
    }

    public void validPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.sendKeys(password);
    }

    public void invalidPassword() {
        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.sendKeys("unregistered");
    }

    public void clickLogin() {
        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();
    }

    public void inputLockedOutUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys(username);
    }
}


