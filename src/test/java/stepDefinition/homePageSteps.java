package stepDefinition;

import cucumber.Base;
import objects.homePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePageSteps {

    public WebDriver driver;
    homePage homepage = new homePage(driver);

    @Given("that the user navigated to the Shop page")
    public void user_navigates_to_the_shop_page() throws Throwable{
        driver = Base.getDriver();
    }

    @Given("I add {int} random items to my cart")
    public void i_add_four_random_items_to_my_cart(int number) {
        for(int i=0; i<number; i++){
            homepage.selectRandomProductAndAddToCart();
            homepage.navigateBackHome();
        }
    }

    @When("I view my cart")
    public void i_view_my_cart() {
        homepage.navigateToCart();
    }

    @Then("I find the total {int} items listed in my cart")
    public void i_find_the_total_four_items_listed_in_my_cart(int number) {
        Assert.assertEquals(homepage.howManyItems(), number);
    }


    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() {
        homepage.lowestPrice();
    }

    @And("I am able to remove the lowest price item from my cart")
    public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I am able to verify three items in my cart")
    public void i_am_able_to_verify_three_items_in_my_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
