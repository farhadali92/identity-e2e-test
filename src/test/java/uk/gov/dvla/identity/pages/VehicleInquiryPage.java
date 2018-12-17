package uk.gov.dvla.identity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.gov.dvla.identity.util.WebDriverUtils;

public class VehicleInquiryPage {

    @FindBy(id = "Vrm")
    private WebElement regNumberTextField;

    @FindBy(xpath = "//button[@name = 'Continue']")
    private WebElement continueButton;

    private WebDriver driver;

    public VehicleInquiryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        WebDriverWait webDriverWait = WebDriverUtils.getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
    }

    public void enterRegistrationNumber(String regNumber){
        regNumberTextField.sendKeys(regNumber);
    }

    public ConfirmVehiclePage clickContinueButton(){
        continueButton.click();
        return new ConfirmVehiclePage(driver);
    }

}