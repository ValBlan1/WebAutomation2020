package AmazonMain;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AmazonTestCases extends CommonAPI {
    String user ="joshuablan2020@gmail.com";
    String password="Isaac2020!";

    @FindBy(id = "twotabsearchtextbox") public static WebElement searchBox;
    @FindBy(className = "nav-input") public static WebElement search;
    @FindBy(xpath = "//a[@href='/gp/navigation/redirector.html/ref=sign-in-redirect?ie=UTF8&associationHandle=usflex&currentPageURL=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&pageType=Gateway&switchAccount=&yshURL=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_custrec_signin']") public static WebElement signInButton;
    @FindBy(id = "ap_email") public static WebElement inputUser;
    @FindBy(id = "ap_password") public static WebElement inputPass;
    @FindBy(xpath = "//a[@href='/gp/goldbox?ref_=nav_cs_gb']") public static WebElement todaysDeals;
    @FindBy(xpath = "//a[@href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gift_cards']") public static WebElement giftCards;
    @FindBy(xpath = "//a[@href='https://www.amazon.com/gp/css/homepage.html?ref_=nav_youraccount_btn']") public static WebElement yourAccount;
    @FindBy(xpath = "//a[@href='/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_help']") public static WebElement getHelp;
    @FindBy(xpath = "//a[@href='/gp/browse.html?node=17235386011&ref_=nav_cs_whole_foods']") public static WebElement shopInWholeFoods;
    @FindBy(xpath = "//a[@href='/b/?_encoding=UTF8&ld=AZUSSOA-sell&node=12766669011&ref_=nav_cs_sell']")public static WebElement sellOnAmazon;
    @FindBy(xpath = "//h2[@class='a-spacing-none truncate-1line']") public static WebElement cart;
    @FindBy(id = "searchDropdownBox") public static WebElement categoriesDropDown;
    @FindBy(xpath = "//a[@href='/Vehicles/b/?ie=UTF8&node=10677469011&ref_=topnav_storetab_vehicles']") public static WebElement header;
    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']") public static WebElement addingItemToCart;
    @FindBy(xpath = "//span[@class='a-button a-spacing-small a-button-primary a-button-icon']") public static WebElement addToCartButton;
    @FindBy(xpath = "//span[@id='glow-ingress-line2']") public static WebElement enterYourZipCode;
    @FindBy(id = "GLUXZipUpdateInput") public static WebElement inputZipCode;
    @FindBy(xpath = "//a[contains(text(),'Deal of the Day')]") public static WebElement dealOfTheDay;
    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']") public static WebElement shopByCategory;
    @FindBy(xpath = "//a[@data-menu-id='21']") public static WebElement sportsNOutdoorButton;
    @FindBy(xpath = "//a[@href='/gp/browse.html?node=3410851&ref_=nav_em_T1_0_4_22_6__sa_sp_golf']") public static WebElement getSportsNOutdoorButtonList;
    @FindBy(xpath = "//a[contains(text(),'Golf Bags')]") public static WebElement golfBags;
    @FindBy(xpath = "//b[contains(text(),'Golf Bags')]") public static WebElement golfBagsHeader;
    @FindBy(xpath = "//a[@class='a-link-normal']") public static WebElement bestSellers;
    @FindBy(xpath = "//span[@class='aok-inline-block zg-item']") public static List<WebElement> bagsList;

    public void searchItem() {
        searchBox.sendKeys("Laptop");
        search.click();
    }
    public void testLoginWithValidUserNPass() {
        signInButton.click();
        inputUser.sendKeys(user, Keys.ENTER);
        inputPass.sendKeys(password, Keys.ENTER);

    }
    public void clickOnTodaysDeals() {
        todaysDeals.click();
        String text = todaysDeals.getText();
        Assert.assertEquals(text, "Today's Deals");
    }
    public void clickOnGiftCards() {
        giftCards.click();
        String text = giftCards.getText();
        Assert.assertEquals(text,"Gift Cards");
    }
    public void clickOnGetHelp() {
        getHelp.click();
        String text = getHelp.getText();
        Assert.assertEquals(text, "Help");
    }
    public void shopInWholeFoods() {
        shopInWholeFoods.click();
        String text = shopInWholeFoods.getText();
        Assert.assertEquals(text, "Whole Foods");
    }
    public void sellOnAmazon() {
        sellOnAmazon.click();
        String text = sellOnAmazon.getText();
        Assert.assertEquals(text, "Sell");
    }
    public void amazonCart() {
        cart.click();
        Assert.assertTrue(cart.getText().contains("Cart"));
    }
    public void categoriesDropDown() {
        Select select = new Select(categoriesDropDown);
        select.selectByVisibleText("Vehicles");
        search.click();
        String text = header.getText();
        Assert.assertEquals(text, "Vehicles");
    }
    public void selectVehicleBrand() {
        categoriesDropDown();
        searchBox.sendKeys("Chevrolet", Keys.ENTER);
    }
    public void addingItemToCart() {
        searchItem();
        addingItemToCart.click();
        addToCartButton.click();
        String text = addToCartButton.getText();
        Assert.assertEquals(text, "Add to Cart");
    }
    public void enterYourZipCode() {
        enterYourZipCode.click();
        inputZipCode.sendKeys("33186", Keys.ENTER);
        String text = enterYourZipCode.getText();
        Assert.assertEquals(text, "Select your address");
    }
    public void dealOfTheDay() {
        clickOnTodaysDeals();
        dealOfTheDay.click();
    }
    public void shopGolfBagBestSeller() {
        shopByCategory.click();
        sportsNOutdoorButton.click();
        getSportsNOutdoorButtonList.click();
        golfBags.click();
        String text = golfBagsHeader.getText();
        Assert.assertEquals(text, "Golf Bags");
        bestSellers.click();
        bagsList.get(0).click();
        addToCartButton.click();
    }
}
