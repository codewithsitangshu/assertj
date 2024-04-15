package org.codewithsitangshu.custom.ui.pages.home;

import lombok.Getter;
import org.codewithsitangshu.custom.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageTourWithSoftAssert extends BasePage {

    @Getter
    @FindBy(xpath = "//*[contains(@class,'shop-menu')]//a[normalize-space()='Home']")
    private WebElement homeButton;

    @Getter
    @FindBy(xpath = "//*[@class='left-sidebar']//h2[text()='Category']")
    private WebElement categorySection;

    public HomePageTourWithSoftAssert(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.driver.getTitle().equals("Automation Exercise");
    }

    public void goTo(){
        this.driver.get("https://automationexercise.com/");
        assertSoftly(s -> {
            s.assertThat(homeButton)
                    .isDisplayed()
                    .isEnabled()
                    .isClickable(wait);
        });
    }

}
