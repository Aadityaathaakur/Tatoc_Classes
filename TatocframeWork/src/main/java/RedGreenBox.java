import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import UtilPackage.LocatorsCall;


public class RedGreenBox {
	static WebDriver driver=BrowserDetails.driver;
	
	 static LocatorsCall lc= new LocatorsCall(driver);
	
	public static String RedBox() {
		
	
	   // driver.findElement(By.className("redbox")).click();
		
		lc.getWebElementsTag("redboxClass").click();
	    return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
	   
	}
 
	public static  String greenBox() {
	  
	driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
   
    // driver.findElement(By.className("greenbox")).click();
	lc.getWebElementsTag("greenBoxCheck").click();
	
     return driver.getTitle();
}

}
