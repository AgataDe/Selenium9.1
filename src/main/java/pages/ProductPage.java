package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = ".product_img_link")
    private WebElement productPicture;
    @FindBy(css = ".quick-view")
    private WebElement quickViewButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public ProductPage moveMouseToProduct() {
        mouseHover(productPicture);
        return this;
    }

    public void clickOnAQuickViewButton() {
        mouseClick(quickViewButton);
    }
}
