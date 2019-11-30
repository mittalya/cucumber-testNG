package pageobjects;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

/**
 * Created by Yash on 11/23/2018.
 * Execution priority: TestNG’s @BeforeClass → Cucumber’s @Before → Cucumber Background → 
 * Cucumber Scenario → Cucumber’s @After → TestNG’s @AfterClass
 */



public class ServiceHooks {
	protected WebDriver driver;
	String baseUrl;

	protected ServiceHooks() {
		try{
		String desiredBrowserName = ReadPropertyFile.readPropertiesFile("SystemVariables.properties","BROWSER");
		String desiredEnvironment = ReadPropertyFile.readPropertiesFile("SystemVariables.properties","ENVIRONMENT");
		if (desiredBrowserName.equalsIgnoreCase("Firefox")){
            // declaration and instantiation of objects/variables
        	System.setProperty("webdriver.gecko.driver","C:\\Users\\yasmittal\\Documents\\geckodriver.exe");
    		driver = new FirefoxDriver();
    }
    	else if (desiredBrowserName.equalsIgnoreCase("Chrome")){
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\yasmittal\\Documents\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	else if (desiredBrowserName.equalsIgnoreCase("IE")){
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\yasmittal\\Documents\\IEDriverServer.exe");
    		driver = new InternetExplorerDriver();
    	}
    	else{
    		//throw new Exception("Browser is not correct");
    	}
		
    	if(desiredEnvironment.equalsIgnoreCase("SIT")){
    		//String baseUrl = ReadPropertyFile.readPropertiesFile("SystemVariables.properties","SITURL");
            baseUrl = "https://sit-ne.healthinteractive.com/fssologin.aspx?idp=SIT_Nebraska&action=HandleIdpResponse";
    	}
    	else if (desiredEnvironment.equalsIgnoreCase("UAT")){
    		//String baseUrl = ReadPropertyFile.readPropertiesFile("SystemVariables.properties","UATURL");
            baseUrl = "https://uat-ne.healthinteractive.com/fssologin.aspx?idp=UAT_Nebraska&action=HandleIdpResponse";
    	}
    	else{
    		//throw new Exception("Browser is not correct");
    	}
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.manage().window().maximize();	
        driver.get(baseUrl);
		}
		catch(Exception e){
			
		}
	}


    public void TakeScreenshots(WebDriver driver) throws Exception{
        /*if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    	
    	String FileWithPath = "C\\Users\\yasmittal\\Documents\\Selenium package\\Output";
    	TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
    	File DestFile= new File(FileWithPath);
    	FileUtils.copyFile(SrcFile,DestFile);
    }
    
    @AfterTest
    public void aftertest(){
        driver.close();
        driver.quit();
    }
}
