package definitions;

import Pages.USPS.CalculatorPage;
import Pages.USPS.UspsMain;
import Pages.USPS.postalStorePage;
import Pages.USPS.ZipCodePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;

import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class uspsStepDef {
    UspsMain uspsMain = new UspsMain();
    postalStorePage postal = new postalStorePage();
    ZipCodePage zipCode = new ZipCodePage();
    CalculatorPage calculator = new CalculatorPage();


    @And("I sort by {string} oop")
    public void iSortByOop(String txt) throws InterruptedException {
        postal.selectPriceLowTOHigh();
    }


    @Then("I verify that {string} is cheapest oop")
    public void iVerifyThatIsCheapestOop(String expected) throws ParseException {
        boolean isFound = new postalStorePage().isCheapestItem(expected);
        assertThat(isFound).isTrue();
    }

    @When("I go to stamps oop")
    public void iGoToStampsOop() throws InterruptedException{
        uspsMain.openStampsPage();
    }

    @When("I go to lookup zip by address")
    public void iGoToLookupZipByAddress() throws InterruptedException {
    uspsMain.goToLookUpByZipCode();
    }

    @When("I fill out street as {string} city {string} state {string}")
    public void iFillOutStreetAsCityState(String address, String city, String state) throws InterruptedException {
        zipCode.fillOutAddress(address, city, state);
    }

    @Then("result must contain {string} zip code")
    public void resultMustContainZipCode(String expectedZip) throws InterruptedException {

        String actualZip = zipCode.getFirstZipCodeResult();
        assertThat(actualZip).containsIgnoringCase(expectedZip);
    }

    @When("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
    uspsMain.goToTheSelectedPage(page);
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String option) throws InterruptedException{
        calculator.selectCountryAndPackage(country, option);
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String qtn) throws InterruptedException{
        calculator.fillOutQuantityField(qtn);
    }

    @Then("I validate the cost is {string}")
    public void iValidateTheCostIs(String expectedCost) throws InterruptedException {
        String actualCost = calculator.getCost();
        assertThat(actualCost).isEqualTo(expectedCost);
    }

    @When("I go to {string} oop")
    public void iGoToOop(String arg0) throws InterruptedException {
        uspsMain.goToTheBoxesPage();
    }


    @And("I verify that media banner is present")
    public void iVerifyThatMediaBannerIsPresent() throws InterruptedException{
        assertThat(postal.isMediaBannerPresent()).isTrue();
    }

    @Then("I verify that {string} is present on the page")
    public void iVerifyThatIsPresentOnThePage(String expectedTxt) throws InterruptedException {
    String actualTxt = postal.getTxtFromSearchResults();
    assertThat(actualTxt).containsIgnoringCase(expectedTxt);
    }

    @And("I search for {string} in store oop")
    public void iSearchForInStoreOop(String item) throws InterruptedException {
        postal.searchingForItems(item);
    }

    @Then("I verify that {string} is present")
    public void iVerifyThatIsPresent(String expectedTxt) throws InterruptedException {
        String actualTxt = postal.getTxtFromFirstResult();
        assertThat(actualTxt).containsIgnoringCase(expectedTxt);
    }
}
