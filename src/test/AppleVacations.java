package test;

import org.testng.annotations.Test;
import pagefactory.HomePage;
import pageengine.HomePageAsserts;
import pageengine.HomePageEngine;
import pageengine.SearchResultsAsserts;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class AppleVacations {
	
	WebDriver driver;
	Setup setup;
	HomePage objHomePage;
	HomePageEngine objHomePageEngine;
	HomePageAsserts objHomePageAsserts;
	SearchResultsAsserts objSearchResultsAsserts;
	FormData fd;
	
  @BeforeSuite(alwaysRun=true)
  public void launchBrowser() {
	  
	  Setup setup = new Setup();
	  setup.DefineBrowser("chrome");
	  driver = setup.driver;
	  fd = new FormData();
	  objHomePage = new HomePage(driver);
	  objHomePageEngine = new HomePageEngine(driver, objHomePage,fd);
	  objHomePageAsserts = new HomePageAsserts(driver, objHomePage);
	  objSearchResultsAsserts =  new SearchResultsAsserts(driver, objHomePage);
	  
  }
	//launch site
  @Test
  public void launchSite() {
	  objHomePageEngine.launchSite();
  }
  
  //click x on overlay window to close
  @Test
  public void clickOverlayWindow(){
	  
	  objHomePage.overlayWindowObject().click();  
  }
  
  //assert logo exists
  @Test
  public void assertLogo(){
	  
	  objHomePageAsserts.assertLogo();
	  
  }
  
  //assert header links
  @Test
  public void assertHeaderLinks(){
	  
	  objHomePageAsserts.assertHeaderLinks();
	  
  }
  
  //assert page title for home page
  @Test  
  public void assertPageTitle(){
	  
	  objHomePageAsserts.assertTitle();
	  
  }
  
  //fill in departing city text box and choose dynamic drop down option
  @Test
  public void sendDepartingCity() throws InterruptedException{

	  objHomePageEngine.departingCity();

  }
  
  //fill in arriving city text box and choose dynamic drop down option
  @Test
  public void sendArrivingCity() throws InterruptedException{

	  objHomePageEngine.arrivingCity();

  }
  
  //fill in departing date text box, ignoring calendar selector
  @Test
  public void sendDepartingDate() throws InterruptedException{
		
	  objHomePageEngine.departingDate();

  }
  //fill in returning date text box, ignoring calendar selector
  @Test
  public void sendReturningDate() throws InterruptedException{

	  objHomePageEngine.returningDate();
  
  }
  
  //click search now button to initiate search
  @Test
  public void clickSearchNow() throws InterruptedException{
	  
	  	objHomePageEngine.searchNow();

  }
  
  //assert that results page title is correct
  @Test
  public void assertSearchResultPageTitle() throws InterruptedException{

	  	objSearchResultsAsserts.assertSearchResultsTitle();

  }
  
  //shut down browser(s) and end test
  @AfterSuite(alwaysRun=true)
  public void destroyBrowsers() {
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {

		e.printStackTrace();
	}
	  driver.quit();
  }

}
