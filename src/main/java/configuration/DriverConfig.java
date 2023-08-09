package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverConfig {
    private final static String swagLabs = "https://www.saucedemo.com/";
    private final static Integer WAITING_TIME = 40;

    public static WebDriver getChromeConfig() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.get(swagLabs);
        return driverChrome;

    }

    public static WebDriverWait getDriverWait(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
        return webDriverWait;
    }
}
