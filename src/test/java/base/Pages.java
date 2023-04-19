package base;

import org.junit.jupiter.api.BeforeEach;
import pages.PopupPage;
import pages.ProductPage;
import pages.TopMenuPage;

public class Pages extends BaseTest {
    public TopMenuPage topMenuPage;
    public ProductPage productPage;
    public PopupPage popupPage;

    @BeforeEach
    public void initPages() {
        topMenuPage = new TopMenuPage(BaseTest.driver);
        productPage = new ProductPage(BaseTest.driver);
        popupPage = new PopupPage(BaseTest.driver);
    }
}
