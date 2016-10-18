package test;

import org.testng.annotations.Test;

import pagefactory.HomePage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AppleVacations {
	WebDriver driver;
	Setup setup;
	HomePage objHomePage;
	FormData fd = new FormData();
	
  @BeforeSuite(alwaysRun=true)
  public void launchBrowser() {
	  
	  Setup setup = new Setup();
	  driver = setup.DefineBrowser("chrome");
	  
  }
	
  @Test
  public void launchSite() {
	  driver.get("http://www.applevacations.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void clickOverlayWindow(){
	  objHomePage = new HomePage(driver);
	  objHomePage.overlayWindowObject().click();  
  }
  
  @Test  
  public void assertPageTitle(){
	  
      (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver d) {
              return d.getTitle().toLowerCase().startsWith("all-inclusive vacations | america’s #1 tour operator | apple vacations");
          }
      });
	  
  }
  
  @Test
  public void sendDepartingCity() throws InterruptedException{

	  WebElement dpc = objHomePage.departingCityObject();
      Actions Actions = new Actions(driver);
      Actions.moveToElement(dpc).click().perform();
      dpc.clear();
      dpc.sendKeys("New York");
  	  TimeUnit.SECONDS.sleep(1);
  	  dpc.sendKeys(Keys.DOWN);
  	  dpc.sendKeys(Keys.RETURN);

  }
  
  @Test
  public void sendArrivingCity() throws InterruptedException{

	  WebElement avc = objHomePage.arrivingCityObject();
      Actions Actions = new Actions(driver);
      Actions.moveToElement(avc).click().perform();
      avc.clear();
      avc.sendKeys("Mexico-Cancun/Riviera Maya");
  	  TimeUnit.SECONDS.sleep(1);
  	  avc.sendKeys(Keys.DOWN);
  	  avc.sendKeys(Keys.RETURN);
  }
  
  @Test
  public void sendDepartingDate() throws InterruptedException{
		
	  	fd.FormatDates();
		String startDate = fd.startDateString;
		WebElement dep = objHomePage.departingDateObject();
		Actions Actions = new Actions(driver);
		Actions.moveToElement(dep).click().perform();
		dep.clear();
		dep.sendKeys(startDate);
      	TimeUnit.SECONDS.sleep(1);

  }
  
  @Test
  public void sendReturningDate() throws InterruptedException{

		fd.FormatDates();
		String endDate = fd.endDateString;   
		WebElement ret = objHomePage.returningDateObject();
		Actions Actions = new Actions(driver);
		Actions.moveToElement(ret).click().perform();
		ret.clear();
		ret.sendKeys(endDate);
		TimeUnit.SECONDS.sleep(1);
  
  }
  
  @Test
  public void clickSearchNow() throws InterruptedException{

	  	WebElement searchNow = objHomePage.searchNowObject();
	    Actions Actions = new Actions(driver);
	    Actions.moveToElement(searchNow).click().perform();
	  	TimeUnit.SECONDS.sleep(1);
  }
  
  @Test
  public void assertSearchResultPageTitle() throws InterruptedException{

      (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver d) {
              return d.getTitle().toLowerCase().startsWith("apple vacations - plan your vacation");
          }
      });
	  	TimeUnit.SECONDS.sleep(1);
  }
  
  @AfterSuite(alwaysRun=true)
  public void destroyBrowsers() {
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.quit();
  }

}
