package com.test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRepoObject {
	
	WebDriver driver;
	public NewRepoObject(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	@FindBy (css="a[class='btn btn-sm btn-primary']")
	public WebElement newRepoButton;
	
	@FindBy (css="input[id='repository_name' ]")
	public WebElement newRepoName;
	
	@FindBy (css="input[type='checkbox'][name='repository[auto_init]']")
	public WebElement chckbox_initializeWithReadMe;
	
	@FindBy (css="button[class='btn btn-primary first-in-line']")
	public WebElement btn_createRepo;
	
	public void createNewRepository(){
		newRepoButton.click();
	}
	
	public void enterNewRepoName(){
		newRepoName.sendKeys("Basic Repository");
		chckbox_initializeWithReadMe.click();
		btn_createRepo.click();
	}
	
	
	
	
}
