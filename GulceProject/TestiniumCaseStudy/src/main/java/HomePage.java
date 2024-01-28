import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    By rejectCookieLocate = By.id("onetrust-reject-all-handler");
    By selectGender = By.id("genderWomanButton");
    SearchBox searchBox ;
    By cartCountLocate = By.id("o-header__userInfo--count");
    By cartCountaineLocate = By.id("o-header__userInfo--text");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public void selectGender(){
        if (isDisplayed(selectGender))
            click(selectGender);
    }

    public void rejectCookies(){
        if (isDisplayed(rejectCookieLocate))
            click(rejectCookieLocate);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    public void goToCard() {
        click(cartCountaineLocate);
    }

    private int getCartCount(){
       String count = find(cartCountLocate).getText();
       return Integer.parseInt(count);
    }


    }



