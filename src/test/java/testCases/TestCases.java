package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import webpage.ImportGoogleAnalytics;

public class TestCases extends BaseTest{
	
	private ImportGoogleAnalytics igaObj;
	
	@Test
	public void clickSelfHelp()
	{
		igaObj=new ImportGoogleAnalytics(driver);
		
		Assert.assertEquals(igaObj.clickOnSelfHelp().trim(), "Get Started with Whatfix");
	}
	
	@Test(dependsOnMethods={"clickSelfHelp"})
	public void howToEmbedFlows()
	{
		Assert.assertEquals(igaObj.clickOnHowToEmbedFLowsInMyWebsite().trim(), 
				"Click on 'embed' options.");
	}
	
	@Test(dependsOnMethods={"howToEmbedFlows"})
	public void clickEmbed()
	{
		igaObj.clickOnEmbed();
	}
	
	@Test(dependsOnMethods={"clickEmbed"})
	public void clickSlideShow() throws InterruptedException 
	{
		Thread.sleep(500);
		igaObj.clickOnSlideShow();
	}
	
	@Test(dependsOnMethods={"clickSlideShow"})
	public void clickNext()
	{
		igaObj.clickOnNext();
	}
	
	@Test(dependsOnMethods={"clickNext"})
	public void clickCloseBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		igaObj.clickOnClose();
	}
}
