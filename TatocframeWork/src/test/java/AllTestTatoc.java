import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import BrowserDetails;
public class AllTestTatoc {

	WebDriver driver=BrowserDetails.driver;;
	
	@BeforeClass
	public void L(){
		
	}
	
	@Test
	public void Test001_Launch_Browser(){
		String titleName= BrowserDetails.launchBrowser();
		Assert.assertTrue(titleName.contains("Welcome - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	}
	
	@Test
	public void Test002_BasicBlock(){
		String titleName= BasicBlock.basicCource();
		Assert.assertTrue(titleName.contains("Grid Gate - Basic Course - T.A.T.O.C"));
		Reporter.log("Application Lauched successfully | ");
	}
	  @Test
		public void Test003_CheckRedBox(){
			String error= RedGreenBox.RedBox();
			 
			Assert.assertTrue(error.equals("The page you are looking for does not exist"));
			Reporter.log("Application Lauched successfully | ");
		}
	  @Test
	  public void Test004_check_For_Green_Box(){
		  String titleName= RedGreenBox.greenBox();
			Assert.assertTrue(titleName.contains("Frame Dungeon - Basic Course - T.A.T.O.C"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	    @Test
	  public void Test005_Frame_Dungeon_Test(){
		  String error= frameDungeon.click_without_repaint();
		 
			 
			Assert.assertTrue(error.equals("The page you are looking for does not exist"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	  @Test
	  public void Test006_Frame_Dungeon_Pass(){
		  String titleName= frameDungeon.proceed_after_repaint();
			Assert.assertTrue(titleName.contains("T.A.T.O.C"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	   @Test
	  public void Test007_Drag_And_Drop(){
		  String titleName= DragAround.dragAnddrop();
			System.out.println(titleName);
		  Assert.assertTrue(titleName.contains("Windows - Basic Course - T.A.T.O.C"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	  
	   @Test
	  public void Test008_popup_launch_Error_Test(){
		  String error= LauchPopupMenu.launchwithoutpopupClick();
		 
			 
			Assert.assertTrue(error.equals("The page you are looking for does not exist"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	  @Test
	  public void Test009_Launch_popUp_Menu(){
		  String titleName= LauchPopupMenu.launchPopUp();
			Assert.assertTrue(titleName.contains("Cookie Handling - Basic Course - T.A.T.O.C"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	  @Test
	  public void Test010_proceed_without_adding_cookie(){
		  String error= CookiePage.proceed_without_adding(); 
			Assert.assertTrue(error.equals("The page you are looking for does not exist"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }
	  @Test
	  public void Test011_Cookie_Handling(){
		  String titleName= CookiePage.cookieAdd();
			Assert.assertTrue(titleName.contains("End - T.A.T.O.C"));
			Reporter.log("Application Lauched successfully | ");
		  
	  }

	  @AfterClass
		public void closebrowser(){
			driver.quit();
			
		}
			}
