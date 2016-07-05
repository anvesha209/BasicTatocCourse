package com.test.action;

import org.testng.annotations.Test;

import com.test.PageObject.HomePageObject;

import com.test.PageObject.NewRepoObject;
import com.test.git.TestInitiator;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class HomePage /*extends HomePageObject*/{
	
  WebDriver driver;
  TestInitiator test;
  HomePageObject homePage;
  NewRepoObject newRepoPage;
  
/*  
  @FindBy (css="a[class='btn site-header-actions-btn mr-2']")
  WebElement signInButton;
*/


@BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  homePage=new HomePageObject(driver);
	  newRepoPage = new NewRepoObject(driver);
	//test = new TestInitiator(driver);
	  PageFactory.initElements(driver, this);
	  driver.get("https://github.com/");
  }
  
  

  @Test
  public void Step01_Click_Sign_In(){
	 homePage.GoToSignInPage();
	
  }
  
  @Test
  public void Step02_Enter_Credentials(){
	  homePage.sendCredentials();
	  homePage.ClickLoginButton();
  }
  
  
  @Test
  public void Step03_Create_Repository(){
	  newRepoPage.createNewRepository();
	  newRepoPage.enterNewRepoName();
	  
  }
  
  
  
  
  @AfterClass
  public void afterClass() {
  }
  
  
  

}
