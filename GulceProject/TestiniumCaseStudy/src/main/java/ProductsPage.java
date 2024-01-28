import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By productListTitle = By.id("productListTitle");
    By productNameLocate =  By.id("productListContent");
    By secondProduct = By.xpath("//*[@id='productList']/div[3]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
   /* public boolean isOnProductsPage() {
        return isDisplayed(productListTitle);
    }
*/
    /*public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }*/

    /*private List<WebElement> getAllProducts(){
        return findAll(productNameLocate);
    }*/
    public void selectSecondProduct() {
        click(secondProduct);
    }

}
