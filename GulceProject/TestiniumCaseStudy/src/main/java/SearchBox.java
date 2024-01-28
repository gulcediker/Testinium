import dev.failsafe.internal.util.Assert;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.xpath("/html/body/header/div/div/div[2]/div/div/input");
    By searchBoxTextField = By.id("o-searchSuggestion__input");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void clickSearchBox() {
        click(searchBoxLocator);
    }

    public void typeInSearch(String text) {
        type(searchBoxTextField, text);
    }

    public void searchWithEnter() {
          sendEnter(searchBoxTextField);
    }

    public void clearSearch() {
        clear(searchBoxTextField);
    }
}
