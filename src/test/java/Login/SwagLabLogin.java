package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.Login.*;



public class SwagLabLogin {

    private static WebDriver driver;
    private static WebDriverWait webDriverWait = null;
    private static WebDriver chromeConfig = null;
    public SwagLabLogin (WebDriver driver){
        this.driver = driver;
    }

    public void credentials() {
//        chromeConfig = getChromeConfig();
//        webDriverWait = getDriverWait(chromeConfig);
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys("secret_sauce");

        WebElement loginBtn =  driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();


    }


//    public static void productsPage(){
//        WebElement passwordField = getElementWithPolling(webDriverWait, By.xpath(PASSWORD_FIELD));
//        passwordField.click();
//    }

}
