package com.junit.actions;

import com.junit.pages.DocsPage;
import org.openqa.selenium.By;

import static java.lang.String.format;

public final class DocsAction extends BaseAction {
    private static final String PAGE_TITLE_PATTERN = "//*[@class='page-header']/*[contains(@class,'title') and contains(text(),'%s')]";

    private final DocsPage docsPage;

    public DocsAction() {
        super();
        docsPage = new DocsPage(getDriver());
    }

    public boolean isPageWithTitleDisplayed(String pageTitle) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE_PATTERN, pageTitle)));
    }
}
