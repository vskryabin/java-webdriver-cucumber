package Pages.ICDPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

import static support.TestContext.getDriver;

public class IcdDemoPage extends ICDMainPage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement termAndConditionsBox;
    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//h1[contains(text(),'Request a free demo today')]")
    private WebElement header;
    @FindBy(xpath = "//h2[contains(text(),'There was a problem with your submission')]")
    private WebElement demoFormHeader;
    @FindBy(xpath = "//div[@id='validation_message_2_2']")
    private WebElement firstNameError;
    @FindBy(xpath = "//div[@id='validation_message_2_3']")
    private WebElement lastNameError;
    @FindBy(xpath = "//div[@id='validation_message_2_5']")
    private WebElement emailError;
    @FindBy(xpath = "//div[@id='validation_message_2_4']")
    private WebElement companyError;
    @FindBy(xpath = "//a[contains(text(),'terms and conditions')]")
    private WebElement termsAndConditionsBtn;

    // terms & Conditions should be another class
    @FindBy(xpath = "//h1[contains(text(),'Terms & Conditions')]")
    private WebElement termsAndConditionsHeader;
    @FindBy(xpath = "//a[contains(text(),'PRIVACY POLICY')]")
    private WebElement privacyPolicyBtn;

    // should be in privacy policy class
    @FindBy(xpath = "//p//strong//u[contains(text(),'Consent')]")
    private WebElement privacyConsent;

    public void goToThePreviousPage() throws InterruptedException {
        getDriver().navigate().back();
    }

    public String getPrivacyConsentTxt() throws InterruptedException {
        waitForVisible(privacyConsent);
        return privacyConsent.getText();
    }

    public void goToPrivacyPolicy() throws InterruptedException {
        click(privacyPolicyBtn);
    }

    public String getTermsAndConditionsHeaderTxt() throws InterruptedException {
        waitForVisible(termsAndConditionsHeader);
        return termsAndConditionsHeader.getText();
    }

    public void clickTermsAndConditionsBtn() throws InterruptedException {
        waitForClickable(termsAndConditionsBtn);
        click(termsAndConditionsBtn);
    }

    public String getTextFromDemoFormHeader() throws InterruptedException {
        waitForVisible(demoFormHeader);
        return demoFormHeader.getText();
    }

    public String getTxtFromFirstNameError() throws InterruptedException {
        return firstNameError.getText();
    }

    public String getTxtFromLastNameError() throws InterruptedException {
       return lastNameError.getText();
    }

    public String getTxtFromEmailError() throws InterruptedException {
        waitForVisible(emailError);
        return emailError.getText();
    }

    public String getTxtFromCompanyError() throws InterruptedException {
        return companyError.getText();
    }

    public void submitThePage() throws InterruptedException {
        waitForClickable(submitBtn);
        click(submitBtn);
    }

    public void acknowledgeTerms() throws InterruptedException {
        click(termAndConditionsBox);
    }

    public void fillOutInputFields(String field, String txt) throws InterruptedException {
        WebElement element = getByXpath("//label[contains(text(),'"+field+"')]//..//input");
        waitForClickable(element);
        element.sendKeys(txt);
    }

    public void fillOutCommentsField(String field, String txt) throws InterruptedException {
        WebElement element = getByXpath("//label[contains(text(),'"+field+"')]//..//textarea");
        waitForClickable(element);
        element.sendKeys(txt);
    }

    public void fillOutEmailField(String field, String txt) throws InterruptedException {
        WebElement element = getByXpath("//label[contains(text(),'"+field+"')]//..//input");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        element.sendKeys(txt + randomInt +"@gmail.com");
    }

}
