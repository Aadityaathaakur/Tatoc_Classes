import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAll {
	String mainWindow;
	String expectedWebpageUrl;
	WebElement element;
	WebDriver driver;
	RedGreenBox rb;
	TatocBasic tb;
	framedungeon fd;
	DragAround da;
	LauchPopupMenu lp;
	CookiePage cp;
	 @BeforeTest
	 public void launch(){
		 System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chromedriver");
			driver = (WebDriver) new ChromeDriver();
			driver.get("http://10.0.1.86//tatoc");
		 	mainWindow = driver.getWindowHandle();
		 	rb=new RedGreenBox(driver); 
			tb=new TatocBasic(driver);
			fd= new framedungeon(driver);
			da= new DragAround(driver);
			lp= new LauchPopupMenu(driver);
			cp= new CookiePage(driver);
	 }
	 
	 @Test 
	 public void BasicBox()
	 {
	tb.basicCource();
	 }
	 
	 @Test (dependsOnMethods = {"BasicBox"})
	 public void testRedBox()
	 {
		 //rb.greenBox();
		 rb.RedBox();
	 }
	 @Test (dependsOnMethods = {"testRedBox"})
	 public void testGreenBox()
	 {
		 rb.greenBox();
		
	 }
	 
	 @Test (dependsOnMethods = {"testGreenBox"})
	 public void click_withoutrepaint()
	 {//driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		 fd.click_without_repaint();
		
	 }
	 @Test (dependsOnMethods = {"click_withoutrepaint"})
	 public void click_after_repaint()
	 {driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		 fd.proceed_after_repaint();
		
	 }
	 
	 @Test (dependsOnMethods = {"click_after_repaint"})
	 public void drag_And_drop_onposition()
	 {//driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
		 da.dragAnddrop();
		
	 }
	 @Test(dependsOnMethods = {"drag_And_drop_onposition"})
	    public void launchWithoutPopUpPage() {
		 lp.launchwithoutpopupClick();
	 }
	 @Test(dependsOnMethods = {"launchWithoutPopUpPage"})
	    public void launchPopUpPage() {
		 driver.get("http://10.0.1.86/tatoc/basic/windows");
		 lp.launchPopUp();
	 }
	 @Test(dependsOnMethods = {"launchPopUpPage"})
	    public void cookieAddTest() {
		
		 cp.cookieAdd();
	 }
	 @AfterClass
		public void closebrowser(){
			driver.quit();
			
		}
	 
}
