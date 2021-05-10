package Pages.USPS;

import Pages.Page;
import cucumber.api.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZipCodePage extends Page {

    @FindBy(xpath = "//a[@title='byaddress']")
    private WebElement byAddressButton;
    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement addressField;
    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement cityField;
    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;
    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;
    @FindBy(xpath = "(//div[@id='zipByAddressDiv']//p//strong)[1]")
    private WebElement firstZipCodeResult;
    @FindBy(xpath = "//p[@id='street-address']")
    private WebElement streetAddress;

    public String getFirstZipCodeResult() throws InterruptedException {
        return firstZipCodeResult.getText();
    }

    public void fillOutAddress(String address, String city, String state) throws InterruptedException {
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        selectDropdownByValue(state, this.state);
        click(findButton);
        waitForVisible(streetAddress);
    }


}
