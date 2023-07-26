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

import dataDriven.dataDriven;

import extentReport.BaseTestBrokenLinkImage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.classic.methods.HttpGet;

public class BrokenLinkMP extends BaseTestBrokenLinkImage {
	public ExtentTest extentTest;

	dataDriven d = new dataDriven();

	// 1. Homepage
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksHomepage() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ArrayList TS01 = d.getData("01TS01", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS01.get(5)));
		testBrokenLinks(mylinks);
	}

	// 2. Benefits -Benefits
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksBenefits() throws InterruptedException, IOException {
		ArrayList TS01 = d.getData("02TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		ArrayList TS02= d.getData("02TS02", "BrokenLinkTC");
		WebElement benefitsSubMenu = driver.findElement(
				By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitsSubMenu);
		
		Thread.sleep(10000);
		ArrayList TS03= d.getData("02TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 3. Benefits -Pharmacy and Prescriptions
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksPharmacyAndPrescp() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("03TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		Thread.sleep(5000);
		
		ArrayList TS02= d.getData("03TS02", "BrokenLinkTC");
		WebElement pharmacyMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pharmacyMenu);

		Thread.sleep(10000);
		ArrayList TS03= d.getData("03TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 4. Benefits -ID Card
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksIDCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("04TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("04TS02", "BrokenLinkTC");
		WebElement idCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", idCardMenu);
	
		Thread.sleep(10000);
		ArrayList TS03= d.getData("04TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 5. Benefits -OTC Benefits
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksOTCBenefits() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("05TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("05TS02", "BrokenLinkTC");
		WebElement otcBenefitsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", otcBenefitsMenu);
		Thread.sleep(10000);

		ArrayList TS03= d.getData("05TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}
	// 6. Benefits - Flex Card
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksFlexCard() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("06TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();
		
		ArrayList TS02= d.getData("06TS02", "BrokenLinkTC");
		WebElement flexCardMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", flexCardMenu);
		Thread.sleep(5000);
		
		ArrayList TS03= d.getData("06TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}
	
	// 7. Benefits -Rewards
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksReward() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("07TS01", "BrokenLinkTC");
		WebElement benefitsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("07TS02", "BrokenLinkTC");
		WebElement rewardsMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", rewardsMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("07TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 8. Benefits -Plan History
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksPlanHistory() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("08TS01", "BrokenLinkTC");
		WebElement benefitsMenu =  driver.findElement(By.xpath((String) TS01.get(5)));
		benefitsMenu.click();

		ArrayList TS02= d.getData("08TS02", "BrokenLinkTC");
		WebElement planHistoryMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", planHistoryMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("08TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 9. My Care -My PCP
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksMyPCP() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("09TS01", "BrokenLinkTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("09TS02", "BrokenLinkTC");
		WebElement myPCPMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPCPMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("09TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 10. My Care -My Healthplan Care Team
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksMyHealthPlanTeam() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("10TS01", "BrokenLinkTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();
		
		ArrayList TS02= d.getData("10TS02", "BrokenLinkTC");
		WebElement myHealthPlanTeamMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myHealthPlanTeamMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("10TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 11. My Care -Service Authorizations
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksServiceAuthorizations() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("11TS01", "BrokenLinkTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("11TS02", "BrokenLinkTC");
		WebElement serviceAuth = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", serviceAuth);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("11TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 12. My Care -My Medical Supplies and Equipment
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksMyMedicalSuppliesandEquipment() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("12TS01", "BrokenLinkTC");
		WebElement myCareMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myCareMenu.click();

		ArrayList TS02= d.getData("12TS02", "BrokenLinkTC");
		WebElement myMedicalSuppliesandEquipment = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myMedicalSuppliesandEquipment);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("12TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 13. Claims -My Claims
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksClaims() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("13TS01", "BrokenLinkTC");
		WebElement claimsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		claimsMenu.click();

		ArrayList TS02= d.getData("13TS02", "BrokenLinkTC");
		WebElement myClaims = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myClaims);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("13TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 14. Resources -My Plan Resources
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksMyPlanResources() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("14TS01", "BrokenLinkTC");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("14TS02", "BrokenLinkTC");
		WebElement myPlanResources = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myPlanResources);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("14TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 15. Resources -Benefit Partners
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksBenefitPartners() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("15TS01", "BrokenLinkTC");
		WebElement resourcesMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		resourcesMenu.click();

		ArrayList TS02= d.getData("15TS02", "BrokenLinkTC");
		WebElement benefitPartners = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", benefitPartners);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("15TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 16. Grievances & Appeals- Grievances
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksGrievances() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("16TS01", "BrokenLinkTC");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("16TS01", "BrokenLinkTC");
		WebElement grievances = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", grievances);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("16TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 17. Grievances & Appeals- Appeals
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksAppeals() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("17TS01", "BrokenLinkTC");
		WebElement grievancesAppealsMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		grievancesAppealsMenu.click();

		ArrayList TS02= d.getData("17TS02", "BrokenLinkTC");
		WebElement appeals = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", appeals);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("17TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 18. Communication Center
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksComCenter() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("18TS01", "BrokenLinkTC");
		WebElement comCenterMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		comCenterMenu.click();

		ArrayList TS02= d.getData("18TS01", "BrokenLinkTC");
		WebElement comCenterSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", comCenterSubMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("18TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	// 19. My Account
	@Test(groups = "Broken Link Test")
	public void testBrokenLinksMyAccount() throws InterruptedException, IOException {
		ArrayList TS01= d.getData("19TS01", "BrokenLinkTC");
		WebElement myAccountMenu = driver.findElement(By.xpath((String) TS01.get(5)));
		myAccountMenu.click();

		ArrayList TS02= d.getData("19TS02", "BrokenLinkTC");
		WebElement myAccountSubMenu = driver.findElement(By.xpath((String) TS02.get(5)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", myAccountSubMenu);
		Thread.sleep(10000);
		
		ArrayList TS03= d.getData("19TS03", "BrokenLinkTC");
		List<WebElement> mylinks = driver.findElements(By.xpath((String) TS03.get(5)));
		testBrokenLinks(mylinks);
	}

	@AfterTest(alwaysRun = true)
	public void tearUp() {
		driver.close();
	}
}
