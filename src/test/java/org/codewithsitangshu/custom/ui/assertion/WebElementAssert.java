package org.codewithsitangshu.custom.ui.assertion;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    private WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element){
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        isNotNull();
        if(!actual.isDisplayed()) {
            failWithMessage("Expected the element to be displayed. But it was not..!");
        }
        return this;
    }

    public WebElementAssert isEnabled(){
        isNotNull();
        //check condition
        if(!actual.isEnabled()){
            failWithMessage("Expected element to be enabled. But was not!!");
        }
        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value){
        isNotNull();
        //check condition
        if(!actual.getAttribute(attr).equals(value)){
            failWithMessage("Expected element to have attr <%s> value as <%s>. But was not!!", attr, value);
        }
        return this;
    }

    public WebElementAssert isClickable(WebDriverWait wait) {
        isNotNull();
        //check condition
        try {
            wait.withMessage("Check element to be clickable")
                    .until(ExpectedConditions.elementToBeClickable(actual));
        } catch (Exception e) {
            failWithMessage("Element is not clickable !!!");
        }
        return this;
    }

}
