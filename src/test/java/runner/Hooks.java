package runner;

import cucumber.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {

    @Before("@test")
    public void beforeValidation() {
    }

    @After("@test")
    public void afterSeleniumTest() {
        try {driver.close();}
        catch (NullPointerException npe) {
            System.out.println("Exception caught");
        }
    }
}
