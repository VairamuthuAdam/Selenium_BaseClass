package com.selenium.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class Basefile {
	
	public static WebDriver driver;
	
	//Method for Screenshot
	public static void screenShot(String name) throws IOException {
		TakesScreenshot tss = (TakesScreenshot)driver;
		File srcFile = tss.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\USER\\eclipse-workspace\\SeleniumProject\\Screenshot\\"+name+".png");
		FileUtils.copyFile(srcFile, desFile);
	}
	
	//Method for launching Browser
	public static void openbrowser(String Browser) {
		
		//Using Try/Catch to show Exception	
		try {
			//if want Chrome Browser
			if (Browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\USER\\eclipse-workspace\\SeleniumProject\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			//if want FireFox Browser
			else if (Browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.geckodriver.driver", 
						"C:\\Users\\USER\\eclipse-workspace\\SeleniumProject\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method for Close
	public static void Close() {
		driver.close();
	}
	
	//Method for Close
	public static void quit() {
		driver.quit();
	}
	
	//Method for maximize the screen
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	//Method for Get URL
	public static void SiteURL(String URL) {
		driver.get(URL);
	}
	
	//Method for click
	public static void Click(WebElement element2) {
		element2.click();
	}
	
	//Method for send keys
	public static void sendkey(WebElement element1, String value) {
		element1.sendKeys(value);
	}
	
	//Method for clear
	public static void clear(WebElement element1) {
		element1.clear();
	}

	//Method for implicit wait in Seconds
	public static void impwaitaSEC(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//Method for implicit wait in minutes
	public static void impwaitaMIN(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	
	//Method for explicit wait
	public static void expwaitaMIN(WebElement element ,Duration  time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Method for switch to frame
	public static void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//Method for switch to default frame
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	
	//Method for get text
	public static void getText(WebElement element) {
		System.out.println(element.getText()); 
	}
	
	//Method for get text
	public static void getTextlist(List<WebElement> element) {
		for (WebElement ele : element) {
			System.out.println(ele.getText());
		}
	}
	
	//Method for isEnabled
	public static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
			System.out.println(enabled);
	}
	
	//Method for isDisplayed
	public static void isDisplayed(WebElement element) {
		boolean Displayed = element.isDisplayed();
			System.out.println(Displayed);
	}
	
	//Method for dropdown select
	public static void dropdown(WebElement element, String selectby, String input, int index) {
		
		Select select = new Select(element);
		
		//If want to by value
		if (selectby.equalsIgnoreCase("Value")) {
			select.selectByValue(input);
		}
		//If want to by Visible Text
		else if (selectby.equalsIgnoreCase("Visible")) {
			select.selectByVisibleText(input);
		}
		//If want to by Visible Text
		else if (selectby.equalsIgnoreCase("index")) {
			select.selectByIndex(index);
		}
	}
	
	//Method for Java Script Executor
	public static void javascript(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
}
