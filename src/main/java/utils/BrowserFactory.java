package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver getDriver(String browser, String headless) {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().browserVersion("124.0.6367.158").setup();
			// Initialize ChromeDriver
			ChromeOptions options = new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if (headless.equalsIgnoreCase("true")) {
				options.setHeadless(true);
			}
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("ie")) {
			// Specify Edge version explicitly
			WebDriverManager.edgedriver().browserVersion("92.0.902.84").setup();
			EdgeOptions options = new EdgeOptions();

			if (headless.equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}
			// Initialize EdgeDriver
			driver = new EdgeDriver(options);
		}

		return driver;
	}
}
