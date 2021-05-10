package Pages.Sample;

import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

import static support.TestContext.getDriver;

public class SamplePage extends Page {
    public SamplePage() {
        setUrl("http://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;
    @FindBy(xpath = "//label[@id='username-error']")
    private WebElement usernameError;
    @FindBy(xpath = "//label[@id='email-error']")
    private WebElement emailError;
    @FindBy(xpath = "//label[@id='password-error']")
    private WebElement passwordError;
    @FindBy(xpath = "//label[@id='name-error']")
    private WebElement nameError;
    @FindBy(xpath = "//label[@id='agreedToPrivacyPolicy-error']")
    private WebElement privacyPolicyError;
    @FindBy(xpath = "//label[contains(text(),'Email')]/..//input")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;
    @FindBy(xpath = "//b[@id='location']")
    private WebElement location;
    @FindBy(xpath = "//b[@id='currentDate']")
    private WebElement date;
    @FindBy(xpath = "//b[@id='currentTime']")
    private WebElement time;
    @FindBy(xpath = "//label[@for=\"username\"]//..//input")
    private WebElement usernameField;
    @FindBy(xpath = "//label[contains(text(),'Phone Number')]//..//input")
    private WebElement phoneNumberField;

    // name fields
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;
    @FindBy(xpath = "//div[@id='nameDialog']")
    private WebElement nameMenu;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleNameField;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//div//button//span[contains(text(),'Save')]")
    private WebElement saveButton;
    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement address;
    @FindBy(xpath = "//label[contains(text(),'Country of Origin')]//..//select")
    private WebElement selectCountryField;
    @FindBy(xpath = "//label[contains(text(),'Car Make')]/..//select")
    private WebElement selectCar;
    @FindBy(xpath = "//label[contains(text(),'Allowed to Contact?')]/..//input")
    private WebElement allowToContactCheckBox;
    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyButton;
    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactPersonName;
    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPersonPhone;
    @FindBy(xpath = "//button[contains(text(),'Related documents (click)')]")
    private WebElement relatedDocsButton;
    // Should be another page object class, but I made an exception
    @FindBy(xpath = "//html")
    private WebElement relatedDocumentsPage;
    @FindBy(xpath = "//input[@id='attachment']")
    private WebElement attachment;
    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;


    public boolean isSubmitButtonPresent() throws InterruptedException {
        if(submitButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnAgreedToPrivacyPolicy() {
        click(agreedToPrivacyPolicy);
    }

    public String getTextFromTheAttachment() throws InterruptedException {
       return attachment.getAttribute("value");
    }


    public void chooseFile(String fileName) throws InterruptedException {
        String pathname = null;
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            //  pathname = "/Users/" + System.getProperty("user.name") + "/Documents/Selenium/cucumberProject/src/test/resources/data/attachments/"+fileName+"";
            pathname = System.getProperty("user.dir") + "/src/test/resources/data/attachments/"+fileName+"";
        } else {

            pathname = "/src/test/resources/data/attachments/"+fileName+"";
        }

        getDriver().findElement(By.id("attachment")).sendKeys(pathname);

    }

    public String getTxtFromRelatedDocumentsPage() {
        return relatedDocumentsPage.getText();
    }

    public void clickOnRelatedDocs() throws InterruptedException {
        click(relatedDocsButton);
    }

    public void fillOutContactPersonInfo(String name, String phone) throws InterruptedException {
        getDriver().switchTo().frame(0);
        contactPersonName.sendKeys(name);
        contactPersonPhone.sendKeys(phone);
        getDriver().switchTo().defaultContent();
    }

    public void acceptThirdPartyAgreement() throws InterruptedException {
        click(thirdPartyButton);
        getDriver().switchTo().alert().accept();
    }

    public void fillOutDateOfBirth(String date) throws InterruptedException {
        dateOfBirth.sendKeys(date);
    }

    public void switchAllowToContactCheckBox() throws InterruptedException {
        click(allowToContactCheckBox);
    }

    public void selectCarByTxt(String car) throws InterruptedException {

        selectDropdown(car, selectCar);
    }

    public void selectCountry(String country) throws InterruptedException {
        selectDropdown(country, selectCountryField);
    }

    public void fillOutTheAddress(String txt) {
        address.sendKeys(txt);
    }

    public void selectGender(String gender) {
       getByXpath("//label[contains(text(),'Gender')]//..//*[@value='"+gender+"']").click();
    }

    public void fillOutTheName(String firstName, String middleName, String lastName) {
        click(nameField);
        waitForVisible(nameMenu);
       firstNameField.sendKeys(firstName);
       middleNameField.sendKeys(middleName);
       lastNameField.sendKeys(lastName);
       click(saveButton);
       waitForNotVisible(nameMenu);
    }

    public void fillOutPhoneNumberField(String phone) {
        phoneNumberField.sendKeys(phone);
    }

    public boolean verifyLocationDateAndTimeIsPresent() {
        if(location.isDisplayed() && date.isDisplayed() && time.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyLocationDateAndTimeAreNotPresent() {
        if(location.isDisplayed() && date.isDisplayed() && time.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }

    public void fillOutPassword(String txt) {
        passwordField.sendKeys(txt);
        passwordField.sendKeys(Keys.ENTER);
    }

    public void fillOutConfirmPassword(String txt) {
        confirmPassword.sendKeys(txt);
    }

    public void fillOutUsername(String txt) {
        usernameField.sendKeys(txt);
    }

    public boolean verifyConfirmPasswordFieldIsDisabled() {
        if(confirmPasswordField.isEnabled()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickOnSubmitButton()  {
        click(submitButton);
    }

    public String getUsernameErrorText() {
        waitForVisible(usernameError);
        return usernameError.getText();
    }

    public String getEmailErrorText() {
        waitForVisible(emailError);
        return emailError.getText();
    }

    public String getPasswordErrorText() {
        waitForVisible(passwordError);
        return passwordError.getText();
    }

    public String getNameErrorText() {
        waitForVisible(nameError);
        return nameError.getText();
    }
    public String getPrivacyPolicyErrorTxt() {
        waitForVisible(privacyPolicyError);
        return privacyPolicyError.getText();
    }

    public void fillOutEmailField(String txt) {
        waitForVisible(emailField);
        emailField.sendKeys(txt);
    }

}
