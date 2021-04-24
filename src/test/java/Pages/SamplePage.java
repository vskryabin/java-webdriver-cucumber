package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage extends Page{
    public SamplePage() { setUrl("http://skryabin.com/webdriver/html/sample.html");}

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
    @FindBy(xpath = "//b[@id='location']")
    private WebElement location;
    @FindBy(xpath = "//b[@id='currentDate']")
    private WebElement date;
    @FindBy(xpath = "//b[@id='currentTime']")
    private WebElement time;


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

    public String getpasswordErrorText() {
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
