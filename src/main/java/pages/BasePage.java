package pages;

import configuration.WebListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private EventFiringMouse eventFiringMouse;
    private final WebListener webListener = new WebListener();
    protected static Logger logger = LoggerFactory.getLogger("BasePage.class");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("webElementTimeout"))));
        PageFactory.initElements(driver, this);
    }


    public void clickOnButton(WebElement element) {
        waitToBeClickable(element);
        element.click();
        logger.info("Element " + element.getText() + " has been clicked");
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.info("Waiting for " + element.getText());
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void mouseHover(WebElement element) {
        waitToBeVisible(element);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        logger.info("Element has been moved");
    }

    public void mouseClick(WebElement element) {
        waitToBeClickable(element);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.click(coordinates);
        logger.info("Element has been clicked");
    }
}
