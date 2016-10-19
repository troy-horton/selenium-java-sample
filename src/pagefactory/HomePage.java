package pagefactory;

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
    
    @FindBy(css="#header_avlogo > a > img")
    WebElement appleLogo;
    
    public WebElement appleLogo(){
    	
    	return appleLogo;
    	
    } 
    
    @FindBy(css="#h_hp_bar > span:nth-child(1) > a")
    WebElement why_appleLink;
    
    public WebElement why_appleLink (){
    	
    	return why_appleLink;
    	
    } 
    
    
    @FindBy(css="#selectedGatewayTemp")
    WebElement departingCity;
    
    public WebElement departingCityObject(){
    	
    	return departingCity;
    	
    }   

    @FindBy(css="#selectedDestinationTemp")
    //@FindBy(css="#selectedDestination")
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
