package automation.pageobjectclass;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.baseclass.TestBase;
import automation.excelread.ExcelUtils;

public final class HomePage extends TestBase {


	@FindBy(xpath = "//*[@id=\"email\"]")
	public WebElement Email;

	@FindBy(xpath = "//*[@class=\"_formSubmitButton_cit2d_96\"][contains(text(),'Lets Go')]")
	public WebElement Button_LetsGo;

	@FindBy(xpath = "//span[@role=\"button\"]")
	public WebElement CloseRegistrationPopUp;

	@FindBy(xpath = "//li[@class=\"header__search-link \"]")
	public WebElement SearchIcon;

	@FindBy(xpath = "//input[@id=\"search-drawer-input\"]")
	public WebElement SearchBar;

	@FindBy(xpath = "//div[@class=\"predictive-search__products\"]//div[@class=\"product-card__figure\"]//a")
	public WebElement SearchedProduct;

	@FindBy(xpath = "//*[@class=\"predictive-search__products\"]//*[@class=\"product-card__figure\"]")
	public WebElement ResultProduct;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void ShopifyForm() throws IOException {
		String firstNameInput = ExcelUtils.getCellDataString(1, 0);
		String emailInput = ExcelUtils.getCellDataString(1, 1);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement ShopifyFormContainer = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shopify-forms-embed")));

		SearchContext shadowRoot = ShopifyFormContainer.getShadowRoot();

		WebElement GetAheadWithAscendForm = ShadowElement(shadowRoot,
				By.cssSelector("[aria-label='Get Ahead With Ascend']"), Duration.ofSeconds(time));
		assertTrue(GetAheadWithAscendForm.isDisplayed(),
				"After user land on Home Page user is able to see Get Ahead With Ascend From");

		WebElement firstName = ShadowElement(shadowRoot, By.cssSelector("input#first_name"), Duration.ofSeconds(time));
		firstName.sendKeys(firstNameInput);

		WebElement email = ShadowElement(shadowRoot, By.cssSelector("input#email"), Duration.ofSeconds(time));
		email.sendKeys(emailInput);
		test.addScreenCaptureFromPath(getScreenShotForExtent("email"));
		WebElement LetsGo = ShadowElement(shadowRoot, By.cssSelector("._formSubmitButton_cit2d_96"),
				Duration.ofSeconds(time));
		LetsGo.click();

		WebElement ThanksPopUpClose = ShadowElement(shadowRoot, By.cssSelector("._formCloseButton_1684x_4"),
				Duration.ofSeconds(time));
		ThanksPopUpClose.click();
		System.out.println("Pop up has closed");

	}

}
