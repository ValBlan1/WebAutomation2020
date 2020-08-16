package EbayTestHome;

import homePage.MainHome;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AllCatTest extends MainHome {

    @Test
    public void TestArt(){
        selectFromMenu("Art");
    }
    @Test
    public void TestAntiques(){
        selectFromMenu("Antiques");
    }
    @Test
    public void TestBaby(){
        selectFromMenu("Baby");
    }
    @Test
    public void TestBooks(){
        selectFromMenu("Books");
    }
    @Test
    public void TestBusInd(){
        selectFromMenu("Business & Industrial");
    }
    @Test
    public void TestCamPhoto(){
        selectFromMenu("Cameras & Photo");
    }
    @Test
    public void TestPhone(){
        selectFromMenu("Cell Phones & Accessories");
    }
    @Test
    public void TestCoins(){
        selectFromMenu("Coins & Paper Money");
    }
    @Test
    public void TestCollectibles(){
        selectFromMenu("Collectibles");

    }   @Test
    public void TestComputers(){
        selectFromMenu("Computers/Tablets & Networking");
    }
    @Test
    public void TestConsumer(){
        selectFromMenu("Consumer Electronics");
    }
    @Test
    public void TestCrafts(){
        selectFromMenu("Crafts");
    }
    @Test
    public void TestTravel(){
        selectFromMenu("Travel");
    }
    @Test
    public void TestEntert(){
        selectFromMenu("Entertainment Memorabilia");
    }
    @Test
    public void TestHealt(){
        selectFromMenu("Health & Beauty");
    }
    @Test
    public void TestHome(){
        selectFromMenu("Home & Garden");
    }
    @Test
    public void TestMusic(){
        selectFromMenu("Music");
    }
    @Test
    public void TestStamps(){
        selectFromMenu("Stamps");
    }





}
