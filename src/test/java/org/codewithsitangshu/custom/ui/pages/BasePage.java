package org.codewithsitangshu.custom.ui.pages;

import org.codewithsitangshu.custom.ui.assertion.WebElementSoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Consumer;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    protected void assertSoftly(Consumer<WebElementSoftAssert> assertConsumer){
        WebElementSoftAssert softAssert = new WebElementSoftAssert();
        assertConsumer.accept(softAssert);
        softAssert.assertAll();
    }

    public abstract boolean isAt();
}