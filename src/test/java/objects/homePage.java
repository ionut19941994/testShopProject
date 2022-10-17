package objects;

import cucumber.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class homePage extends Base {

    @FindBy(xpath = "//h2[@class='woocommerce-loop-product__title']")
    protected List<WebElement> product;

    @FindBy(xpath = "//ul[@class='products columns-3']//following-sibling::li")
    protected List<WebElement> addItem;

    public homePage(WebDriver driver){
        Base.driver =driver;
    }


    public void selectRandomProductAndAddToCart() {
        Random random = new Random();
        Actions action = new Actions(driver);
        int randomized = random.nextInt(product.size());
        action.moveToElement(product.get(randomized)).click().perform();
    }
}
