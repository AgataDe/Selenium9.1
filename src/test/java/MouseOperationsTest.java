import base.Pages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MouseOperationsTest extends Pages {

    @Test
    @DisplayName("Testing mouse operations")
    @Tag("Mouse")
    public void shouldMouseOperationWorkCorrectly() {
        topMenuPage.moveMouseToWomenCategory()
                .clickOnBlouseTab();
        productPage.moveMouseToProduct()
                .clickOnAQuickViewButton();
        popupPage.switchToIframe();

        for (int i = 0; i < popupPage.getProductMiniaturesSize(); i++) {
            popupPage.moveMouseToProductMiniature(i);
            String miniature = popupPage.getProductMiniatures().get(i).getAttribute("href")
                    .replace("-thickbox_default.jpg", "");
            String bigPicture = popupPage.getBigPicture().getAttribute("src")
                    .replace("-large_default.jpg", "");
            Assertions.assertThat(miniature).isEqualTo(bigPicture);
        }
    }

}
