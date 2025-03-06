package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewStep1 {
    
    @When("I click go here")
    public void iClickGoHere() {
        System.out.println("step2");
    }

    @Then("I should land on this here")
    public void iShouldLandOnThisHere() {
    }
}
