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

public class ProductDetailPage extends TestBase {

	@FindBy(xpath = "//label[@class=\\\"block-swatch   \\\"]//span[contains(text(),'Pack of 10')]")
	public WebElement SizePackOf10;
	
	@FindBy(xpath = "//label[@class=\"block-swatch   \"]//span[contains(text(),'Pack of 30')]")
	public WebElement SizePackOf30;
	
	@FindBy(xpath="//*[@class=\"quantity-selector \"]//input[@class=\"quantity-selector__input subheading\"]")
	public WebElement QuantitySelected;

	
	@FindBy(xpath = "//*[@class=\"button button--outline w-full\"]//*[contains(@class,'button__content')]")
	public WebElement Button_AddToCart;
	
	
	@FindBy(xpath = "//button-content[@class=\"button__content\"][contains(text(),'Checkout')]")
	public WebElement ButtonCheckout;
	
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

	
	
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}


	

}
