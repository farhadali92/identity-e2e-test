package uk.gov.dvla.identity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import uk.gov.dvla.identity.pages.GetVehicleInformationPage;
import uk.gov.dvla.identity.util.WebDriverUtils;

public abstract class BaseTest {

    private static final String VEHICLE_INFO_FROM_DVLA_URL = "https://www.gov.uk/get-vehicle-information-from-dvla";

    public GetVehicleInformationPage navigateToGetVehicleInformationPage() {
        WebDriver driver = WebDriverUtils.getWebDriver();
        driver.get(VEHICLE_INFO_FROM_DVLA_URL);

        return new GetVehicleInformationPage(driver);
    }

    @BeforeClass
    public static void setUp() {
        WebDriverUtils.initWebDriver();
    }

    @Before
    public void setUpBeforeEachTest() {
        WebDriverUtils.clearCookies();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverUtils.quitWebDriver();
    }

}