package com.test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	WebDriver driver;
	public HomePageObject(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	  
	  @FindBy (css="a[class='btn site-header-actions-btn mr-2']")
	  public WebElement signInButton;
	  
	  
	  @FindBy (css="input[id='login_field']")
	  public WebElement username;
	  
	  @FindBy (css="input[id='password']")
	  public WebElement password;
	  
	  @FindBy (css="input[ class='btn btn-primary btn-block']")
	  public WebElement loginButton;

	  public void GoToSignInPage()
	  {
		  signInButton.click();
	  }
	
	  public void sendCredentials(){
		  username.sendKeys("anvesha209");
		  password.sendKeys("Shail.Mukesh2");
	  }
	  
	  public void ClickLoginButton(){
		  loginButton.click();
	  }
	  

	
}
