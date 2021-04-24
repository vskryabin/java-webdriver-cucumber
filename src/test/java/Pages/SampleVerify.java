package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleVerify extends Page{
    public SampleVerify() { setUrl("http://skryabin.com/webdriver/html/sample.html");}

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phone;
    @FindBy(xpath = "//b[@name='gender']")
    private WebElement gender;
    @FindBy(xpath = "//b[@name='contactPersonName']")
    private WebElement contactPersonName;
    @FindBy(xpath = "//b[@name='currentTime']")
    private WebElement currentTime;
    @FindBy(xpath = "//button[@id='return']")
    private WebElement returnButton;
    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//b[@name='address']")
    private WebElement address;
    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;
    @FindBy(xpath = "//b[@name='contactPersonPhone']")
    private WebElement contactPersonPhone;
    @FindBy(xpath = "//b[@name='thirdPartyAgreement']")
    private WebElement thirdPartyAgreement;
    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//b[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;
    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//b[@name='location']")
    private WebElement location;
    @FindBy(xpath = "//b[@name='attachmentName']")
    private WebElement attachmentName;
    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;
    @FindBy(xpath = "//b[@name='carMake']")
    private WebElement carMake;
    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;
    @FindBy(xpath = "//b[@name='currentDate']")
    private WebElement currentDate;




}
