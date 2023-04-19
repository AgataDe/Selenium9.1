package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopupPage extends BasePage {
    @FindBy(css = "a.fancybox")
    private List<WebElement> productMiniatures;
    @FindBy(css = "#bigpic")
    private WebElement bigPicture;
    @FindBy(css = ".fancybox-iframe")
    private WebElement iframe;


    public PopupPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getProductMiniatures() {
        return productMiniatures;
    }

    public int getProductMiniaturesSize() {
        return productMiniatures.size();
    }

    public WebElement getBigPicture() {
        return bigPicture;
    }

    public void switchToIframe() {
        waitToBeVisible(iframe);
        driver.switchTo().frame(iframe);
        logger.info("Switched to iframe");
    }

    public void moveMouseToProductMiniature(int index) {
        mouseHover(productMiniatures.get(index));
    }
}
