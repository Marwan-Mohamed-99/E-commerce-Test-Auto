package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    public static WebDriver driver;

    @Before
    public  static void OpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmed\\IdeaProjects\\CucumberProject\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
