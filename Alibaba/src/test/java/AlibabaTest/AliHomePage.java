package AlibabaTest;

import AliTestCases.MainAli;
import org.testng.annotations.Test;

public class AliHomePage extends MainAli {
    @Test
    public void testSignIn(){
        searchSignIn();
    }
    @Test
    public void testNewArrivals(){
        searchNewArrivals();
    }
}
