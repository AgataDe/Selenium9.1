package configuration;

import configuration.model.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory extends Browser {
    private String browserName;
    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("DriverFactory.class");


    public WebDriver getDriver() {
        this.browserName = System.getProperty("browserName");
        switch (browserName) {
            case "chrome" -> {
                ChromeOptions optionsChrome = new ChromeOptions().addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
            }
            case "firefox" -> {
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
            }
            default -> {
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
            }
        }
        return this.driver;
    }
}
