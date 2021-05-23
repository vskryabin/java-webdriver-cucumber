package Pages.ICDPackage;

import Pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ICDMainPage extends Page {
    public ICDMainPage() {
        setUrl("https://icdportal.com/");
    }

    @FindBy(xpath = "//span[contains(text(),'Request a Demo')]")
    private WebElement requestDemoBtn;
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//ul[@id='mega-menu-primary']")
    private WebElement menuBar;
    @FindBy(xpath = "//a[contains(text(),'Get Started Today')]")
    private WebElement getStartedTodayBtn;
    @FindBy(xpath = "//a[contains(text(),'Acknowledge')]")
    private WebElement acceptCookiesBtn;
    @FindBy(xpath = "//div[@id='mega-menu-wrap-primary']//*[contains(text(),'Why ICD')]")
    private WebElement WhyIcdBtn;
    @FindBy(xpath = "//div[@id='mega-menu-wrap-primary']//*[contains(text(),'ICD Portal')]")
    private WebElement icdPortal;
    @FindBy(xpath = "//div[@id='mega-menu-wrap-primary']//*[contains(text(),'ICD Portal')]")
    private WebElement resources;
    @FindBy(xpath = "//div[@id='mega-menu-wrap-primary']//*[contains(text(),'About')]")
    private WebElement about;
    @FindBy(xpath = "//span[contains(text(),'Investing')]")
    private WebElement investingPageBtn;
    @FindBy(xpath = "//h2[contains(text(),'Investment products')]")
    private WebElement investmentProductsHeader;
    @FindBy(xpath = "//h6[contains(text(),'Money market funds')]")
    private WebElement moneyMarketFundsBtn;
    @FindBy(xpath = "//section[@id='sectioblock254es11']")
    private WebElement listOfCurrencies;
    @FindBy(xpath = "//a[contains(text(),'BACK TO INVESTMENTS')]")
    private WebElement list;

    public String getListOfCurrencies() throws InterruptedException {
        return listOfCurrencies.getText();
    }

    public void goToMoneyMarketFundsPage() throws InterruptedException {
        click(moneyMarketFundsBtn);
    }

    public String getInvestmentProductsHeaderTxt() throws InterruptedException {
        return investmentProductsHeader.getText();
    }

    public void goToInvestingPage() throws InterruptedException {
        moveToElement(icdPortal);
        click(investingPageBtn);
    }

    public void acceptTheCookies() throws InterruptedException {
        click(acceptCookiesBtn);
    }

    public boolean verifyThatPageWasSubmitted() throws InterruptedException {
        waitForVisible(getStartedTodayBtn);
        if(getStartedTodayBtn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void openRequestDemoPage() throws InterruptedException {
        click(requestDemoBtn);
    }

}
