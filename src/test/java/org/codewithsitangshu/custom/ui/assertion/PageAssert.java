package org.codewithsitangshu.custom.ui.assertion;

import org.assertj.core.api.AbstractAssert;
import org.codewithsitangshu.custom.ui.pages.BasePage;

public class PageAssert extends AbstractAssert<PageAssert, BasePage> {

    private PageAssert(BasePage basePage) {
        super(basePage, PageAssert.class);
    }

    public static PageAssert assertThat(BasePage page){
        return new PageAssert(page);
    }

    public PageAssert isAt(){
        isNotNull();
        if(!actual.isAt()){
            failWithMessage("Page is not displayed");
        }
        return this;
    }

}
