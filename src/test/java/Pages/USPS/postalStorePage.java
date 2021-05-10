package Pages.USPS;

import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class postalStorePage extends Page {

    @FindBy(xpath = "//h2[contains(text(),'Sort by:')]//..//..//div[@class='dropdown-selection align-self-center open']")
    private WebElement sortByDropdown;
    @FindBy(xpath="//div[@class='results-product-info']")
    private List<WebElement> foundItems;
    @FindBy(xpath = "(//div[@class='results-product-info'])[1]")
    private WebElement firstFoundItem;
    @FindBy(xpath = "(//a[text()='Price (Low-High)'])[1]")
    private WebElement priceLowToHigh;
    @FindBy(xpath = "//div[contains(@class,'media-banner')]")
    private WebElement mediaBanner;
    @FindBy(xpath = "//div[@class='row cartridge-viewport']")
    private WebElement searchResults;
    @FindBy(xpath = "//input[@id='store-search']")
    private WebElement searchField;
    @FindBy(xpath = "//*[@class='result-products-holder']//*[@class='results-product-info']")
    private WebElement firstSearchResult;

    public String getTxtFromFirstResult() throws InterruptedException {
        waitForVisible(firstSearchResult);
        return firstSearchResult.getText();
    }

    public void searchingForItems(String item) throws InterruptedException {
        searchField.sendKeys(item);
        searchField.sendKeys(Keys.ENTER);
    }

    public String getTxtFromSearchResults() throws InterruptedException {
        return searchResults.getText();
    }

    public boolean isMediaBannerPresent() throws InterruptedException {
        if(mediaBanner.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void selectPriceLowTOHigh() throws InterruptedException {
        clickWithJS(priceLowToHigh);
    }



    public void sortResultsByTxt(String txt) throws InterruptedException {
        selectDropdown(txt, sortByDropdown);
    }

    public boolean isCheapestItem(String name) throws ParseException {
        for (WebElement item : foundItems) {
            if (item.getText().contains(name)) {
                By priceSelector = By.xpath("//div[@class='results-product-preview-price']");
                String itemPrice = item.findElement(priceSelector).getText();
                String firstFoundPrice = firstFoundItem.findElement(priceSelector).getText();

//                 deal with currency
                NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
                double itemPriceNumber = formatter.parse(itemPrice).doubleValue();
                double firstPriceNumber = formatter.parse(firstFoundPrice).doubleValue();

                return itemPrice.equals(firstFoundPrice);
            }
        }
        return false;
    }
}
