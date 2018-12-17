package uk.gov.dvla.identity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.gov.dvla.identity.util.WebDriverUtils;

public class GetVehicleInformationPage {

    @FindBy(xpath = "//a[text()='Start now']")
    private WebElement startNowButton;

    private WebDriver driver;

    public GetVehicleInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(startNowButton));
    }

    public VehicleInquiryPage clickStartNow() {
        startNowButton.click();
        return new VehicleInquiryPage(driver);
    }

}