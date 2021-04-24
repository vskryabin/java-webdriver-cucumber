package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class Page {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public WebElement getByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public void moveToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void waitForVisible(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNotVisible(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }


    public void sendKeys(WebElement element, String text) {
        waitForVisible(element);
        element.sendKeys(text);
    }

    public void selectDropdown(String text, WebElement element) throws InterruptedException {
        waitForClickable(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

}