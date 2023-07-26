package extentReport;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.file.UnableSaveSnapshotException;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import dataDriven.dataDriven;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class BaseTestBrokenLinkImage implements ITestListener {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	String myurl = "";
	HttpURLConnection myhuc = null;
	int responseCode = 200;

	@BeforeTest
	public void setup(ITestContext context) throws IOException, InterruptedException {
		dataDriven d = new dataDriven();
		
		extentTest = extentReports.createTest(context.getName());
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Get Login Page
		ArrayList TS02 = d.getData("LI02", "loginSteps");
		String loginPage= "https://vnshealth-crm--fullsbx.sandbox.my.site.com/member/";
		driver.get(loginPage);
		log("The Login Page url is: " + loginPage);

		// Click Login Button
		ArrayList TS03 = d.getData("LI03", "loginSteps");
		WebElement loginBtn = driver.findElement(By.xpath((String) TS03.get(5)));
		loginBtn.click();

		// Click Ok
		ArrayList TS04 = d.getData("LI04", "loginSteps");
		WebElement okBtn = driver.findElement(By.xpath((String) TS04.get(5)));
		okBtn.click();

		// Enter Username
		ArrayList TS05 = d.getData("LI05", "loginSteps");
		//String username = 	"alour2023";
		String username = 	"fkm89720";
		WebElement uname = driver.findElement(By.xpath((String) TS05.get(5)));
		uname.sendKeys(username);

		// Enter Password
		ArrayList TS06 = d.getData("LI06", "loginSteps");
		String password = "Welcome1!";
		WebElement pwd = driver.findElement(By.xpath((String) TS06.get(5)));
		pwd.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click SignOn
		ArrayList TS07 = d.getData("LI07", "loginSteps");
		WebElement signOn = driver.findElement(By.xpath((String) TS07.get(5)));
		signOn.click();
		
		// Enter Password
		ArrayList TS06A = d.getData("LI06", "loginSteps");
		//String password1 = (String) TS06A.get(6);
		WebElement pwd1 = driver.findElement(By.xpath("//input"));
		pwd1.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click SignOn
		ArrayList TS07A = d.getData("LI07", "loginSteps");
		WebElement signOn1 = driver.findElement(By.xpath((String) TS07.get(5)));
		signOn1.click();
		Thread.sleep(10000);

		log("Login is successful with user name : " + username);
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

	@Parameters({ "browserName" })
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("MemberPortalBrokenLinkAndImage.html");
		sparkReporter_all.config().setReportName("Member Portal Broken Link and Image Test Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(m.getName() + " has failed");
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " has passed");
		}

		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}

	public void logCapture(String description, String responseBody) {
		extentReports.createTest(description).log(Status.PASS, responseBody);
		extentReports.flush();
	}

	public void log(String description) {
		// extentTest.log(Status.INFO,description);
		extentTest.log(Status.PASS, description);
	}

	public void testBrokenLinks(List mylinks) throws InterruptedException {
		ArrayList allList = new ArrayList();
		ArrayList emptyLst = new ArrayList();
		ArrayList anotherDomainLst = new ArrayList();
		ArrayList brokenLst = new ArrayList();
		ArrayList myDomainLst = new ArrayList();
		WebDriver driver;
		Thread.sleep(5000);
		System.out.println(mylinks);
		Iterator<WebElement> myit = mylinks.iterator();
		while (myit.hasNext()) {
			myurl = myit.next().getAttribute("href");
			allList.add(myurl);
			System.out.println(myurl);
			if (myurl == null || myurl.isEmpty()) {
				// System.out.println("Empty URL or an Unconfigured URL");
				emptyLst.add(myurl);
				continue;
			}
			if (myurl.contains("https://vnshealth")) {
				myDomainLst.add(myurl);
				continue;
			}

			if (!myurl.contains("https://vnshealth")) {
				anotherDomainLst.add(myurl);
				continue;
			}

			try {
				myhuc = (HttpURLConnection) (new URL(myurl).openConnection());
				myhuc.setRequestMethod("HEAD");
				myhuc.connect();
				responseCode = myhuc.getResponseCode();

				if (responseCode >= 400) {
					System.out.println(myurl + " This link is broken");

					brokenLst.add(myurl);
					System.out.println("The broken link response code is:" + responseCode);

				} else {
					// System.out.println(myurl + " This link is valid");
				}
				// System.out.println("The response code is:"+responseCode);
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		log("There are " + allList.size() + " urls in the page under test");
		// allList.forEach(t -> log((String) t));
		System.out.println(allList.size());
		System.out.println(allList);
		log("*******************************************************");

		log("A total of " + myDomainLst.size() + " urls in the page are from the same domain");
		log("The urls from same domain are listed below:");
		myDomainLst.forEach(t -> log((String) t));

		log("*******************************************************");
		log("A total of " + anotherDomainLst.size() + " urls in the page are from other domains");
		log("The urls from other domains are listed below:");
		anotherDomainLst.forEach(t -> log((String) t));

		log("*******************************************************");
		log("A total of " + emptyLst.size() + " urls are empty or unconfigured");
		log("The empty urls or unconfigured urls are listed below:");
		emptyLst.forEach(t -> log((String) t));

		log("*******************************************************");
		log("A total of " + brokenLst.size() + " links are broken");
		log("The broken links are listed below:");
		brokenLst.forEach(t -> log((String) t));

	}

	public void testBrokenImages() {
		Integer iBrokenImageCount = 0;

		String status = "passed";
		try {
			iBrokenImageCount = 0;
			List<WebElement> image_list = driver.findElements(By.xpath("//img"));

			// System.out.println("The page under test has " + image_list.size() + "
			// image/s");
			log("The page under test has " + image_list.size() + " image/s");
			for (WebElement img : image_list) {
				if (img != null) {
					CloseableHttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(img.getAttribute("src"));
					CloseableHttpResponse response = client.execute(request);

					if (response.getCode() != 200) {
						// System.out.println(img.getAttribute("outerHTML") + " is broken.");
						log("The broken image is :" + img.getAttribute("outerHTML"));
						iBrokenImageCount++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failed";
			// System.out.println(e.getMessage());
		}
		status = "passed";
		// System.out.println("The page " + "has " + iBrokenImageCount + " broken
		// image/s");
		log("The page " + "has " + iBrokenImageCount + " broken image/s");
	}
	
	public String captureScreenshot(String screenShotName) throws IOException {
//		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String screenshotpath = "./Screenshots/" + screenShotName;
//		File dest = new File(screenshotpath);
//		FileUtils.copyFile(sourceFile, dest);
//		return screenshotpath;

		// Ashot working script
//		Files.createDirectories(Paths.get(System.getProperty("user.dir")+"/Screenshots/"));
//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.50f),5000)).takeScreenshot(driver);
//		String dest = "/Screenshots/" + screenShotName;
//		ImageIO.write(screenshot.getImage(), "PNG", new File(dest));
//		return dest;

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
