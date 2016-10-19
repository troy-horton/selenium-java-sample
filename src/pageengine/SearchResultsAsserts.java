package pageengine;

import java.util.concurrent.TimeUnit;
import pagefactory.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsAsserts {
	WebDriver driver;
	HomePage objHomePage;
	
	 public SearchResultsAsserts(WebDriver driver, HomePage objHomePage){
		 this.driver = driver;
		 this.objHomePage = objHomePage;
		 
	 }
	
	public void assertSearchResultsTitle() throws InterruptedException{
	
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	            return d.getTitle().toLowerCase().startsWith("apple vacations - plan your vacation");
	        }
	    });
		  	TimeUnit.SECONDS.sleep(1);
	}

}
