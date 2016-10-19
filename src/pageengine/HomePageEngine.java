package pageengine;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pagefactory.HomePage;
import test.FormData;

//contains all the logic for home page navigation and manipulating objects
public class HomePageEngine {
	
	WebDriver driver;
	HomePage objHomePage;
	FormData fd;
	
	public HomePageEngine(WebDriver driver, HomePage objHomePage, FormData fd){
		this.driver = driver;
		this.objHomePage = objHomePage;
		this.fd = fd;
		fd.Dates();
	}
	
	//launches the home page
    public void launchSite(){
    	
  	  String website = "http://www.applevacations.com/";
  	  driver.get(website);
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  
    }
    //navigates city elements
    private void cityNav(WebElement we,String city) throws InterruptedException{
    	
		Actions Actions = new Actions(driver);
		Actions.moveToElement(we).click().perform();
		we.clear();
		we.sendKeys(city);
		TimeUnit.SECONDS.sleep(1);
		//drop down is hidden so can't use drop down selector :(
		we.sendKeys(Keys.DOWN);
		we.sendKeys(Keys.RETURN);
    	
    }
    
    //fills in departing city text box
    public void departingCity() throws InterruptedException{
    	
  	  WebElement dpc = objHomePage.departingCityObject();
  	  String city = "New York";
  	  cityNav(dpc,city);
    	
    }

    //fills in arriving city text box
    public void arrivingCity() throws InterruptedException{
    	
  	  WebElement avc = objHomePage.arrivingCityObject();
  	  String city = "Mexico-Cancun";
  	  cityNav(avc,city);
  	  
    }
    
    //navigates calendar elements
    private void calendarNav(String date, WebElement we) throws InterruptedException{
    	
		Actions Actions = new Actions(driver);
		Actions.moveToElement(we).click().perform();
		we.clear();
		we.sendKeys(date);
      	TimeUnit.SECONDS.sleep(1);
    }
    
    //fills in departing date text box
    public void departingDate() throws InterruptedException {
	  	
		String startDate = fd.startDateString;
		WebElement dep = objHomePage.departingDateObject();
		calendarNav(startDate,dep);
    	
    }
    //fills in returning date text box
    public void returningDate() throws InterruptedException {
    	
		String endDate = fd.endDateString;   
		WebElement ret = objHomePage.returningDateObject();
		calendarNav(endDate,ret);
    	
    }    
    
    //clicks search now button
    public void searchNow() throws InterruptedException {
    	
	  	WebElement searchNow = objHomePage.searchNowObject();
	    Actions Actions = new Actions(driver);
	    Actions.moveToElement(searchNow).click().perform();
	  	TimeUnit.SECONDS.sleep(1);
	  	
    }
}
