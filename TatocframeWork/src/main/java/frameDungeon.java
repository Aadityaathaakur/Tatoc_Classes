import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import UtilPackage.LocatorsCall;

public class frameDungeon {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorsCall lc= new LocatorsCall(driver);
		
		public static String  click_without_repaint(){
			System.out.println("dr "+driver);
			driver.switchTo().frame("main");
		
			// driver.findElement(By.xpath("/html/body/center/a[2]")).click();
			lc.getWebElementsTag("withoutRepaint").click();
			
			return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
		    
		}
		
public static String proceed_after_repaint(){
	driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
	   
			driver.switchTo().frame(0);
			
			//String box1 = driver.findElement(By.id("answer")).getAttribute("class");
			String box1 =lc.getWebElementsTag("box1Save").getAttribute("class");
			while(true){
				//driver.findElement(By.xpath("/html/body/center/a[1]")).click();
				lc.getWebElementsTag("nextFrame").click();
				
				driver.switchTo().frame("child");
				//String box2 = driver.findElement(By.id("answer")).getAttribute("class");
				String box2 =lc.getWebElementsTag("box2Save").getAttribute("class");
				driver.switchTo().parentFrame();
				if(box1.equals(box2))
				{
				//driver.findElement(By.xpath("/html/body/center/a[2]")).click();
					lc.getWebElementsTag("proceedDungeon").click();
				break;
				}
			}
			return driver.getTitle();
			
			
		}
}
