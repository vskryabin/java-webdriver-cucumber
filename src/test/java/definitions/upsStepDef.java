package definitions;

import Pages.UPS.CreateShipment;
import Pages.UPS.UpsFirstPage;
import Pages.UPS.UpsMainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class upsStepDef {

    UpsFirstPage upsFirst = new UpsFirstPage();
    UpsMainPage upsMain = new UpsMainPage();
    CreateShipment shipment = new CreateShipment();

    @When("I select {string} as a region")
    public void iSelectAsARegion(String txt) throws InterruptedException {
        upsFirst.selectTheLangAndRegion(txt);
    }

    @When("I go to the shipment page")
    public void iGoToTheShipmentPage() throws InterruptedException {
        upsMain.openShippingPage();
    }

    @And("create a new shipment")
    public void createANewShipment()  throws InterruptedException{
        upsMain.createAShipment();
    }


    @When("I submit the form")
    public void iSubmitTheForm() throws InterruptedException {
        shipment.submitTheForm();
        Thread.sleep(9000);
    }

    @Then("I verify that data address is {string}")
    public void iVerifyThatDataAddressIs(String expectedAddress) throws InterruptedException {
        String actualAddress = shipment.getTextFromSummaryAddress();
        assertThat(actualAddress).containsIgnoringCase(expectedAddress);
    }

    @When("I fill out country {string} name {string} email {string} and phone {string}")
    public void iFillOutCountryNameEmailAndPhone(String country, String name, String email, String phone) throws InterruptedException {
        shipment.fillOutRequiredFields(country, name,  email, phone);
    }

    @When("I cancel the form")
    public void iCancelTheForm() throws InterruptedException {
        shipment.cancelTheForm();
    }

    @Then("I verify that form resets")
    public void iVerifyThatFormResets() throws InterruptedException {
        assertThat(shipment.isShipFromPageHeaderPresent()).isTrue();

    }



    @And("I fill out address as {string}, zipCode {string} city {string} state as {string}")
    public void iFillOutAddressAsZipCodeCityStateAs(String address, String zipCode, String city, String state) throws InterruptedException {
        shipment.fillOutAddress(address, zipCode, city, state);
    }
}
