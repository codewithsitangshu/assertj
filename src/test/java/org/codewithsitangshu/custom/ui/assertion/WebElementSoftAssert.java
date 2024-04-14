package org.codewithsitangshu.custom.ui.assertion;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class WebElementSoftAssert extends SoftAssertions {

    public WebElementAssert assertThat(WebElement actual){
        return proxy(WebElementAssert.class, WebElement.class, actual);
    }

}
