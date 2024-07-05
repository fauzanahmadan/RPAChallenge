package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static helper.Utility.driver;
import pages.webPage;


public class webStep {

    webPage webPage;
    public webStep()
    {
        this.webPage = new webPage();
    }

    @Given("user goto web RPA Challenge")
    public void userGotoWebRPAChallenge() {
        driver.get("https://rpachallenge.com/");
    }

    @And("User click Start")
    public void userClickStart() {
        webPage.clickBtnStart();
    }

    @When("user input data round {int}")
    public void userInputDataRound(int round) {
        webPage.inputForm(round);

    }

    @And("user click button submit")
    public void userClickButtonSubmit() {
        webPage.clickBtnSubmit();
    }

    @Then("user will see {string}`")
    public void userWillSee(String note) {
        webPage.inputDone(note);

    }
}
