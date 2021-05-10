package Pages.UPS;

import Pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsMainPage extends Page {
    public UpsMainPage() {
    }

    @FindBy(xpath = "//a[@id='ups-menuLinks2']")
    private WebElement shipping;
    @FindBy(xpath = "//div[@id='ups-menuPanel2']//*[contains(text(),'Create a Shipment:')]")
    private WebElement createShipment;

    public void openShippingPage() throws InterruptedException {
        click(shipping);
    }

    public void createAShipment() throws InterruptedException {
        click(createShipment);
    }
}
