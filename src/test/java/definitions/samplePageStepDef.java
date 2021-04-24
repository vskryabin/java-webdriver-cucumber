package definitions;

import Pages.SamplePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class samplePageStepDef {

    SamplePage sample = new SamplePage();

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        switch (url) {
            case "sample":
                sample.open();
            break;

            default:
                throw new RuntimeException("Unknown page: " + url);
        }
    }

    @When("I click submit button")
    public void iClickSubmitButton() throws InterruptedException {
        sample.clickOnSubmitButton();
    }


    @Then("I verify username error text is {string}")
    public void iVerifyUsernameErrorTextIs(String expectedError) throws InterruptedException{
        String actualError = sample.getUsernameErrorText();
        assertThat(expectedError).isEqualToIgnoringCase(actualError);
    }


    @Then("I verify email error text is {string}")
    public void iVerifyEmailErrorTextIs(String expectedError) {
    String actualError = sample.getEmailErrorText();
    assertThat(expectedError).isEqualToIgnoringCase(actualError);
    }

    @Then("I verify password error text is {string}")
    public void iVerifyPasswordErrorTextIs(String expectedError) {
        String actualError = sample.getpasswordErrorText();
        assertThat(expectedError).isEqualToIgnoringCase(actualError);
    }

    @Then("I verify name error text is {string}")
    public void iVerifyNameErrorTextIs(String expectedError) {
        String actualError = sample.getNameErrorText();
        assertThat(expectedError).isEqualToIgnoringCase(actualError);
    }

    @Then("I verify Privacy Policy error text is {string}")
    public void iVerifyPrivacyPolicyErrorTextIs(String expectedError) {
        String actualError = sample.getPrivacyPolicyErrorTxt();
        assertThat(expectedError).isEqualToIgnoringCase(actualError);
    }

    @When("I send text {string} into {string} field")
    public void iSendTextIntoField(String txt, String field) {
        sample.fillOutEmailField(txt);
    }

    @Then("I verify that confirmPassword field is disabled")
    public void iVerifyThatConfirmPasswordFieldIsDisabled() {
     sample.verifyConfirmPasswordFieldIsDisabled();
    }

    @When("I enter {string} in password field")
    public void iEnterInPasswordField(String txt) {
        sample.fillOutPassword(txt);

    }

    @When("I change resolution to {string} layout")
    public void iChangeResolutionToLayout(String resolution) {
        if(resolution.equalsIgnoreCase("Desktop")) {
            getDriver().manage().window().setSize(new Dimension(1440, 681));
        } else if(resolution.equalsIgnoreCase("Tablet")) {
            getDriver().manage().window().setSize(new Dimension(850, 681));
        } else if(resolution.equalsIgnoreCase("Phone")) {
            getDriver().manage().window().setSize(new Dimension(700, 681));
        } else {
            System.out.println("Wrong screen type");
        }

    }

    @Then("I verify that location date and time present")
    public void iVerifyThatLocationDateAndTimePresent() {
        assertThat(sample.verifyLocationDateAndTimeIsPresent()).isTrue();
    }

    @Then("I verify that location date and time not present")
    public void iVerifyThatLocationDateAndTimeNotPresent() {
        assertThat(sample.verifyLocationDateAndTimeAreNotPresent()).isTrue();
    }
}
