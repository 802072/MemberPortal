package brokenLinkAndImageMP;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dataDriven.dataDrivenBLI;

import extentReport.BaseTestBrokenLinkImage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.classic.methods.HttpGet;

public class BrokenImageMP extends BaseTestBrokenLinkImage {
	public ExtentTest extentTest;

	dataDrivenBLI d = new dataDrivenBLI();

	// 1. Homepage
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesHomepage() throws InterruptedException, IOException {
		testBrokenImages();
	}

	// 2. Benefits -Benefits
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesBenefits() throws InterruptedException, IOException {
		ArrayList TS01 = d.getData("02TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		ArrayList TS02= d.getData("02TS02", "BrokenImageTC");
		WebElement benefitsSubMenu = driver.findElement(
				By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitsSubMenu);

		Thread.sleep(5000);
		testBrokenImages();
	}

	// 3. Benefits -Pharmacy and Prescriptions
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesPharmacyAndPrescp() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("03TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		
		ArrayList TS02= d.getData("03TS02", "BrokenImageTC");
		WebElement pharmacyMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pharmacyMenu);

		Thread.sleep(5000);

		testBrokenImages();
	}

	// 4. Benefits -ID Card
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesIDCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("04TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("04TS02", "BrokenImageTC");
		WebElement idCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", idCardMenu);
	
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 5. Benefits -OTC Benefits
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesOTCBenefits() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("05TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("05TS02", "BrokenImageTC");
		WebElement otcBenefitsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", otcBenefitsMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}
	// 6. Benefits - Flex Card
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesFlexCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("06TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		
		ArrayList TS02= d.getData("06TS02", "BrokenImageTC");
		WebElement flexCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", flexCardMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}
	
	// 7. Benefits -Rewards
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesReward() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("07TS01", "BrokenImageTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("07TS02", "BrokenImageTC");
		WebElement rewardsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", rewardsMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 8. Benefits -Plan History
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesPlanHistory() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("08TS01", "BrokenImageTC");
		WebElement benefitsMenu =  driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("08TS02", "BrokenImageTC");
		WebElement planHistoryMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", planHistoryMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 9. My Care -My PCP
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesMyPCP() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("09TS01", "BrokenImageTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("09TS02", "BrokenImageTC");
		WebElement myPCPMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPCPMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 10. My Care -My Healthplan Care Team
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesMyHealthPlanTeam() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("10TS01", "BrokenImageTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();
		
		ArrayList TS02= d.getData("10TS02", "BrokenImageTC");
		WebElement myHealthPlanTeamMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myHealthPlanTeamMenu);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 11. My Care -Service Authorizations
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesServiceAuthorizations() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("11TS01", "BrokenImageTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("11TS02", "BrokenImageTC");
		WebElement serviceAuth = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", serviceAuth);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 12. My Care -My Medical Supplies and Equipment
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesMyMedicalSuppliesandEquipment() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("12TS01", "BrokenImageTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("12TS02", "BrokenImageTC");
		WebElement myMedicalSuppliesandEquipment = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myMedicalSuppliesandEquipment);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 13. Claims -My Claims
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesClaims() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("13TS01", "BrokenImageTC");
		WebElement claimsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		claimsMenu.click();

		ArrayList TS02= d.getData("13TS02", "BrokenImageTC");
		WebElement myClaims = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myClaims);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 14. Resources -My Plan Resources
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesMyPlanResources() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("14TS01", "BrokenImageTC");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("14TS02", "BrokenImageTC");
		WebElement myPlanResources = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPlanResources);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 15. Resources -Benefit Partners
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesBenefitPartners() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("15TS01", "BrokenImageTC");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("15TS02", "BrokenImageTC");
		WebElement benefitPartners = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitPartners);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 16. Grievances & Appeals- Grievances
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesGrievances() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("16TS01", "BrokenImageTC");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("16TS01", "BrokenImageTC");
		WebElement grievances = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", grievances);
		Thread.sleep(5000);
		
		testBrokenImages();
	}

	// 17. Grievances & Appeals- Appeals
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesAppeals() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("17TS01", "BrokenImageTC");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("17TS02", "BrokenImageTC");
		WebElement appeals = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appeals);
		Thread.sleep(5000);

		testBrokenImages();
	}

	// 18. Communication Center
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesComCenter() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("18TS01", "BrokenImageTC");
		WebElement comCenterMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		comCenterMenu.click();

		ArrayList TS02= d.getData("18TS01", "BrokenImageTC");
		WebElement comCenterSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", comCenterSubMenu);
		Thread.sleep(5000);
		
		testBrokenImages();
	}

	// 19. My Account
	@Test(groups = "Broken Image Test")
	public void testBrokenImagesMyAccount() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("19TS01", "BrokenImageTC");
		WebElement myAccountMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myAccountMenu.click();

		ArrayList TS02= d.getData("19TS02", "BrokenImageTC");
		WebElement myAccountSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myAccountSubMenu);
		Thread.sleep(5000);
		
		testBrokenImages();
	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
