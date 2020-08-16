package BannersHome;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SmallBussCases extends CommonAPI {
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement MugAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement BikingAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement tradingsAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement watchesAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement sneakersAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement outdoorAllBuss;
    @FindBy(how = How.CSS, using = ".hl-popular-destinations-elements li:nth-child(1) a")
    public static WebElement toolsAllBuss;
    @FindBy(xpath = "#itemTitle")
    public static WebElement title;
    @FindBy(how = How.CSS,using = "#s0-26-9-0-1\\[0\\]-0-1 > ul > li:nth-child(1) > div > div.s-item__image-section > div > a")
    public static WebElement firstElm;
    public WebElement getMugAllBuss() {
        return MugAllBuss;
    }
    public WebElement getFirstElm(){
        return firstElm;
    }
    public static WebElement getBikingAllBuss() {
        return BikingAllBuss;
    }
    public static WebElement getTradingsAllBuss() {
        return tradingsAllBuss;
    }
    public static WebElement getWatchesAllBuss() {
        return watchesAllBuss;
    }
    public static WebElement getSneakersAllBuss() {
        return sneakersAllBuss;
    }
    public static WebElement getOutdoorAllBuss() {
        return outdoorAllBuss;
    }
    public static WebElement getToolsAllBuss() {
        return toolsAllBuss;
    }
    public static WebElement getTitle() {
        return title;
    }
}
