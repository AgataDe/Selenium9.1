package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {
    @FindBy(css = ".sf-menu>li:nth-of-type(1)>a")
    private WebElement womenCategory;
    @FindBy(css = ".submenu-container>li:nth-of-type(1)>ul>li:nth-child(2)>a")
    private WebElement blouseSubcategory;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    public TopMenuPage moveMouseToWomenCategory() {
        mouseHover(womenCategory);
        return this;
    }

    public void clickOnBlouseTab() {
        clickOnButton(blouseSubcategory);
    }
}
