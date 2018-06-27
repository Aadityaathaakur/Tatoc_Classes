import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class framedungeon {

		WebElement element;
		WebDriver driver;
		String expectedWebpageUrl;
		public framedungeon(WebDriver driver)
	{
		this.driver=driver;
	}
		public void click_without_repaint(){
			
			this.driver.switchTo().frame("main");
			
			Assert.assertTrue(this.driver.findElement(By.xpath("/html/body/center/a[2]")).isDisplayed());
			this.driver.findElement(By.xpath("/html/body/center/a[2]")).click();
			//this.driver.findElements(By.cssSelector("a")).get(1).click();
			String error=this.driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
		    System.out.println("error="+error);
		    
		    Assert.assertEquals("The page you are looking for does not exist", error, "Not as expected webpage");

		}
		
public void proceed_after_repaint(){
			
			this.driver.switchTo().frame(0);
			String box1 = this.driver.findElement(By.id("answer")).getAttribute("class");
			while(true){
				this.driver.findElement(By.xpath("/html/body/center/a[1]")).click();
				this.driver.switchTo().frame("child");
				String box2 = this.driver.findElement(By.id("answer")).getAttribute("class");
				this.driver.switchTo().parentFrame();
				if(box1.equals(box2))
				{
					this.driver.findElement(By.xpath("/html/body/center/a[2]")).click();
				break;
				}
			}

			expectedWebpageUrl = "http://10.0.1.86/tatoc/basic/drag"; //url of next page
	    Assert.assertEquals(expectedWebpageUrl, driver.getCurrentUrl(),"Not as expected webpage");
			
		}
}
