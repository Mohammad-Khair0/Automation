package Automation;

import java.util.Random;


public class MyData {
	Random rand=new Random();
//FirstName
String []Firstnames= {"Mohammad","Sameh","Ahmad","Mahmoud","Yasser","Abdullah"};
int RandomFirstNamesIndex=rand.nextInt(Firstnames.length);
String TheFirstName = Firstnames[RandomFirstNamesIndex];
//LastName
String []Lastnames= {"Rami","Malek","Salah","Osama","Hamza","Maen"};
int RandomLastNamesIndex=rand.nextInt(Lastnames.length);
String TheLastName = Lastnames[RandomLastNamesIndex];
//email
int RandomNumberEmail=rand.nextInt(19545);
String domain="@gmail.com";
String TheEmail = TheFirstName+TheLastName+RandomNumberEmail+domain;
//PhoneNumber
int randomforphonenumber=rand.nextInt(1000000,10000000);
String phonenumber="079"+randomforphonenumber;
//Address
String Address="ALshawahed-King Abdullah street";
//City
String city = "Jarash";
//ZIPcode
int ZIPnum =rand.nextInt(10000,100000);
String ZIPcode=""+ZIPnum;
//LogInName
String []randomloginNames= {"Mohammad","Sameh","Ahmad","Mahmoud","Yasser","Abdullah","Rami","Malek","Salah","Osama","Hamza","Maen"};
int LoginNames=rand.nextInt(randomloginNames.length);
String RanLoginName=randomloginNames[LoginNames];
int RandomNumberLoginName=rand.nextInt(1,500);
String LoginName=RanLoginName+RandomNumberLoginName;
//Password
String []Passwords= {"M1234567@d","m123579421","mn5643213","jkjh25542154@d","m22665588@a"};
int RandomPasswords=rand.nextInt(Passwords.length);
String Password=Passwords[RandomPasswords];
//IDs for the web elements
String FirstnameID="AccountFrm_firstname";
String LastnameID="AccountFrm_lastname";
String EmailID="AccountFrm_email";
String TelephoneID="AccountFrm_telephone";
String AddressID="AccountFrm_address_1";
String cityID="AccountFrm_city";
String ZIPID="AccountFrm_postcode";
String RandLoginNamesID="AccountFrm_loginname";
String mywebsite="https://automationteststore.com/";
String signupPage="https://automationteststore.com/index.php?rt=account/create";
String PasswordID="AccountFrm_password";
String ConfirmPasswordID="AccountFrm_confirm";
String SubscribeID="AccountFrm_newsletter1";
String AgreeButtonID="AccountFrm_agree";
String ContinueButton="//*[@id=\"AccountFrm\"]/div[5]/div/div/button";
String ExpectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
//String ContinueButton2=".btn.btn-default.mr10";
String Home="https://automationteststore.com/";
String LogOutID="//li[@class='dropdown open']//span[@class='menu_text'][normalize-space()='Logout']";
String AccountID="//li[@data-id='menu_account']";
String ExpectedTextForTheLogOut = "You have been logged off your account. It is now safe to leave the computer.";
String ContinueButton2="//a[@title='Continue']";
//IDs for adding items
String AddToCartId="//a[normalize-space()='Add to Cart']";
String OutofStockId=".nostock";
String SizeUKID="input[name='option[344][]']";

//IDs for LogInTest
String LoginNID="loginFrm_loginname";
String LogInPID="loginFrm_password";
String LoginButtonID="//button[normalize-space()='Login']";
String WelcomeMessage="Welcome back "+TheFirstName;
}

