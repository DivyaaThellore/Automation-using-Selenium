

import java.io.File;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);
	static Test t2=new Test();
	
	/*public static void test_method()
	{
		System.out.println("This is a test !");
	}
	 
	public static void method_call()
	{
		t2.test_method2();
		
	}*/
	
	public static void execute_test() throws Exception {
	
		Scanner sc= new Scanner (System.in);
		String search_txt="";
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
	
		WebDriver driver= new ChromeDriver();
	
		driver.get("http://www.wikipedia.org");
		
		WebElement link;
		link= driver.findElement(By.id("js-link-box-en"));
		link.click();
		Log("English link clicked");
		
		WebElement searchBox;
		searchBox = driver.findElement(By.name("search"));	
		
		System.out.println("Enter the search text");
		search_txt= sc.nextLine();
		
		searchBox.sendKeys("search_txt");  
		Log("Searching for "+ search_txt);
		
		WebElement button= driver.findElement(By.id("searchButton"));
		button.click();
		Log("search button clicked");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./ScreenShots/wiki.png"));
		logger.info("Screen shot taken");
		
		
		driver.quit();
		Log("closed browser");
		
	}
	
	public static void Log(String str) {
		logger.info(str);
	}
	
	public static void main(String args[]) throws Exception {
		
		logger.info("*********** Start execution***********");

		execute_test();

		logger.info("*********** End execution***********");

	}
}
