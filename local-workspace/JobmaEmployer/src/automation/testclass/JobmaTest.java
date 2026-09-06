package automation.testclass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import automation.baseclass.TestBase;
import automation.excelread.ExcelUtils;

public class JobmaTest extends TestBase {

	@Test
	public void To_Verify_That_User_Is_Able_To_Login_JobmaEmployer() throws InterruptedException, IOException {
		//String productToSearch = ExcelUtils.getCellDataString(1, 2);
        test.info("Shopify form fill method started");
       // jlp.JobmaLogin();
        dp.Pre_RecordedInterviewFlow_TrackPage_CandidateLink();
        Thread.sleep(20000);
		
        
							
	}
	
	//@Test
	public void To_Verify_That_User_Is_Able_To_Login_JobmaEmployer1() throws InterruptedException, IOException {
		String productToSearch = ExcelUtils.getCellDataString(1, 2);
        test.info("Shopify form fill method started");
        jlp.JobmaLogin();
        Thread.sleep(2000);
		hp.ShopifyForm();
		test.info("Shopify form fill method ended");
			
		
		test.info("Started:- verifying that user is able to search product add first product to card back from cart page and another product to card on cart page click on continue button ");
		waitForElement(driver, Duration.ofSeconds(time),hp.SearchIcon);
		hp.SearchIcon.click();
		
		waitForElement(driver, Duration.ofSeconds(time),hp.SearchBar);
		hp.SearchBar.clear();
		hp.SearchBar.sendKeys(productToSearch); // here code work 
		
		Thread.sleep(5000);
		waitForElement(driver, Duration.ofSeconds(time),hp.ResultProduct);
		test.addScreenCaptureFromPath(getScreenShotForExtent("ResultProduct"));
		hp.ResultProduct.click();
				
		waitForElement(driver, Duration.ofSeconds(time),pdp.Button_AddToCart);
		test.addScreenCaptureFromPath(getScreenShotForExtent("Button_AddToCart"));
		pdp.Button_AddToCart.click();
		
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement closeCart = (WebElement) jse.executeScript("return document.querySelector('cart-drawer').shadowRoot.querySelector('button')");
		test.addScreenCaptureFromPath(getScreenShotForExtent("closeCart"));
		closeCart.click();
		
		waitForElement(driver, Duration.ofSeconds(time),pdp.SizePackOf30);
		pdp.SizePackOf30.click();
		test.addScreenCaptureFromPath(getScreenShotForExtent("SizePackOf30"));

		
		waitForElement(driver, Duration.ofSeconds(time),pdp.Button_AddToCart);
		pdp.Button_AddToCart.click();
		test.addScreenCaptureFromPath(getScreenShotForExtent("Button_AddToCart"));
		
		waitForElement(driver, Duration.ofSeconds(time),pdp.ButtonCheckout);
		pdp.ButtonCheckout.click();
		test.addScreenCaptureFromPath(getScreenShotForExtent("ButtonCheckout"));
		
		test.info("Ended:- verifying that user is able to search product add first product to card back from cart page and another product to card on cart page click on continue button ");

		
		test.info("Started:- verifying that On Pay now page user is able to fill all form and click on pay now button ");
		cop.PayNow_Page();
		test.info("Ended:- verifying that On Pay now page user is able to fill all form and click on pay now button ");

				
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		if (driver != null) {
			driver.quit();
		}
	}

}
