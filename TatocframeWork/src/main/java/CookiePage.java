import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import UtilPackage.LocatorsCall;

public class CookiePage {
	static WebDriver driver=BrowserDetails.driver;;
	static LocatorsCall lc= new LocatorsCall(driver);
	

	public static String  proceed_without_adding(){
	
		lc.getWebElementsTag("proceedCookie").click();
		
		return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
	    
	}
	
    public static String cookieAdd() {
    	driver.get("http://10.0.1.86/tatoc/basic/cookie");
    	//driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();
    	lc.getWebElementsTag("generateToken").click();
    
    	//String Tokenvalue = driver.findElement(By.xpath("//*[@id='token']")).getText();
    	String Tokenvalue = lc.getWebElementsTag("TokenValue").getText();
     Tokenvalue = (Tokenvalue.substring(7));
    System.out.println(Tokenvalue);
    //adding cookie
    Cookie ck = new Cookie("Token", Tokenvalue);
    driver.manage().addCookie(ck);
   // driver.findElements(By.cssSelector("a")).get(1).click();
	lc.getWebElementsTag("proceedCookie").click();
    return driver.getTitle();
	}
}
