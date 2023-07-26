package allTabsMemberPortal;
import static org.testng.Assert.assertEquals;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import dataDriven.dataDrivenAT;
import extentReport.BaseTestAllTabs;
import extentReport.BaseTestBrokenLinkImage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllTabsScreenshot extends BaseTestAllTabs {
	dataDrivenAT d = new dataDrivenAT();

	// 1. Homepage
	@Test(priority = 1)
	public void Homepage() throws InterruptedException, IOException {

		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Homepage",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Homepage" + ".jpg")).build());
	}

	// 2. Benefits -Benefits
	@Test(groups = "1. Benefits", priority = 2)
	public void Benefits() throws InterruptedException, IOException {
		ArrayList TS01 = d.getData("02TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		ArrayList TS02= d.getData("02TS02", "AllTabsTS");
		WebElement benefitsSubMenu = driver.findElement(
				By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitsSubMenu);
	
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Benefits Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Benefits" + ".jpg")).build());
	}

	// 3. Benefits -Pharmacy and Prescriptions
	@Test(groups = "1. Benefits", priority = 3)
	public void PharmacyAndPrescp() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("03TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		
		ArrayList TS02= d.getData("03TS02", "AllTabsTS");
		WebElement pharmacyMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pharmacyMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Pharmacy and Prescriptions Page", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("Pharmacy and Prescriptions" + ".jpg")).build());

	}

	// 4. Benefits -ID Card
	@Test(groups = "1. Benefits", priority = 4)
	public void IDCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("04TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("04TS02", "AllTabsTS");
		WebElement idCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", idCardMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "ID Card Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("ID Card" + ".jpg")).build());
	}

	// 5. Benefits -OTC Benefits
	@Test(groups = "1. Benefits", priority = 5)
	public void OTCBenefits() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("05TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("05TS02", "AllTabsTS");
		WebElement otcBenefitsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", otcBenefitsMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "OTC Benefits Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("OTC Benefits" + ".jpg")).build());
	}

	// 6. Benefits - Flex Card
	@Test(groups = "1. Benefits", priority = 6)
	public void FlexCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("06TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		
		ArrayList TS02= d.getData("06TS02", "AllTabsTS");
		WebElement flexCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", flexCardMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Flex Card Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Flex Card" + ".jpg")).build());
	}

	// 7. Benefits -Rewards
	@Test(groups = "1. Benefits", priority = 7)
	public void Reward() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("07TS01", "AllTabsTS");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("07TS02", "AllTabsTS");
		WebElement rewardsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", rewardsMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Rewards Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Rewards Page" + ".jpg")).build());
	}

	// 8. Benefits -Plan History
	@Test(groups = "1. Benefits", priority = 8)
	public void PlanHistory() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("08TS01", "AllTabsTS");
		WebElement benefitsMenu =  driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("08TS02", "AllTabsTS");
		WebElement planHistoryMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", planHistoryMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Plan History Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Plan History" + ".jpg")).build());
	}

	// 9. My Care -My PCP
	@Test(groups = "2. My Care", priority = 9)
	public void MyPCP() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("09TS01", "AllTabsTS");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("09TS02", "AllTabsTS");
		WebElement myPCPMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPCPMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My PCP Page",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("My PCP" + ".jpg")).build());
	}

	// 10. My Care -My Healthplan Care Team
	@Test(groups = "2. My Care", priority = 10)
	public void MyHealthPlanTeam() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("10TS01", "AllTabsTS");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();
		
		ArrayList TS02= d.getData("10TS02", "AllTabsTS");
		WebElement myHealthPlanTeamMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myHealthPlanTeamMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My Healthplan Care Team", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("My Healthplan Care Team" + ".jpg")).build());
	}

	// 11. My Care -Service Authorizations
	@Test(groups = "2. My Care", priority = 11)
	public void ServiceAuthorizations() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("11TS01", "AllTabsTS");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("11TS02", "AllTabsTS");
		WebElement serviceAuth = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", serviceAuth);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Service Authorizations", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("Service Authorizations" + ".jpg")).build());
	}

	// 12. My Care -My Medical Supplies and Equipment
	@Test(groups = "2. My Care", priority = 12)
	public void MyMedicalSuppliesandEquipment() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("12TS01", "AllTabsTS");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("12TS02", "AllTabsTS");
		WebElement myMedicalSuppliesandEquipment = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myMedicalSuppliesandEquipment);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My Medical Supplies and Equipment", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("My Medical Supplies and Equipment" + ".jpg")).build());
	}

	// 13. Claims -My Claims
	@Test(groups = "3. Claims", priority = 13)
	public void Claims() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("13TS01", "AllTabsTS");
		WebElement claimsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		claimsMenu.click();

		ArrayList TS02= d.getData("13TS02", "AllTabsTS");
		WebElement myClaims = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myClaims);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My Claims",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("My Claims" + ".jpg")).build());
	}

	// 14. Resources -My Plan Resources
	@Test(groups = "4. Resources", priority = 14)
	public void MyPlanResources() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("14TS01", "AllTabsTS");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("14TS02", "AllTabsTS");
		WebElement myPlanResources = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPlanResources);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My Plan Resources", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("My Plan Resources" + ".jpg")).build());
	}

	// 15. Resources -Benefit Partners
	@Test(groups = "4. Resources", priority = 15)
	public void BenefitPartners() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("15TS01", "AllTabsTS");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("15TS02", "AllTabsTS");
		WebElement benefitPartners = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitPartners);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Benefit Partners",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Benefit Partners" + ".jpg")).build());
	}

	// 16. Grievances & Appeals- Grievances
	@Test(groups = "5. Grievances & Appeals", priority = 16)
	public void Grievances() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("16TS01", "AllTabsTS");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("16TS01", "AllTabsTS");
		WebElement grievances = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", grievances);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Grievances",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Grievances" + ".jpg")).build());
	}

	// 17. Grievances & Appeals- Appeals
	@Test(groups = "5. Grievances & Appeals", priority = 17)
	public void Appeals() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("17TS01", "AllTabsTS");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("17TS02", "AllTabsTS");
		WebElement appeals = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appeals);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Appeals",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Appeals" + ".jpg")).build());
	}

	// 18. Communication Center
	@Test(groups = "6. Communication Center", priority = 18)
	public void ComCenter() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("18TS01", "AllTabsTS");
		WebElement comCenterMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		comCenterMenu.click();

		ArrayList TS02= d.getData("18TS01", "AllTabsTS");
		WebElement comCenterSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", comCenterSubMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Communication Center", MediaEntityBuilder
				.createScreenCaptureFromPath(captureScreenshot("Communication Center" + ".jpg")).build());
	}

	// 19. My Account
	@Test(groups = "7. My Account", priority = 19)
	public void MyAccount() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("19TS01", "AllTabsTS");
		WebElement myAccountMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myAccountMenu.click();

		ArrayList TS02= d.getData("19TS02", "AllTabsTS");
		WebElement myAccountSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myAccountSubMenu);
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "My Account",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("My Account" + ".jpg")).build());
	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
