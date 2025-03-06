package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
    @When("I click on A\\/B Testing")
    public void i_click_on_a_b_testing() {
        System.out.println("hello");
    }
    @Then("I should land on A\\/B Test Control")
    public void i_should_land_on_a_b_test_control() {

    }
}
