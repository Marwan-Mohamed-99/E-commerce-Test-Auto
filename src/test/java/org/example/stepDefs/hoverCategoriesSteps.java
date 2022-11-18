package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class hoverCategoriesSteps {
    private homePage home;

    @Given("install hover to categories feature")
    public void init() {
        home = new homePage(Hooks.driver);
    }

    @When("user choose random category he should go its page")
    public void selectRandomCategory() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        String expectedTitle=null;
        List<WebElement> categories = home.getCategoriesWebElm();
        int count = categories.size();
        int min = 0;
        int max = count - 1;   // you are selecting random value from 0 to size that's why  max = count-1
        int selectedMainCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
        action.moveToElement(categories.get(selectedMainCategory)).perform();
        Thread.sleep(2000);
        if(home.getSubCategoriesWebElm(selectedMainCategory).isEmpty()){
            expectedTitle= categories.get(selectedMainCategory).getText();
            home.navigateToCategory(categories.get(selectedMainCategory));
            Assert.assertEquals(home.getPageTitle(),expectedTitle);
        }
        else {
            //return list of all main sub-categories web element "sublist first-level"
            List<WebElement> subCategories= home.getSubCategoriesWebElm(selectedMainCategory);
            count = subCategories.size();
            max = count - 1;   // you are selecting random value from 0 to 2 that's why  max = count-1
            int selectedSub = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println(count);
            System.out.println(selectedSub);
            //return title by passing the selected main sub-category element and the random number
            // inside this sub category
            if(home.getSubCategoryTitle(subCategories.get(selectedMainCategory),selectedSub)!=null){
                expectedTitle = home.getSubCategoryTitle(subCategories.get(selectedMainCategory),selectedSub);
                System.out.println(expectedTitle);

            }
            home.navigateToSubCategory(subCategories.get(selectedMainCategory),selectedSub);
            System.out.println(home.getPageTitle());
            Assert.assertTrue(expectedTitle.contains(home.getPageTitle().toLowerCase()));
        }
    }


}
