package definitions;

import Pages.ICDPackage.ICDMainPage;
import Pages.ICDPackage.IcdDemoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class icdStepDefs {

    ICDMainPage main = new ICDMainPage();
    IcdDemoPage demo = new IcdDemoPage();

    @Given("I navigate to the {string} page")
    public void iNavigateToThePage(String url) {
        switch (url) {
            case "icd":
                main.open();
                break;

            default:
                throw new RuntimeException("Unknown page: " + url);
        }
    }

    @When("I go to request demo page")
    public void iGoToRequestDemoPage() throws InterruptedException {
        main.openRequestDemoPage();
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String txt) throws InterruptedException{
    demo.fillOutInputFields(field, txt);
    }

    @When("I fill out {string} field with the {string}")
    public void iFillOutFieldWithThe(String field, String txt) throws InterruptedException {
    demo.fillOutEmailField(field, txt);
    }

    @When("I acknowledge terms and conditions")
    public void iAcknowledgeTermsAndConditions() throws InterruptedException {
        demo.acknowledgeTerms();
    }

    @When("i submit the form")
    public void iSubmitTheForm() throws InterruptedException {
        demo.submitThePage();
    }

    @Then("I verify form was submitted")
    public void iVerifyFormWasSubmitted() throws InterruptedException {
        assertThat(main.verifyThatPageWasSubmitted()).isTrue();
    }

    @When("I fill out {string} field text {string}")
    public void iFillOutFieldText(String field, String txt) throws InterruptedException {
        demo.fillOutCommentsField(field, txt);
    }

    @When("I accept the cookies")
    public void iAcceptTheCookies() throws InterruptedException{
        main.acceptTheCookies();
    }

    @Then("I verify that message {string} is present")
    public void iVerifyThatMessageIsPresent(String expectedError) throws InterruptedException {
        String actualError = demo.getTextFromDemoFormHeader();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Then("I verify that first name error message equal to {string}")
    public void iVerifyThatFirstNameErrorMessageEqualTo(String expectedError) throws InterruptedException {
        String actualError = demo.getTxtFromFirstNameError();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Then("I verify that last name error message equal to {string}")
    public void iVerifyThatLastNameErrorMessageEqualTo(String expectedError) throws InterruptedException {
        String actualError = demo.getTxtFromLastNameError();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Then("I verify that email error message equal to {string}")
    public void iVerifyThatEmailErrorMessageEqualTo(String expectedError) throws InterruptedException {
        String actualError = demo.getTxtFromEmailError();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Then("I verify that company error message equal to {string}")
    public void iVerifyThatCompanyErrorMessageEqualTo(String expectedError) throws InterruptedException {
        String actualError = demo.getTxtFromCompanyError();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @When("I go to terms and conditions page")
    public void iGoToTermsAndConditionsPage() throws InterruptedException {
        demo.clickTermsAndConditionsBtn();
    }

    @Then("I verify that title contains {string}")
    public void iVerifyThatTitleContains(String expectedTitle) throws InterruptedException {
    demo.getTermsAndConditionsHeaderTxt();
    }

    @When("I go to privacy policy page")
    public void iGoToPrivacyPolicyPage() throws InterruptedException {
    demo.goToPrivacyPolicy();
    }

    @Then("I assert that message {string} is present")
    public void iAssertThatMessageIsPresent(String expectedMessage) throws InterruptedException {
        String actualMessage = demo.getPrivacyConsentTxt();
        assertThat(actualMessage).containsIgnoringCase(expectedMessage);
    }

    @When("I go back to request demo page")
    public void iGoBackToRequestDemoPage() throws InterruptedException {
        demo.goToThePreviousPage();
        demo.goToThePreviousPage();
    }

    @When("I go to investing page")
    public void iGoToInvestingPage() throws InterruptedException {
        main.goToInvestingPage();
    }

    @Then("I verify that header {string} is present")
    public void iVerifyThatHeaderIsPresent(String expectedTxt) throws InterruptedException {
        String actualTxt = main.getInvestmentProductsHeaderTxt();
        assertThat(actualTxt).containsIgnoringCase(expectedTxt);
    }


    @When("I go to Money market funds page")
    public void iGoToMoneyMarketFundsPage() throws InterruptedException {
    main.goToMoneyMarketFundsPage();
    }

    @Then("I verify that {string} is among listed currencies")
    public void iVerifyThatIsAmongListedCurrencies(String expectedCurrency) throws InterruptedException{
    String listOfCurrencies = main.getListOfCurrencies();
    assertThat(listOfCurrencies).contains(expectedCurrency);
    }

    @When("I go back to investing page")
    public void iGoBackToInvestingPage() throws InterruptedException {

    }
}
