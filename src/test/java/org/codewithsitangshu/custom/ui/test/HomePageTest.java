package org.codewithsitangshu.custom.ui.test;

import org.codewithsitangshu.custom.ui.pages.home.HomePageTour;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePageTour homePageTour;

    @BeforeTest
    public void pageSetup(){
        this.homePageTour = new HomePageTour(driver);
    }

    @Test
    public void launchSite(){
        this.homePageTour.goTo();
        assertThat(this.homePageTour).isAt();
    }

    @Test
    public void verifyCategorySection() {
        assertThat(this.homePageTour.getCategorySection())
                .isDisplayed()
                .isEnabled();
    }
}