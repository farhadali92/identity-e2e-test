package uk.gov.dvla.identity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.gov.dvla.identity.util.WebDriverUtils;

import java.util.List;

public class ConfirmVehiclePage {

    @FindBy(xpath = "//li[@class ='list-summary-item']")
    private List<WebElement> vehicleDetails;

    @FindBy(xpath = "//span[normalize-space()='Registration number']/following-sibling::span")
    private WebElement vehicleRegNumber;

    @FindBy(xpath = "//span[normalize-space()='Make']/following-sibling::span/strong")
    private WebElement vehicleMake;

    @FindBy(xpath = "//span[normalize-space()='Colour']/following-sibling::span/strong")
    private WebElement vehicleColour;

    @FindBy(id = "Correct_False")
    private WebElement noSearchAgainRadioButton;

    @FindBy(xpath = "//button[@name = 'Continue']")
    private WebElement continueButton;

    private WebDriver driver;

    public ConfirmVehiclePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber.getText();
    }

    public String getVehicleMake() {
        return vehicleMake.getText();
    }

    public String getVehicleColour() {
        return vehicleColour.getText();
    }

    public VehicleInquiryPage restartSearch() {
        noSearchAgainRadioButton.click();
        continueButton.click();
        return new VehicleInquiryPage(driver);
    }

}