package pageengine;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pagefactory.HomePage;
import test.FormData;

public class HomePageEngine {
	
	WebDriver driver;
	HomePage objHomePage;
	FormData fd;
	
	public HomePageEngine(WebDriver driver, HomePage objHomePage, FormData fd){
		this.driver = driver;
		this.objHomePage = objHomePage;
		this.fd = fd;
	}
	
    public void launchSite(){
  	  String website = "http://www.applevacations.com/";
  	  driver.get(website);
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void departingCity() throws InterruptedException{
    	
  	  WebElement dpc = objHomePage.departingCityObject();
      Actions Actions = new Actions(driver);
      Actions.moveToElement(dpc).click().perform();
      dpc.clear();
      dpc.sendKeys("New York");
  	  TimeUnit.SECONDS.sleep(1);
  	  //drop down is hidden so can't use drop down selector :(
  	  dpc.sendKeys(Keys.DOWN);
  	  dpc.sendKeys(Keys.RETURN);
    	
    }

    public void arrivingCity() throws InterruptedException{
    	
  	  WebElement avc = objHomePage.arrivingCityObject();
      Actions Actions = new Actions(driver);
      Actions.moveToElement(avc).click().perform();
      avc.clear();
      avc.sendKeys("Mexico-Cancun");
      TimeUnit.SECONDS.sleep(1);     
      //drop down is hidden so can't use drop down selector :(
  	  avc.sendKeys(Keys.DOWN);
  	  avc.sendKeys(Keys.RETURN);
  	  
    }
    
    public void departingDate() throws InterruptedException {
    	
	  	fd.FormatDates();
		String startDate = fd.startDateString;
		WebElement dep = objHomePage.departingDateObject();
		Actions Actions = new Actions(driver);
		Actions.moveToElement(dep).click().perform();
		dep.clear();
		dep.sendKeys(startDate);
      	TimeUnit.SECONDS.sleep(1);
    	
    }
    
    public void returningDate() throws InterruptedException {
    	
		fd.FormatDates();
		String endDate = fd.endDateString;   
		WebElement ret = objHomePage.returningDateObject();
		Actions Actions = new Actions(driver);
		Actions.moveToElement(ret).click().perform();
		ret.clear();
		ret.sendKeys(endDate);
		TimeUnit.SECONDS.sleep(1);
    	
    }    
    
    public void searchNow() throws InterruptedException {
    	
	  	WebElement searchNow = objHomePage.searchNowObject();
	    Actions Actions = new Actions(driver);
	    Actions.moveToElement(searchNow).click().perform();
	  	TimeUnit.SECONDS.sleep(1);
	  	
    }
}
