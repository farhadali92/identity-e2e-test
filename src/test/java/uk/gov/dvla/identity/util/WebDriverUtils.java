package uk.gov.dvla.identity.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	private static final long WEB_DRIVER_WAIT_TIMEOUT = 10;

	private static WebDriver driver;

	public static void initWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void clearCookies() {
		driver.manage().deleteAllCookies();
	}

	public static WebDriver getWebDriver() {
		if (driver == null) {
			initWebDriver();
		}
		return driver;
	}

	public static WebDriverWait getWebDriverWait() {
		if (driver == null) {
			initWebDriver();
		}
		return new WebDriverWait(driver, WEB_DRIVER_WAIT_TIMEOUT);
	}

	public static void quitWebDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}