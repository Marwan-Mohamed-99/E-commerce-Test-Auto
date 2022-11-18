package org.example.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.example.pages.loginPage;
import org.testng.asserts.SoftAssert;

public class loginFeatureSteps {
    loginPage login ;
    homePage home_page;

  /*************************** login feature methods*********************/
    @Given("initialize login feature")
    public void navigatesToLoginPage() throws InterruptedException {
        login= new loginPage(Hooks.driver);
        home_page= new homePage(Hooks.driver);
        home_page.goToLoginPage();
        Thread.sleep(1000);
    }
    @When("^enter email \"(.*)\" and password \"(.*)\"$")
    public void validData(String email , String Password) throws InterruptedException {


        login.setEmail().sendKeys(email);

        login.setPass().sendKeys(Password);
        Thread.sleep(1000);

    }
    @When("user press forget password")
    public void pressForgetPassword(){
        login.pressForgetPassword();

    }
    @And("^user enter email \"(.*)\"$")
    public void enterEmail(String email){
        login.setEmail().sendKeys(email);
    }
    @And("press login")
    public void pressLogin(){
        login.pressLoginButton();
    }
    @And("press recover button")
    public void pressRecoverButton() throws InterruptedException {
        login.pressRecoverBtn();
        Thread.sleep(2000);
    }
    @Then("user go to home page")
    public void checkOnLogin(){
        SoftAssert soft =new SoftAssert();
        String actualResult=home_page.checkMyAccountIcon();
        String expectedResult="My account";
        soft.assertEquals(home_page.getUrl(),"https://demo.nopcommerce.com/");
        soft.assertTrue(expectedResult.equals(actualResult));
        soft.assertAll();
    }
    @Then("user logout")
    public void checkLoginStatus(){
        home_page.logout();
    }

    @Then("check on error message")
    public void checkOnInvalidLogin(){
        SoftAssert soft =new SoftAssert();
        String actualResult=login.getLoginErrorMessage().getText();
        String actualMessageColor=login.getLoginErrorMessage().getCssValue("color");
        String expectedResult="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String expectedMessageColor="rgba(228, 67, 75, 1)";
        soft.assertTrue(actualResult.equals(expectedResult));
        soft.assertTrue(actualMessageColor.equals(expectedMessageColor));
        soft.assertAll();
    }
    @Then("check on email error message")
    public void checkOnEmailErrorMessage(){
        String actualResult=Hooks.driver.findElement(By.cssSelector("span[id=\"Email-error\"]")).getText();
        String expectedResult="Wrong email";
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Then("user gets instructions message has been sent")
    public void checkOnResetPasswordMessage(){
        String actualResult = login.getRecoveryMessage().getText();
        String expectedResult="Email with instructions has been sent to you.";
        Assert.assertTrue(expectedResult.contains(actualResult));
    }



}
