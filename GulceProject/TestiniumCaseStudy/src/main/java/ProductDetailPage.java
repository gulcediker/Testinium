import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage{

    By addToCardButtonLocate = By.id("addBasket");
    By productList = By.xpath("//*[@id='sizes']/div/span");
    By productSize = By.className("m-variation__item");
    By cardLocate = By.xpath("/html/body/header/div/div/div[3]/div/a[3]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
      //  System.out.println(getAllProducts().size());
        click(addToCardButtonLocate);
    }

    private List<WebElement> getAllProducts() {
        return findAll(productSize);
    }

    public void clickCard() {
        click(cardLocate);
    }


    //public void addToCard() {
     //  click(addToCardButtonLocate);
    //}
}



