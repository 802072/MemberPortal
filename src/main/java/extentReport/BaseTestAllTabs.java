package extentReport;

import java.io.*;

import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chromium.HasCdp;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.HasDevTools;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.file.UnableSaveSnapshotException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataDriven.dataDrivenAT;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestAllTabs {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentTest testStepExtentTest;
	dataDrivenAT d = new dataDrivenAT();

	@Parameters("browserName")
	@BeforeTest
	public void setup(ITestContext context, @Optional("chrome") String browserName)
			throws IOException, InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			break;

		}

		extentTest = extentReports.createTest(context.getName());
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName1 = cap.getBrowserName();
		String v = cap.getVersion().toString();

		// extentTest.assignAuthor(author);
		// extentTest.assignDevice(device);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get login page
		ArrayList TS02 = d.getData("LI02", "loginStepsAT");
		//String loginPage = "https://vnshealth-crm--fullsbx.sandbox.my.site.com/member/";
		String loginPage= (String) TS02.get(6);
		driver.get(loginPage);
		Thread.sleep(10000);

		extentTest.log(Status.PASS, "Browser Name= " + browserName1 + ", Browser Version= " + v);
		extentTest.log(Status.PASS, "Get Login Page: URL is " + loginPage,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Loginpage" + ".jpg")).build());

		// Click Login Button
		ArrayList TS03 = d.getData("LI03", "loginStepsAT");
		WebElement loginBtn = driver.findElement(By.xpath((String) TS03.get(5)));
		loginBtn.click();
		extentTest.log(Status.PASS, "Click Login Button",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("loginbutton" + ".jpg")).build());

		// Click Ok
		ArrayList TS04 = d.getData("LI04", "loginStepsAT");
		WebElement okBtn = driver.findElement(By.xpath((String) TS04.get(5)));
		okBtn.click();
		extentTest.log(Status.PASS, "Click OK Button",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("ok" + ".jpg")).build());

		// enter username
		ArrayList TS05 = d.getData("LI05", "loginStepsAT");
		// String username = "alour2023";
		// String username = "fkm89720";
		String username = (String) TS05.get(6);
		WebElement uname = driver.findElement(By.xpath((String) TS05.get(5)));
		uname.sendKeys((String) TS05.get(6));
		extentTest.log(Status.PASS, "Enter Username: " + username,
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("username" + ".jpg")).build());

		// enter password
		ArrayList TS06 = d.getData("LI06", "loginStepsAT");
		WebElement pwd = driver.findElement(By.xpath((String) TS06.get(5)));
		pwd.sendKeys((String) TS06.get(6));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest.log(Status.PASS, "Enter Password",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("password" + ".jpg")).build());

		// login
		ArrayList TS07 = d.getData("LI07", "loginStepsAT");
		WebElement signOn = driver.findElement(By.xpath((String) TS07.get(5)));
		signOn.click();
		extentTest.log(Status.PASS, "Click Sign On",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("signon" + ".jpg")).build());

		// enter password
		WebElement pwd1 = driver.findElement(By.xpath((String) TS06.get(5)));
		pwd1.sendKeys((String) TS06.get(6));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest.log(Status.PASS, "Enter Password",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("password1" + ".jpg")).build());

		// login
		extentTest.log(Status.PASS, "Click Sign On",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("signon1" + ".jpg")).build());
		ArrayList TS07A = d.getData("LI07", "loginStepsAT");
		WebElement signOn1 = driver.findElement(By.xpath((String) TS07.get(5)));
		signOn1.click();
		Thread.sleep(5000);
	}

	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTabsMemberPortal.html");
		sparkReporter_all.config().setReportName("Member Portal Report");
		// Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Environment", "Test Environment");
		// extentReports.setSystemInfo("Browser Name", cap.getBrowserName()+ "
		// "+cap.getVersion());
		// extentReports.setSystemInfo("Environment", "Production Environment");
		// excelWR.createSheet();
	}

	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		// Desktop.getDesktop().browse(new File("ProviderPortalTests.html").toURI());
		// Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		// excelWR.writeIntoExcel();
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotpath = null;
			screenshotpath = captureScreenshot("failTest.jpg");
			extentTest.fail(m.getName() + " has failed");
			extentTest.log(Status.FAIL, result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

		}

		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

//		@AfterTest
//		public void teardown() {
//			driver.quit();
//		}

	public String captureScreenshot(String screenShotName) throws IOException {

		// Shutterbug Working Code
		Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
		BufferedImage image = Shutterbug.shootPage(driver, Capture.FULL, true).getImage();
		String dest = "./screenshots/" + screenShotName;
		writeImage(image, "PNG", new File(dest));
		return dest;
	}

	public static void writeImage(BufferedImage imageFile, String extension, File fileToWriteTo) {
		try {
			ImageIO.write(imageFile, extension, fileToWriteTo);
		} catch (IOException e) {
			throw new UnableSaveSnapshotException(e);
		}
	}

}