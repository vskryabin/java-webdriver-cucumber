package definitions;

import Pages.Sample.SamplePage;
import Pages.Sample.SampleVerify;
import Pages.USPS.UspsMain;
import Pages.UPS.UpsFirstPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertTrue;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class samplePageStepDef {

    SamplePage sample = new SamplePage();
    SampleVerify verify = new SampleVerify();
    UspsMain uspsMain = new UspsMain();
    UpsFirstPage upsFirst = new UpsFirstPage();

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        switch (url) {
            case "sample":
                sample.open();
            break;
            case "usps":
                uspsMain.open();
                break;
            case "ups":
                upsFirst.open();
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
        String actualError = sample.getPasswordErrorText();
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

    @When("I fill out Username field with {string}")
    public void iFillOutUsernameFieldWith(String username) {
    sample.fillOutUsername(username);
    }

    @When("I enter {string} in confirm password field")
    public void iEnterInConfirmPasswordField(String password) {
    sample.fillOutConfirmPassword(password);
    }

    @When("I fill out phone field with {string}")
    public void iFillOutPhoneFieldWith(String phone) {
    sample.fillOutPhoneNumberField(phone);
    }

    @When("I fill out the name with {string} {string} {string}")
    public void iFillOutTheNameWith(String firstName, String middleName, String lastName) {
    sample.fillOutTheName(firstName, middleName, lastName);
    }

    @When("I select Gender {string}")
    public void iSelectGender(String gender) throws InterruptedException {
        sample.selectGender(gender);

    }

    @When("I fill out address with {string}")
    public void iFillOutAddressWith(String address) throws InterruptedException {
        sample.fillOutTheAddress(address);
    }

    @When("I select country as {string}")
    public void iSelectCountryAs(String country) throws InterruptedException {
    sample.selectCountry(country);
    }


    @When("I select car make as {string} and {string}")
    public void iSelectCarMakeAsAnd(String car1, String car2) throws InterruptedException {
       // can also use this to select multiply
//        getDriver().findElement(By.xpath("//option[contains(text(),'Toyota')]")).click();

     new Actions(getDriver()).keyDown(Keys.COMMAND).keyUp(Keys.COMMAND).build();

    sample.selectCarByTxt(car1);
    sample.selectCarByTxt(car2);

    }


    @When("I check allowed to contact me")
    public void iCheckAllowedToContactMe() throws InterruptedException{
    sample.switchAllowToContactCheckBox();
    }

    @When("I set DOB as {string}")
    public void iSetDOBAs(String dob) throws InterruptedException {
        sample.fillOutDateOfBirth(dob);
    }

    @When("I accept third party agreement")
    public void iAcceptThirdPartyAgreement() throws InterruptedException{
    sample.acceptThirdPartyAgreement();
    }

    @When("I fill out additional info with name {string} and phone {string}")
    public void iFillOutAdditionalInfoWithNameAndPhone(String name, String phone) throws InterruptedException {
    sample.fillOutContactPersonInfo(name, phone);
    }

    @When("I click related documents")
    public void iClickRelatedDocuments() throws InterruptedException{
    sample.clickOnRelatedDocs();
    }

    @Then("I verify that page contains {string}")
    public void iVerifyThatPageContains(String expectedTxt) {

    // switch to another window
    String firstWindow = getDriver().getWindowHandle();
    for(String handle: getDriver().getWindowHandles()) {
        getDriver().switchTo().window(handle);
    }

    // Assert that actual text from the page contains our expected text
    String actualTxt = sample.getTxtFromRelatedDocumentsPage();
    Assert.assertTrue(actualTxt.contains(expectedTxt));

        // Close the new window, if that window no more required
    getDriver().close();

    getDriver().switchTo().window(firstWindow);
    }

    @When("I upload file {string}")
    public void iUploadFile(String file) throws InterruptedException{
        sample.chooseFile(file);
    }

    @Then("I verify that name of the uploaded file is {string}")
    public void iVerifyThatNameOfTheUploadedFileIs(String expectedName) throws InterruptedException{
        String actualName = sample.getTextFromTheAttachment();
//        assertThat(expectedName).isEqualToIgnoringCase(actualName);
        Assert.assertTrue(actualName.contains(expectedName));
    }

    @When("I agree to privacy policy")
    public void iAgreeToPrivacyPolicy() {
        sample.clickOnAgreedToPrivacyPolicy();
    }

    @Then("I verify name as {string}")
    public void iVerifyNameAs(String expectedUsername)  throws InterruptedException{
        String actualUsername = verify.getUsernameTxt();
        assertThat(actualUsername).isEqualTo(expectedUsername);
    }

    @Then("I verify email as {string}")
    public void iVerifyEmailAs(String expectedEmail) throws InterruptedException{
        String actualEmail = verify.getEmailTxt();
        assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @Then("I verify that password is entered")
    public void iVerifyThatPasswordIsEntered() throws InterruptedException{
        assertThat(verify.getPasswordTxt()).containsIgnoringCase("entered");
    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String expectedPhone) throws InterruptedException {
        String actualPhone = verify.getPhoneTxt();
        assertThat(actualPhone).isEqualTo(expectedPhone);
    }

    @Then("I verify the name is {string}")
    public void iVerifyTheNameIs(String expectedName) throws InterruptedException {
        String actualName = verify.getNameTxt();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Then("I verify that gender is certainly {string}")
    public void iVerifyThatGenderIsCertainly(String expectedGender) throws InterruptedException {
        String actualGender = verify.getGenderTxt();
        assertThat(actualGender).isEqualTo(expectedGender);
    }

    @Then("I verify the address {string}")
    public void iVerifyTheAddress(String expectedAddress) throws InterruptedException {
        String actualAddress = verify.getAddressTxt();
        assertThat(actualAddress).isEqualTo(expectedAddress);
    }

    @Then("I verify that country is {string}")
    public void iVerifyThatCountryIs(String ExpectedCountry) throws InterruptedException {
        String actualCountry = verify.getCountryTxt();
        assertThat(actualCountry).isEqualTo(ExpectedCountry);
    }


    @Then("I verify that car make is {string}")
    public void iVerifyThatCarMakeIs(String expectedCar) throws InterruptedException {
        String actualCar = verify.getCarMakeTxt();
        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Then("I verify that allowed to contact is {string}")
    public void iVerifyThatAllowedToContactIs(String arg0) throws InterruptedException {
        String actualTxt = verify.getAllowedToContactTxt();
        assertThat(actualTxt).isEqualTo("true");
    }

    @Then("I verify date of birth {string}")
    public void iVerifyDateOfBirth(String ExpectedDob) throws InterruptedException {
        String actualDob = verify.getDobTxt();
        assertThat(actualDob).isEqualTo(ExpectedDob);
    }

    @Then("I verify third party agreement is {string}")
    public void iVerifyThirdPartyAgreementIs(String expectedTxt) throws InterruptedException {
        String actualTxt = verify.getThirdPartyAgreementTxt();
        assertThat(actualTxt).isEqualTo(expectedTxt);
    }

    @Then("I verify Contact Person Name is {string}")
    public void iVerifyContactPersonNameIs(String expectedName) throws  InterruptedException {
        String actualName = verify.getContactPersonNameTxt();
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Then("I verify Contact Person phone is {string}")
    public void iVerifyContactPersonPhoneIs(String expectedPhone) throws InterruptedException {
        String actualPhone = verify.getContactPersonPhoneTxt();
        assertThat(actualPhone).isEqualTo(expectedPhone);
    }


    @Then("I verify uploaded file is {string}")
    public void iVerifyUploadedFileIs(String expectedFileName) throws InterruptedException {
        String actualFileName = verify.getAttachmentName();
        assertThat(actualFileName).isEqualTo(expectedFileName);
    }

    @Then("I verify that agreed to privacy policy is {string}")
    public void iVerifyThatAgreedToPrivacyPolicyIs(String arg0) throws InterruptedException{
        String actualTxt = verify.getAgreedToPrivacyPolicyTxt();
        assertThat(actualTxt).isEqualTo("true");
    }

    @Then("I verify current date")
    public void iVerifyCurrentDate() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String javaDate = dateFormat.format(date);

        String webCiteDate = verify.getCurentDate();
        assertThat(javaDate).isEqualTo(webCiteDate);
    }

    @When("I hit return button")
    public void iHitReturnButton() throws InterruptedException{
        verify.clickReturnButton();
    }

    @Then("I verify that submit button is present")
    public void iVerifyThatSubmitButtonIsPresent() throws InterruptedException {
        assertTrue(sample.isSubmitButtonPresent());
    }
}
