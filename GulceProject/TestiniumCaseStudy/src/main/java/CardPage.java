import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardPage extends BasePage{

    By quantity2Locate = By.xpath("//*[@id='quantitySelect0-key-0']/option[2]");
    By cardRemove = By.id("removeCartItemBtn0-key-0");
    By cardEmpty = By.xpath("//*[@id='emtyCart']/div/strong");

    public CardPage(WebDriver driver) {
        super(driver);
    }

    /*public boolean checkProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocate);
    }
*/
    public void selectQuantity2() {
        click(quantity2Locate);
    }

    public void removeCard() {
        click(cardRemove);
    }

    public boolean controlCardEmpty() {
        return isDisplayed(cardEmpty);
    }

}
