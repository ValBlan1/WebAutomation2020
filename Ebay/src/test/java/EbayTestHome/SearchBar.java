package EbayTestHome;

import homePage.MainHome;
import org.testng.annotations.Test;

public class SearchBar extends MainHome {


    @Test
    public void testDayBed(){
        searchDayBed();
    }
    @Test
    public void testEmbroidered(){
        searchEmbroidered();
    }
    @Test
    public void testCandles(){
        searchCandles();
    }
    @Test
    public void testOptions(){
        searchOptions();
    }

}
