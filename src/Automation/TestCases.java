package Automation;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends MyData {
	WebDriver driver=new EdgeDriver();
	@BeforeTest
	public void mysetup()
	{
    driver.get(mywebsite);
	driver.navigate().to(signupPage);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}

@Test(priority = 1, enabled=false)
public void signupTest() throws InterruptedException
{ 
	//WebElements for user info
	WebElement firstnameInput = driver.findElement(By.id(FirstnameID)); 
	WebElement lastnameInput = driver.findElement(By.id(LastnameID)); 
	WebElement EmailInput = driver.findElement(By.id(EmailID)); 
	WebElement PhoneNumber = driver.findElement(By.id(TelephoneID)); 
	WebElement AddressInput = driver.findElement(By.id(AddressID)); 
	WebElement City = driver.findElement(By.id(cityID)); 
	WebElement ZIP = driver.findElement(By.id(ZIPID)); 
	WebElement password=driver.findElement(By.id(PasswordID));
	WebElement PasswordConfirm=driver.findElement(By.id(ConfirmPasswordID));
	WebElement Subscribe=driver.findElement(By.id(SubscribeID));
	WebElement Agree=driver.findElement(By.id(AgreeButtonID));
	WebElement Continue=driver.findElement(By.xpath(ContinueButton));
	//WebElement Continue2=driver.findElement(By.cssSelector(ContinueButton2));
		
	//Select country
	WebElement Thecountry = driver.findElement(By.id("AccountFrm_country_id"));
	Select mySelectElementForcountry = new Select(Thecountry); 
	mySelectElementForcountry.selectByIndex(108);
	//select state	
	WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
	Select mySelectElementForState = new Select(TheState); 
	Thread.sleep(2000);
	mySelectElementForState.selectByIndex(10);
	WebElement RandLoginNames=driver.findElement(By.id(RandLoginNamesID));
	
	

	//Actions
	firstnameInput.sendKeys(TheFirstName);
	lastnameInput.sendKeys(TheLastName);
	EmailInput.sendKeys(TheEmail);
	PhoneNumber.sendKeys(phonenumber);
	AddressInput.sendKeys(Address);
	City.sendKeys(city);
	ZIP.sendKeys(ZIPcode);
	RandLoginNames.sendKeys(LoginName);
	password.sendKeys(Password);
	PasswordConfirm.sendKeys(Password);
	Subscribe.click();
	Agree.click();
	Continue.click();
	Thread.sleep(2000);
	String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();
	Assert.assertEquals(ActualSignUpMessage, ExpectedTextForTheSignUp);
	//Continue2.click();
	driver.navigate().to(Home);
	}


@Test(priority = 2,enabled = false)
public void LogoutTest() throws InterruptedException
{
//LogOutButtonThread.sleep(2000);
driver.findElement(By.partialLinkText("Logo")).click();;;
//driver.findElement(By.xpath(AccountID)).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath(LogOutID)).click();
	
	
	//Check if the test passed or not..
	boolean ActualValueForLogout = driver.getPageSource().contains(ExpectedTextForTheLogOut);
	Assert.assertEquals(ActualValueForLogout, true);
	//Continue
	WebElement Continue2=driver.findElement(By.xpath(ContinueButton2));
	Continue2.click();
	
	
}
@Test(priority = 3,enabled = false)
public void LogInTest() throws InterruptedException
{
driver.navigate().to(mywebsite);
driver.findElement(By.xpath(AccountID)).click();	
WebElement Name=driver.findElement(By.id(LoginNID));
WebElement password=driver.findElement(By.id(LogInPID));
WebElement LogInButton=driver.findElement(By.xpath(LoginButtonID));

Name.sendKeys(LoginName);
password.sendKeys(Password);
Thread.sleep(3000);
LogInButton.click();
Boolean ActualMessage=driver.getPageSource().contains(WelcomeMessage);
Boolean ExbectedMessage=true;
Assert.assertEquals(ActualMessage, ExbectedMessage);

}
@Test(priority = 4, enabled = true, invocationCount = 10)
public void addItemes() throws InterruptedException {
    driver.navigate().to(mywebsite);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Random rand = new Random();

    // Pick random item
    List<WebElement> Allitems = driver.findElements(By.className("prdocutname"));
    int randomIndexForTheItem = rand.nextInt(Allitems.size());
    Allitems.get(randomIndexForTheItem).click();

    // Check if product has size options
    boolean isSizePage = driver.getCurrentUrl().contains("product_id=116");

    if (isSizePage) {
        List<WebElement> SizeSelector = driver.findElements(By.cssSelector(SizeUKID));

        List<WebElement> availableSizes = new ArrayList<>();
        for (WebElement size : SizeSelector) {
            String sizeText = size.getText().trim();
            boolean isDisabled = !size.isEnabled(); // catches <option disabled>
            boolean markedOut = sizeText.toLowerCase().contains("out of stock");

            System.out.println("Found size: " + sizeText + " | enabled=" + size.isEnabled());

            if (!isDisabled && !markedOut) {
                availableSizes.add(size);
            }
        }

        if (!availableSizes.isEmpty()) {
            int randomIndexForTheSize = rand.nextInt(availableSizes.size());
            WebElement chosenSize = availableSizes.get(randomIndexForTheSize);
            chosenSize.click();
            System.out.println("Selected size: " + chosenSize.getText());
        } else {
            System.out.println("All sizes are out of stock. Skipping...");
            return;
        }
    }

    // Check stock status safely
    List<WebElement> stockLabels = driver.findElements(By.cssSelector(OutofStockId));
    boolean isOutOfStock = !stockLabels.isEmpty() &&
                           stockLabels.get(0).getText().toLowerCase().contains("out of stock");

    if (!isOutOfStock) {
        WebElement AddItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCartId)));
        AddItem.click();
        System.out.println("Item added to cart ✅");
    } else {
        System.out.println("Item is out of stock ❌, skipping...");
    }
}


}
