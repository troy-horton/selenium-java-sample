package pageengine;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pagefactory.HomePage;

//contains asserts for home page
public class HomePageAsserts {
	
	WebDriver driver;
	HomePage objHomePage;
	
	 public HomePageAsserts(WebDriver driver, HomePage objHomePage){
		 this.driver = driver;
		 this.objHomePage = objHomePage;
		 
	 }
	//assert that apple logo exists and is rendered
	  public void assertLogo(){
		  
	      Boolean imageLoaded = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", objHomePage.appleLogo());
	  }
	  
	  //assert that the "Why Apple" header link exists and that the text is correct
	  public void assertHeaderLinks(){
		  
		  WebElement why_appleLink = objHomePage.why_appleLink();
		  String bodyText = why_appleLink.getText();
		  Assert.assertEquals(true, bodyText.contains("Why Apple"));
		  Assert.assertEquals(true, why_appleLink.isDisplayed());	  
		  
	  }
	  //assert that the home page title is correct
	  public void assertTitle(){
		  
	      (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver d) {
	              return d.getTitle().toLowerCase().startsWith("all-inclusive vacations | america’s #1 tour operator | apple vacations");
	          }
	      });
	      
	  }

}
