package Pages.UPS;

import Pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsFirstPage extends Page {
    public UpsFirstPage() {
        setUrl("https://www.ups.com/");
    }

    @FindBy(xpath = "//li[contains(string(),'United States - English')]")
    private WebElement languageAndRegion;


    public void selectTheLangAndRegion(String txt) throws InterruptedException {
        WebElement element = getByXpath("//li[contains(string(),'"+txt+"')]");
        element.click();
    }
}
