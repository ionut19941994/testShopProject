package objects;

import cucumber.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class homePage extends Base {

    By product2=By.xpath("//a[contains(text(),'Add to cart')]//parent::div");

    public List<WebElement> products(){
        return driver.findElements(product2);
    }

    By updateButton=By.xpath("//a[contains(text(),'Add to cart')]//parent::div");

    public WebElement updateButton(){
        return driver.findElement(updateButton);
    }

    By xButton=By.cssSelector("td.product-remove>a");

    public List<WebElement> xButtons(){
        return driver.findElements(xButton);
    }

    By price=By.cssSelector("td.product-subtotal>span");

    public List<WebElement> prices(){
        return driver.findElements(price);
    }

    By cartElement=By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']");
    public List<WebElement> cartElements() {
        return driver.findElements(cartElement);
    }

    By cartItem=By.xpath("//input[@type!='hidden' and @value!='']");
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
        int s=0, i=0;
        while( i<cartElements().size())
            {
                String l = cartItems().get(i).getAttribute( "value");
                s+= Integer.parseInt(l);
                i++;
            }
        return s;
    }

    public float lowestPrice() {
        String p=prices().get(0).getText().replace("$","");
        float l=Float.parseFloat(p);
        int i=1;
        while(i < cartElements().size())
        {
            p=prices().get(i).getText().replace("$","");
             if(Float.parseFloat(p)<l)
                 l= Float.parseFloat(p);
             i++;
        }
        return l;
    }

    public void removeLowestPrice() {
        String p=prices().get(0).getText().replace("$","");
        float l=Float.parseFloat(p);
        int i=1,j=0;
        while(i < cartElements().size())
        {
            p=prices().get(i).getText().replace("$","");
            if(Float.parseFloat(p)<l) {
                l = Float.parseFloat(p);
                j=i;
            }
            i++;
        }
        xButtons().get(j).click();
    }

    public boolean verifyUpdateButton() {
        return updateButton().isEnabled();
    }

    public void selectRandomProductAndAddToCart() {
        Random random = new Random();
        Actions action = new Actions(driver);
        int randomized = random.nextInt(products().size());
        action.moveToElement(products().get(randomized)).click().perform();
        addToCart().click();

    }
}
