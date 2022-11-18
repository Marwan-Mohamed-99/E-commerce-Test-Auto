package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class followUsFeatureSteps {
    private homePage home;

    @Given("install follow us feature")
    public void init() {
        home = new homePage(Hooks.driver);
    }

    @When("^user clicks \"(.*)\"$")
    public void clickOnIcon(String icon){
        home.goToFollowUs(icon);
    }

    @Then("^user go to selected \"(.*)\"$")
    public void checkOnUrl(String url) throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs= new ArrayList<String>(Hooks.driver.getWindowHandles());
        if(!url.contains("new-online")){
            Hooks.driver.switchTo().window(tabs.get(1));
        }
        else {
            Hooks.driver.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(home.getUrl(),url);

    }


}
