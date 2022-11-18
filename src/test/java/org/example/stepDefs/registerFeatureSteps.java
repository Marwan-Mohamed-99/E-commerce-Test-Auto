package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.example.pages.registerPage;
import org.testng.asserts.SoftAssert;

public class registerFeatureSteps {

    registerPage register ;




    @When("user press register icon")
    public void pressRegisterIcon() throws InterruptedException {
        register.goToRegisterPage();
        Thread.sleep(2000);
    }
    @And("^user selects \"(.*)\" and enters \"(.*)\" as first name, \"(.*)\" as last name, \"(.*)\" as email, \"(.*)\" as company, \"(.*)\" as password and \"(.*)\" as confirm password$")
    public void enterRegisterData(String gender,String firstName, String lastName, String email, String company, String password, String confirmPassword) throws InterruptedException {

        register.selectGender(gender);
        register.enterFirstName().sendKeys(firstName);
        register.enterLastName().sendKeys(lastName);
        register.enterEmail().sendKeys(email);
        register.enterCompany().sendKeys(company);
        register.enterPassword().sendKeys(password);
        register.enterConfirmPassword().sendKeys(confirmPassword);
        Thread.sleep(1000);

    }
    @And("^user set his birthday as follow \"(.*)\" Day \"(.*)\" Month \"(.*)\" Year$")
    public void clickOnBirthDay(String day, String month, String year){
        register.setBirthday(day, month, year);
    }

    @And("user clicks on register button")
    public void pressRegisterButton() throws InterruptedException {
        register.pressRegisterButton();
        Thread.sleep(2000);
    }

    @Then("successful registration message appears")
    public void checkOnRegistrationMessageCompilation(){
        String expectedResult="Your registration done";
        String actualResult=register.getRegistrationMessageCompilation().getText();
        String expectedColor="rgba(76, 177, 124, 1)";
        String color= register.getRegistrationMessageCompilation().getCssValue("color");
        SoftAssert soft = new SoftAssert();
      soft.assertTrue(expectedResult.contains(actualResult));
       soft.assertEquals(color,expectedColor);
       soft.assertAll();
    }
    @Then("error messages appear")
    public void checkOnErrorMessages(){
        String[] expectedResults={"First name is required.","Last name is required.","Email is required.",
        "Password is required.","Password is required."};
        String actualResult=null;
        for(int i=0; i< expectedResults.length;i++){
            actualResult=register.getActualErrorMessages(i).getText();
           Assert.assertTrue(expectedResults[i].contains(actualResult));
        }

    }
    @Then("email exist message appears")
    public void checkOnEmailExistMessage(){
       String actualResult = register.getEmailExistMessage().getText();
       String expectedResult="The specified email already unavaliable";
      Assert.assertTrue(expectedResult.contains(actualResult));
    }
    @Then("user get different passwords")
    public void checkNonIdenticalMessage(){
        String actualResult = register.getConfirmPasswordError().getText();
        String expectedResult="The password and confirmation password do not be the same .";
      Assert.assertTrue(expectedResult.contains(actualResult));
    }

    @Given("initialize register feature")
    public void setRegister()  {
        register = new registerPage(Hooks.driver);
    }

}
