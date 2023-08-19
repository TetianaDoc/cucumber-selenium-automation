package com.junit.steps;

import com.junit.actions.DocsAction;
import com.junit.actions.HomeAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuSteps {

    private final HomeAction homeAction = new HomeAction();
    private final DocsAction docsAction = new DocsAction();

    @When("the user opens Cucumber website")
    public void opensCucumberWebsite() {
        homeAction.openCucumberWebsite();
    }

    @When("the user clicks on the cookies")
    public void clickOnCookies() {
        homeAction.getAllowAllCookiesButton();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homeAction.menuSection();
    }

    @When("the user clicks on the {string} item")
    public void clickOnItem(String item) {
        homeAction.menuChildItem();
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        assertThat(docsAction.isPageWithTitleDisplayed(pageTitle))
                .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }


}
