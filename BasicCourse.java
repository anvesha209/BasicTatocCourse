

import java.io.File;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class BasicCourse {
	
	public static void main(String args[]) throws Exception
	{
	
		//WebDriver driver=new FirefoxDriver();
		/*File ffExecutable=new File("/home/anveshanigam/Downloads/firefox/firefox");
		FirefoxBinary ffBinary=new FirefoxBinary(ffExecutable);
		FirefoxProfile ffProfile=new FirefoxProfile();*/
		WebDriver driver = new FirefoxDriver();//ffBinary,ffProfile);
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://10.0.1.86/");
		
		driver.findElement(By.linkText("/tatoc")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/a[1]")).click();
		driver.findElement(By.cssSelector(".greenbox")).click();
		
		
		// Color Change		
		driver.switchTo().frame("main");
		String color1 = driver.findElement(By.xpath(".//*[@id='answer']")).getAttribute("class");	
		driver.switchTo().frame("child");
		String color2 = driver.findElement(By.xpath(".//*[@id='answer']")).getAttribute("class");
		while(!color1.equals(color2))
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.findElement(By.xpath("html/body/center/a[1]")).click();
			driver.switchTo().frame("child");
			color2 = driver.findElement(By.xpath(".//*[@id='answer']")).getAttribute("class");
		
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.xpath("html/body/center/a[2]")).click();
		
		// Drag n Drop
		WebElement source = driver.findElement(By.cssSelector("#dragbox"));
		WebElement dest = driver.findElement(By.cssSelector("#dropbox"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, dest).build().perform();
		
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/a")).click();
		
		//Launch
		driver.findElement(By.xpath("html/body/div[1]/div[2]/a[1]")).click();	
		String handle = driver.getWindowHandle();
		for(String webhand: driver.getWindowHandles())
		{
			driver.switchTo().window(webhand);
		}
		driver.findElement(By.cssSelector("#name")).sendKeys("ANVESHA NIGAM");
		driver.findElement(By.cssSelector("#submit")).click();
		driver.switchTo().window(handle);
		
		driver.findElement(By.linkText("Proceed")).click();
		
		//cookies
		
		driver.findElement(By.linkText("Generate Token")).click();
		String s = driver.findElement(By.cssSelector("#token")).getText();
		Cookie name = new Cookie("Token", s.substring(7));
		driver.manage().addCookie(name);
		
		driver.findElement(By.linkText("Proceed")).click();
		}
}