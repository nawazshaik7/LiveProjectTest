package uk.co.automationtesting;

import org.testng.annotations.Test;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BasePage;
import base.Hooks;
import pageObjects.HomePage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void endToend() throws InterruptedException, IOException
	{
		HomePage home=new HomePage();
		home.getToggle().click();
		Thread.sleep(3000);
		home.getTestStoreLink().click();
		ShopHomepage shophome=new ShopHomepage();
		shophome.getProdOne().click();
		ShopProductPage shopprod=new ShopProductPage();
		Select option=new Select(shopprod.getSizeOption());
		option.selectByVisibleText("M");
		shopprod.getQuantIncrease().click();
		shopprod.getAddToCartBtn().click();
		Thread.sleep(5000);
		ShopContentPanel spanel=new ShopContentPanel();
		spanel.getCheckoutBtn().click();
		ShoppingCart cart=new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		Thread.sleep(5000);
		cart.getProceedCheckoutBtn().click();
		OrderFormPersInfo pInfo=new OrderFormPersInfo();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("John");
		pInfo.getLastnameField().sendKeys("smit");
		pInfo.getEmailField().sendKeys("johnsmit@test.com");
		pInfo.getTermsConditionsCheckbox().click();
		Thread.sleep(5000);	
		pInfo.getContinueBtn().click();
		OrderFormDelivery orderDelivery=new OrderFormDelivery();
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state=new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77201");
		Thread.sleep(5000);
		orderDelivery.getContinueBtn().click();
		OrderFormShippingMethod shipping=new OrderFormShippingMethod();
		shipping.getDeliveryMsgTextbox().sendKeys("keep it in my stand");
		shipping.getContinueBtn().click();
		OrderFormPayment payment=new OrderFormPayment();
		payment.getPayByCheckRadioBtn().click();
		payment.getTermsConditionsCheckbox().click();
		Thread.sleep(5000);
		payment.getOrderBtn().click();
		
		
		
		
		
		
	}
}
