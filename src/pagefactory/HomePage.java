package pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
    WebDriver driver;
 
    public HomePage(WebDriver driver){
    	
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(css="#monetate_lightbox_contentMap > area:nth-child(1)")
    WebElement overlayWindow;
    
    public WebElement overlayWindowObject(){
    	
    	return overlayWindow;
    	
    }
    
    @FindBy(css="#selectedGatewayTemp")
    WebElement departingCity;
    
    public WebElement departingCityObject(){
    	
    	return departingCity;
    	
    }   

    @FindBy(css="#selectedDestinationTemp")
    WebElement arrivingCity;
    
    public WebElement arrivingCityObject(){
    	
    	return arrivingCity;
    	
    }  
    
    @FindBy(css="#goingtodate")
    WebElement departingDate;
    
    public WebElement departingDateObject(){
    	
    	return departingDate;
    	
    } 
    
    @FindBy(css="#returndate")
    WebElement returningDate;
    
    public WebElement returningDateObject(){
    	
    	return returningDate;
    	
    }   
    
    @FindBy(css="#vacationPkgs > div:nth-child(12) > div > a")
    WebElement searchNow;
    
    public WebElement searchNowObject(){
    	
    	return searchNow;
    	
    }     
    
}
