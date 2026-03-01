package Com.Demoworkshop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.HomePage;
import Com.DemoWebShop_POM.LoginPage;
import Com.DemoWebShop_POM.WelcomePage;

public class BaseTest {

	public WebDriver driver;

	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public FileUtility fileutility = new FileUtility();
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public HomePage homepage;
	public WebDriverUtility webdriverutility = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Database conncted");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Report Started");

		spark = new ExtentSparkReporter(frameWorkConstants.reportsPath);
		report = new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("WebShop");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Launch Browser");

		String browser = fileutility.readDataFromPropertyFile("browserName");
		String baseUrl = fileutility.readDataFromPropertyFile("url");
		
//		String baseUrl = System.getProperty("url");
//		String browser = System.getProperty("browserName");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Enter the vaild browser");
		}

		sDriver = driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(baseUrl);

	}

	@BeforeMethod
	public void beforeMethode() throws IOException {
		System.out.println("Login");
		
//        webdriverutility.error(driver);
		welcomepage = new WelcomePage(driver);
		welcomepage.getLoginBtn().click();

		loginpage = new LoginPage(driver);
		loginpage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginpage.getLoginBtn().click();

		homepage = new HomePage(driver);

	}

	@AfterMethod
	public void afterMethode() {
		System.out.println("Logout");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("Close Browser");

		Thread.sleep(2000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Reports Ended");
		report.flush();
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("Database Dissconnected");
	}

}
