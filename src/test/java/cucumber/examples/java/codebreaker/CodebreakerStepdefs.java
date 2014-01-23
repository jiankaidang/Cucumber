package cucumber.examples.java.codebreaker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jiankai Dang on 1/22/14.
 */
public class CodebreakerStepdefs {
    private Codebreaker codebreaker;
    private List<String> prompts = new ArrayList<String>();

    @Given("^I start codebreaker with code \"([^\"]*)\"$")
    public void i_start_codebreaker_with_code(String code) {
        codebreaker = new Codebreaker(code);
    }

    @When("^I run the game with the following inputs:$")
    public void i_run_the_game_with_the_following_inputs(List<String> inputs) {
        for (int i = 1; i < inputs.size(); i++) {
            prompts.add(codebreaker.breakcode(inputs.get(i)));
        }
    }

    @Then("^I should see the following prompts:$")
    public void i_should_see_the_following_prompts(List<String> expectedPrompts) {
        for (int i = 1; i < expectedPrompts.size(); i++) {
            assertEquals(expectedPrompts.get(i), prompts.get(i - 1));
        }
    }
}
