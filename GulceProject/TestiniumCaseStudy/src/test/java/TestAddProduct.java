import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestAddProduct extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CardPage cardPage;

    ExcelRead excelRead;


    @Test
     public void search_a_product() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cardPage = new CardPage(driver);
        homePage.rejectCookies();
        Thread.sleep(500);
        homePage.selectGender();
        Thread.sleep(500);
        homePage.searchBox().clickSearchBox();
        //Search Şort
        homePage.searchBox().typeInSearch("Şort");
        //Clear search
        Thread.sleep(500);
        homePage.searchBox().clearSearch();
        //Search Gömlek
        homePage.searchBox().typeInSearch("Gömlek");
        homePage.searchBox().searchWithEnter();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL,"https://www.beymen.com/search?q=G%C3%B6mlek");
        //Select a product
        productsPage.selectSecondProduct();
        //Write name and price to txt
        //Select a size
        productDetailPage.selectProduct(4);
        Thread.sleep(500);
        //Add
        productDetailPage.clickCard();
        //Check price
        //Increase count
        cardPage.selectQuantity2();
        Thread.sleep(500);
        //Delete
        cardPage.removeCard();
        Thread.sleep(500);
        //Control,
        Assertions.assertTrue(cardPage.controlCardEmpty());

    }
}
