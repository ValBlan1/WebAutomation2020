package amazonTest;

import AmazonMain.AmazonTestCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest extends AmazonTestCases {
    AmazonTestCases amazonTestCases;

    @BeforeMethod
    public void initElements() {
        amazonTestCases = PageFactory.initElements(driver,AmazonTestCases.class);
    }

    @Test
    public void testSearch() {
        searchItem();
    }
    @Test
    public void loginWithValidUserName(){
        testLoginWithValidUserNPass();
    }
    @Test
    public void testTodaysDeals() {
        clickOnTodaysDeals();
    }
    @Test
    public void testGiftCards() {
        clickOnGiftCards();
    }
    @Test
    public void testGetHelp() {
        clickOnGetHelp();
    }
    @Test
    public void testWholeFoods() {
        shopInWholeFoods();
    }
    @Test
    public void testSell() {
        sellOnAmazon();
    }
    @Test
    public void testAmazonCart() {
        amazonCart();
    }
    @Test
    public void testCategories() {
        categoriesDropDown();
    }
    @Test
    public void testVehicleBrand() {
        selectVehicleBrand();
    }
    @Test
    public void testAddingItemToCart() {
        addingItemToCart();
    }
    @Test
    public void testZipCode() {
        enterYourZipCode();
    }
    @Test
    public void testDealOfTheDay() {
        dealOfTheDay();
    }
    @Test
    public void testShopByCategories() {
        shopGolfBagBestSeller();
    }

}
