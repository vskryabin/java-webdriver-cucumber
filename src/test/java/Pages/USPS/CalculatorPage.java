package Pages.USPS;

import Pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends Page {

    @FindBy(xpath = "//select[@id='CountryID']")
    private WebElement country;
    @FindBy(xpath = "//input[@value='Postcard']")
    private WebElement postcard;
    @FindBy(xpath = "//input[@id='quantity-0']")
    private WebElement quantityField;
    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;
    @FindBy(xpath = "//div[@id='cost-0']")
    private WebElement cost;

    public void selectCountryAndPackage(String country, String option) throws InterruptedException {
        selectDropdown(country, this.country);
        getByXpath("//input[@type='submit']/..//label[contains(text(),'"+option+"')]").click();
    }

    public void fillOutQuantityField(String qtn) throws InterruptedException {
        quantityField.sendKeys(qtn);
        click(calculateButton);
    }

    public String getCost() throws InterruptedException {
        return cost.getText();
    }
}
