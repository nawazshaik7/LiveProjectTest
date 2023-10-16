package uk.co.automationtesting;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BasePage;
import base.Hooks;
import dev.failsafe.internal.util.Assert;
import pageObjects.HomePage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks{

	public AddRemoveItemBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	@Test
	public void addRemoveItem() throws IOException, InterruptedException {
		// creating an object of the automationtesting.co.uk webpage
		HomePage home = new HomePage();
		home.getToggle().click();
		
		//handle cookie visibility using JSE - added 20230217
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", home.getTestStoreLink()); 
		scroll(home.getTestStoreLink());

		home.getTestStoreLink().click();

		// creating an object of the test store homepage
	
		//home.getToggle().click();
		//Thread.sleep(3000);
		//home.getTestStoreLink().click();
		ShopHomepage shophome=new ShopHomepage();
		shophome.getProdOne().click();

		// creating an object of the shop products page (when a product has been selected)
		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		// creating an object of the cart content panel (once an item was added)
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shophome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
	
		
		waitforElementInvisible(cart.getDeleteItemTwo(), Duration.ofSeconds(20));
	
		System.out.println(cart.getTotalAmount().getText());
		AssertJUnit.assertEquals(cart.getTotalAmount().getText(), "$45.24");
		
	}
	


}