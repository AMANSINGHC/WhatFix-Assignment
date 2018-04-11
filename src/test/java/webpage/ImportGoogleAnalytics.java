package webpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportGoogleAnalytics {
	
	WebDriver driver;
	
	@FindBy(css="div.WFEMAV")
	private WebElement eleSelfHelp;
	
	@FindBy(css="iframe[title*='Get Started']")
	private WebElement frameGetStarted;
	
	@FindBy(css="div.WFWIKY")
	private WebElement eleSelfHelpTitle;
	
	@FindBy(xpath="(//a[@class='gwt-Anchor WFWIHY'])[1]")
	private WebElement eleQuery;
	
	@FindBy(css="div.WFEMGW")
	private WebElement toolTipAtEmbed;
	
	@FindBy(css="#wfx-dashboard-content-embed")
	private WebElement eleEmbed;
	
	@FindBy(css="a[id*='embed-slideshow']")
	private WebElement eleSlideShow;
	
	@FindBy(css="a.WFEMMV")
	private WebElement eleNext;
	
	@FindBy(css="iframe.WFEMIU.WFEMOU")
	private WebElement frameClose;
	
	@FindBy(css="button[class*='Button']")
	private WebElement btnClose;
	
	public ImportGoogleAnalytics(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnSelfHelp()
	{
		eleSelfHelp.click();
		
		driver.switchTo().frame(frameGetStarted);
		
		return eleSelfHelpTitle.getText(); 
	}
	
	public String clickOnHowToEmbedFLowsInMyWebsite()
	{
		eleQuery.click();
		
		driver.switchTo().defaultContent();
		
		return toolTipAtEmbed.getAttribute("innerText");
	}
	
	public void clickOnEmbed()
	{
		eleEmbed.click();
	}
	
	public void clickOnSlideShow()
	{
		eleSlideShow.click();
	}
	
	public void clickOnNext()
	{
		eleNext.click();
	}
	
	public void clickOnClose()
	{
		driver.switchTo().frame(frameClose);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnClose);
	}
}
