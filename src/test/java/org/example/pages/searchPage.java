package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchPage {
    private WebDriver driver;

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<WebElement> getResults(){
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }
    public String getProductSkuUrl(WebElement element){
        return element.findElement(By.tagName("a")).getAttribute("href");
    }

    public List<WebElement> getProductTitlesElements(){
        return driver.findElement(By.cssSelector("div[class=\"sku\"]")).findElements(By.tagName("span"));
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }

}
