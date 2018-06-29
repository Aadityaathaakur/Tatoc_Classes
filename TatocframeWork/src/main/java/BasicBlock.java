import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import UtilPackage.LocatorsCall;
public class BasicBlock {
	 static WebDriver driver=BrowserDetails.driver;
	
	public static String basicCource() {
		LocatorsCall lc= new LocatorsCall(driver);
				//driver.findElement(By.linkText("Basic Course")).click();
				
				lc.getWebElementsTag("linkTextBasic").click();
				 return driver.getTitle();
  }
}
