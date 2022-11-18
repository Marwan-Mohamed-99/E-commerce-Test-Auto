package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class homePage {
   private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToLoginPage(){
        driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]")).click();
    }

    public void logout(){
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();

    }
    public WebElement selectCurrency(){
       return driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]"));
    }
    public List<WebElement> getActualPrice(){
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public String checkMyAccountIcon(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"header-links\"]>ul>li")).get(0).findElement(By.tagName("a")).getText();
    }

    public WebElement searchField(){
        return driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]"));
    }
    public WebElement searchBtn(){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }
    public List<WebElement> getCategoriesWebElm(){
        return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }
    public List<WebElement> getSubCategoriesWebElm(int num){
        switch (num){
            case 0:
            case 1:
            case 2:
                return driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>ul[class]"));
        }
        return Collections.EMPTY_LIST;
    }
    public void navigateToCategory(WebElement element){
        if(element!=null){
        Hooks.driver.navigate().to(element.getAttribute("href").toString());
        }
    }
    public void navigateToSubCategory(WebElement element,int num){
        if(element!=null){
            List<WebElement> subArray=element.findElements(By.tagName("a"));
            Hooks.driver.navigate().to(subArray.get(num).getAttribute("href").toString());
        }
    }
    public String getPageTitle(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
    }

    public String getSubCategoryTitle(WebElement element,int num){
        if(element!=null){
            List<WebElement> subArray=element.findElements(By.tagName("a"));
           return subArray.get(num).getAttribute("href").toString().toLowerCase();
        }
        return null;
    }
    public String selectSliderPicture(String selectedPic) {
        List<WebElement> pictures= driver.findElement(By.cssSelector("div[id=\"nivo-slider\"]")).findElements(By.tagName("a"));
       if(selectedPic=="nokia"){
           return pictures.get(0).getAttribute("href").toString();
       }
       else {
           return pictures.get(1).getAttribute("href").toString();
       }
    }
    public void goToFollowUs(String icon){
        if(icon!=null) {
            switch (icon) {
                case "facebook":
                    Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
                    break;
                case "twitter":
                    Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
                    break;
                case "youtube":
                    Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
                case "news":
                    Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]")).click();
            }
        }
    }
    public void addProductToWishList(String productName) {
        //get all web elements that have wish list button
       List<WebElement> products= Hooks.driver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));
       if(productName!=null) {
       switch (productName){
           //choose wish list icon of MacBook
           case "Apple MacBook Pro 13-inch":
               products.get(1).click();
               driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
               Hooks.driver.findElement(By.cssSelector("button[id=\"add-to-wishlist-button-4\"]")).click();
               driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
               Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
               break;
           //choose wish list icon of htc phone
           case "HTC One M8 Android L 5.0 Lollipop":
               driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
               products.get(2).click();
               driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
               break;
        }
       }
    }
    public String getAddToWishListMessageText(){
        return Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
    }
    public String getAddToWishListMessageBackGroundColor(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
    }
    public void goToWishList(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"/wishlist\"]")).click();
    }

    //this function gets all web elements at wish list page then search at the required product and
    //return its qty and if the wish list is empty it returns -1
    public int findProductQty(String productName){
        List<WebElement> qty= Hooks.driver.findElements(By.cssSelector("td[class=\"quantity\"]"));
        List<WebElement> products =Hooks.driver.findElements(By.cssSelector("td[class=\"product\"]"));
        int index=0;
        if(!products.isEmpty()) {
            for (WebElement product : products) {
                if (product.findElement(By.className("product-name")).getText().equals(productName)) {
                    String numToString = qty.get(index).findElement(By.tagName("input")).getAttribute("value").toString();
                    int num = Integer.parseInt(numToString);
                    return num;
                }
                index++;
            }
        }
        else{
        return -1;
        }
        //the product is not in wish list
        return 0xff;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
