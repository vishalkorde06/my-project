package automation.pageobjectclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.baseclass.TestBase;
import automation.excelread.ExcelUtils;

public class CheckOutPage extends TestBase {

	
	@FindBy(xpath = "//input[@id=\"email\"]")
	public WebElement emailFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"First name\"]")
	public WebElement firstNameFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"Last name\"]")
	public WebElement lastNameFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"Address\"]")
	public WebElement addressFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"City\"]")
	public WebElement cityFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"PIN code\"]")
	public WebElement pinCodeFiled;
	
	@FindBy(xpath = "//input[@placeholder=\"Phone\"]")
	public WebElement phoneFiled;
	
	@FindBy(xpath = "//input[@id=\"save_shipping_information\"]")
	public WebElement saveInfoCheckBox;
	
	@FindBy(xpath = "//input[@id=\"sms_marketing_opt_in\"]")
	public WebElement notificationAuthCheckBox;

	@FindBy(xpath = "//input[@id=\"billing_address_selector-shipping_address\"]")
	public WebElement optionToKeepBillingAddSameAsShippinAdd;
	
	@FindBy(xpath = "//button[@id=\"checkout-pay-button\"]")
	public WebElement payNowButton;
		
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public void PayNow_Page() throws IOException, InterruptedException {
		String firstNameInput = ExcelUtils.getCellDataString(1, 0);
		String emailInput = ExcelUtils.getCellDataString(1, 1);
		String lastName = ExcelUtils.getCellDataString(1, 3);
		String address = ExcelUtils.getCellDataString(1, 4);
		String city = ExcelUtils.getCellDataString(1, 5);
		String pinCode = ExcelUtils.getCellDataString(1, 6);
		String phone = ExcelUtils.getCellDataString(1, 7);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.emailFiled);
		cop.emailFiled.click();
		cop.emailFiled.sendKeys(emailInput);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.firstNameFiled);
		cop.firstNameFiled.click();
		cop.firstNameFiled.sendKeys(firstNameInput);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.lastNameFiled);
		cop.lastNameFiled.click();
		cop.lastNameFiled.sendKeys(lastName);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.lastNameFiled);
		cop.lastNameFiled.click();
		cop.lastNameFiled.sendKeys(lastName);

		waitForElement(driver, Duration.ofSeconds(time),cop.addressFiled);
		cop.addressFiled.click();		test.addScreenCaptureFromPath(getScreenShotForExtent("emailFiled"));

		cop.addressFiled.sendKeys(address);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.cityFiled);
		cop.cityFiled.click();
		cop.cityFiled.sendKeys(city);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.pinCodeFiled);
		cop.pinCodeFiled.click();
		cop.pinCodeFiled.sendKeys(pinCode);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.phoneFiled);
		cop.phoneFiled.click();
		cop.phoneFiled.sendKeys(phone);
		
		waitForElement(driver, Duration.ofSeconds(time),cop.saveInfoCheckBox);
		cop.saveInfoCheckBox.click();
		
		waitForElement(driver, Duration.ofSeconds(time),cop.notificationAuthCheckBox);
		cop.notificationAuthCheckBox.click();
		test.addScreenCaptureFromPath(getScreenShotForExtent("notificationAuthCheckBox"));

		
		waitForElement(driver, Duration.ofSeconds(time),cop.optionToKeepBillingAddSameAsShippinAdd);
		cop.optionToKeepBillingAddSameAsShippinAdd.click();
		
		waitForElement(driver, Duration.ofSeconds(time),cop.payNowButton);
		cop.payNowButton.click();
		Thread.sleep(2000);
		test.addScreenCaptureFromPath(getScreenShotForExtent("payNowButton"));

	
	}

	

}
