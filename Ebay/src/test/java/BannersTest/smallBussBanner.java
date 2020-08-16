package BannersTest;

import org.testng.annotations.Test;
import BannersHome.SmallBussCases;

public class smallBussBanner extends SmallBussCases {

    @Test
    public void mugsIcon(){
        getMugAllBuss();
    }
    @Test
    public void FirstIconMugsSec() {
        getMugAllBuss();
        getFirstElm();
    }
    @Test
    public void BikingIcon() {
        getBikingAllBuss();
    }@Test
    public void tradingIcon() {
        getTradingsAllBuss();
    }@Test
    public void watchesIcon() {
        getWatchesAllBuss();
    }@Test
    public void sneakersIcon() {
        getSneakersAllBuss();
    }@Test
    public void outdoorIcon() {
        getOutdoorAllBuss();
    }@Test
    public void toolsIcon() {
        getToolsAllBuss();
    }
}
