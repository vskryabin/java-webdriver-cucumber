package Pages.UPS;

import Pages.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateShipment extends Page {
    public CreateShipment() {
    }

    @FindBy(xpath = "//select[@id='origin-cac_country']")
    private WebElement selectCountry;
    @FindBy(xpath = "//input[@id='origin-cac_companyOrName']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']")
    private WebElement address;
    @FindBy(xpath = "//input[@id='origin-cac_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='origin-cac_phone']")
    private WebElement phone;
    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@id='origin_agentSummaryAddressLine']")
    private WebElement summaryAddress;
    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationCancelShipmentButton']")
    private WebElement cancelShipment;
    @FindBy(xpath = "//button[@id='nbsCancelShipmentWarningYes']")
    private WebElement cancelShipmentYesButton;
    @FindBy(xpath = "//h2[contains(text(),'Hello. Where are you shipping from?')]")
    private WebElement shipFromPageHeader;
    @FindBy(xpath = "//span[contains(text(),'Edit Address - Add Suite/Apt')]")
    private WebElement editAddress;
    @FindBy(xpath = "//input[@id='origin-cac_addressLine1']")
    private WebElement addressLineOne;
    @FindBy(xpath = "//input[@id='origin-cac_postalCode']")
    private WebElement zipCode;
    @FindBy(xpath = "//input[@id='origin-cac_city']")
    private WebElement city;
    @FindBy(xpath = "//select[@id='origin-cac_state']")
    private WebElement state;

    // ----- Destination elements
    @FindBy(xpath = "//select[@id='destination-cac_country']")
    private WebElement dCountry;
    @FindBy(xpath = "//input[@id='destination-cac_companyOrName']")
    private WebElement dName;
    @FindBy(xpath = "//input[@id='destination-cac_email']")
    private WebElement dEmail;
    @FindBy(xpath = "//input[@id='destination-cac_phone']")
    private WebElement dPhone;
    @FindBy(xpath = "//input[@id='destination-cac_addressLine1']")
    private WebElement dAddress;





    public void fillOutAddress(String address, String zip, String city, String state) throws InterruptedException {
        click(editAddress);
        addressLineOne.sendKeys(address);
        zipCode.sendKeys(zip);
        this.city.sendKeys(city);
        selectDropdown(state, this.state);
    }

    public boolean isShipFromPageHeaderPresent() throws InterruptedException {
        if(shipFromPageHeader.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void cancelTheForm() throws InterruptedException {
        click(cancelShipment);
        if (cancelShipmentYesButton.isDisplayed()) {
            click(cancelShipmentYesButton);
        }
    }

    public String getTextFromSummaryAddress() throws InterruptedException {
      return summaryAddress.getText();
    }

    public void fillOutRequiredFields(String country, String name, String email, String phone) throws InterruptedException {
    selectDropdown(country, selectCountry);
    this.name.sendKeys(name);
    this.email.sendKeys(email);
    this.phone.sendKeys(phone);
    }

    public void submitTheForm() throws InterruptedException {
        click(continueButton);
    }

}
