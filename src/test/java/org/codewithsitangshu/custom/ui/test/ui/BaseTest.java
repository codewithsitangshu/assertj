package org.codewithsitangshu.custom.ui.test.ui;

import org.codewithsitangshu.custom.ui.assertion.PageAssert;
import org.codewithsitangshu.custom.ui.assertion.WebElementAssert;
import org.codewithsitangshu.custom.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup(){
        this.driver = new ChromeDriver();
    }

    protected WebElementAssert assertThat(WebElement element){
        return WebElementAssert.assertThat(element);
    }

    protected PageAssert assertThat(BasePage basePage){
        return PageAssert.assertThat(basePage);
    }

    @AfterTest
    public void quit(){
        this.driver.quit();
    }

}
