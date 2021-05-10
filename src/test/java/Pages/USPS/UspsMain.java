package Pages.USPS;

import Pages.Page;
import cucumber.api.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

import static support.TestContext.getDriver;

public class UspsMain extends Page {
    public UspsMain() {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//*[@id='g-navigation']//a[(text()= 'Shop')]")
    private WebElement shopMenu;
    @FindBy(xpath = "//*[@id='g-navigation']//ul[@role='menu']//li[@class='tool-stamps']//a[(text()='Stamps')]")
    private WebElement stamps;
    @FindBy(xpath = "//body/div[@id='g-navigation']//a[@role='menuitem'][contains(text(),'Quick Tools')]")
    private WebElement quickTools;
    @FindBy(xpath = "//a[@role='menuitem']//p[contains(string(),'ZIP Code')]")
    private WebElement zipCodePage;
    @FindBy(xpath = "//a[@role='menuitem']//p[contains(string(),'Free Boxes')]")
    private WebElement freeBoxes;
    @FindBy(xpath = "//a[contains(text(),'Find by Address')]")
    private WebElement byAddressButton;



    public void goToTheBoxesPage() throws InterruptedException {
        waitForVisible(quickTools);
        moveToElement(quickTools);
        waitForVisible(freeBoxes);
        click(freeBoxes);
    }

    public void goToTheSelectedPage(String page) throws InterruptedException {
        WebElement element = getByXpath("//a[@role='menuitem']//p[contains(string(),'"+page+"')]");
        clickWithJS(element);
    }

    public void openStampsPage() throws InterruptedException {
        waitForVisible(shopMenu);
        moveToElement(shopMenu);
        waitForVisible(stamps);
        click(stamps);
        }


        public void goToLookUpByZipCode() throws InterruptedException {
        moveToElement(quickTools);
        waitForVisible(zipCodePage);
        click(zipCodePage);
        waitForVisible(byAddressButton);
        click(byAddressButton);
        }
    }



