package com.junit.steps;

import com.junit.pages.DocsPage;
import com.junit.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuSteps {
    private HomePage homePage=new HomePage();
    private DocsPage docsPage=new DocsPage();

    @When("the user opens Cucumber website")
    public void opensCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homePage.menuSection(section).click();
    }

    @When("the user clicks on the {string} item")
    public void clickOnItem(String item) {
        homePage.menuChildItem(item).click();
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        assertThat(docsPage.isPageWithTitleDisplayed(pageTitle))
                .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }
}
