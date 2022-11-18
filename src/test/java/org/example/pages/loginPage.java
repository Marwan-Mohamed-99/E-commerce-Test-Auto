package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
   private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement setEmail()  {
        driver.findElement(By.cssSelector("input[id=\"Email\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Email\"]"));


    }

    public WebElement setPass(){
        driver.findElement(By.cssSelector("input[id=\"Password\"]")).clear();
        return driver.findElement(By.cssSelector("input[id=\"Password\"]"));
    }
    public void pressLoginButton(){
        driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
    }
    public WebElement getLoginErrorMessage(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));

    }

    public void pressRecoverBtn(){
        driver.findElement(By.cssSelector("button[name=\"send-email\"]")).click();
    }
    public WebElement getRecoveryMessage(){
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public void pressForgetPassword(){
        driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]")).click();
    }
}
