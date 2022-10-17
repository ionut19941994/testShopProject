package objects;

import cucumber.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.util.Elements;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Float.valueOf;

public class homePage extends Base {

    By product2=By.xpath("//a[contains(text(),'Add to cart')]//parent::div");

    public List<WebElement> products(){
        return driver.findElements(product2);
    }

    By price=By.xpath("//td[@class='product-subtotal']//following-sibling::span");

    public WebElement price(){
        return driver.findElement(price);
    }

    By cartItem=By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']");

    public List<WebElement> cartItems() {
        return driver.findElements(cartItem);
    }

    By addToCart=By.name("add-to-cart");

    public WebElement addToCart(){
        return driver.findElement(addToCart);
    }

    By goToCart=By.xpath("//a[contains(text(),'Cart')]");

    public WebElement goToCart(){
        return driver.findElement(goToCart);
    }

    By goBackHome=By.xpath("//a[@rel='home']");

    public WebElement goBackHome(){
        return driver.findElement(goBackHome);
    }

    public homePage(WebDriver driver){
        Base.driver =driver;
    }

    public void navigateBackHome() {
        goBackHome().click();
    }

    public void navigateToCart() {
        goToCart().isDisplayed();
        goToCart().click();
    }

    public int howManyItems() {
        return cartItems().size();
    }

    public float lowestPrice() {
        int l=Integer.parseInt(price().toString().replaceAll("$","").replaceAll(".00",""));
        for( int i=0; i< cartItems().size();i++){
             if(Integer.parseInt(price().toString().replaceAll("$","").replaceAll(".00",""))<l)
                 l= Integer.parseInt(price().toString().replaceAll("$","").replaceAll(".00",""));
        }
        return l;
    }




    public void selectRandomProductAndAddToCart() {
        Random random = new Random();
        Actions action = new Actions(driver);
        int randomized = random.nextInt(products().size());
        action.moveToElement(products().get(randomized)).click().perform();
        addToCart().click();

    }
}
