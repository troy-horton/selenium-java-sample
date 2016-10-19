package pageengine;

import java.util.concurrent.TimeUnit;
import pagefactory.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

//contains all the asserts for the search results page
public class SearchResultsAsserts {
	WebDriver driver;
	HomePage objHomePage;
	
	 public SearchResultsAsserts(WebDriver driver, HomePage objHomePage){
		 this.driver = driver;
		 this.objHomePage = objHomePage;
		 
	 }
	
	 //asserts the search results page title is correct
	public void assertSearchResultsTitle() throws InterruptedException{
	
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	            return d.getTitle().toLowerCase().startsWith("apple vacations - plan your vacation");
	        }
	    });
		  	TimeUnit.SECONDS.sleep(1);
	}

}
