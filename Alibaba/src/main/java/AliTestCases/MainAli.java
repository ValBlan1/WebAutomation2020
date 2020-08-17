package AliTestCases;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainAli extends CommonAPI {
    @FindBy( xpath = "//div[@class= 'sc-hd-download-link']")
    public static WebElement getAppBotton;
    @FindBy( xpath = "//a[@data-spm='dNewArrivals'][1]")
    public static WebElement newArrivals;
    @FindBy(xpath = "//div[@class='text'][1]")
    public static WebElement allCategories;


    public void searchSignIn(){
        getAppBotton.click();
    }
    public void searchNewArrivals(){
        newArrivals.click();

    }
}
