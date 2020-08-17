package EbayTestHome;

import homePage.MainHome;
import org.testng.annotations.Test;

public class ShoppingCart extends MainHome {
    @Test
    public void testStartShopping(){
        startShopping();
    }
    @Test
    public void testShoppingSec(){
        startShoppingSec();
    }
}
