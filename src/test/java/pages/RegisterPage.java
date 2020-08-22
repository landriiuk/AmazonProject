package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//div[@id='auth-customerName-missing-alert']")
    private WebElement alertName;
    @FindBy(xpath = "//div[@id='auth-email-missing-alert']")
    private WebElement alertEmail;

    @FindBy(xpath = "//div[@id='auth-password-missing-alert']")
    private WebElement alertPassword;

    @FindBy(xpath = "//span[@class='a-button-inner']")
    private WebElement buttonCreateNewAccount;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCreateNewAccount() {
        buttonCreateNewAccount.click();
    }

    public boolean isAlertNameDisplayed() {
        implicitWait(10);
        return alertName.isDisplayed();

    }

    public boolean isAlertEmailDisplayed() {
        implicitWait(10);
        return alertEmail.isDisplayed();
    }

    public boolean isAlertPasswordDisplayed() {
        return alertPassword.isDisplayed();
    }
}
