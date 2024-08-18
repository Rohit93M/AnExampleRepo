package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.genericutility.ListenersImplementation;

@Listeners(ListenersImplementation.class)
public class LearningMethodsOfWebElement extends BaseClass {

	@Test
	public void VerifyLoginButtonInFbPageIsEnabled() {

		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		Assert.assertTrue(loginButton.isEnabled());
		loginButton.submit();
	}

	@Test
	public void writeAScripToCheckTheVisibilityOfAnElement() {
		driver.get("https://www.facebook.com/signup");
		WebElement invisibleEle = driver.findElement(By.name("preferred_pronoun"));
		if (invisibleEle.isDisplayed()) {
			System.out.println("method True");
			System.out.println("Client false");
		} else {
			System.out.println("method false");
			System.out.println("Client --- True");
		}
	}

	@Test
	public void checkWhetherUserIsAbleToClick() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		Thread.sleep(2000);
	}

	@Test
	public void writeAScripToCheckForPlaceholder() {
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.findElement(By.id("email"));
		String emailPlaceholder = emailTextField.getAttribute("placeholder");
		System.out.println("emailPlaceholder= " + emailPlaceholder);
	}

	@Test
	public void writeAScripToGetTheColorOfErrorMessage() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.submit();
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String errorMsgText = errorMessage.getText();
		Thread.sleep(2000);
		System.out.println("errorMsgText= " + errorMsgText);
		String colorOferrorMsg = errorMessage.getCssValue("color");
		System.out.println("colorOferrorMsg= " + colorOferrorMsg);
		String hexadecimalValue = Color.fromString(colorOferrorMsg).asHex();
		System.out.println("hexadecimalValue= " + hexadecimalValue);

	}

	@Test
	public void writeAScripToEnterDataByKeyboardSimulationsInSendKeys() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.findElement(By.id("email"));
		emailTextField.sendKeys(Keys.chord("abc123@gmail.com"));
		Thread.sleep(2000);
		WebElement passwordTextField = driver.findElement(By.id("pass"));
		passwordTextField.sendKeys(Keys.chord("123456"));
		Thread.sleep(2000);
	}

	@Test
	public void writeAScripToEnterTheDataAfterCheckingForValue() {
		driver.get("https://www.facebook.com/signup");
		WebElement firstnameTextField = driver.findElement(By.name("firstname"));
		String firstnameValue = firstnameTextField.getAttribute("value");
		System.out.println("firstnameValue= " + firstnameValue);
		if (firstnameValue.isEmpty()) {
			firstnameTextField.sendKeys("abc");
		} else {
			firstnameTextField.clear();
			firstnameTextField.sendKeys("xyz");

		}
	}

	@Test
	public void writeAScripToHandleObscuredElement() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		WebElement conOfUseLink = driver.findElement(By.xpath("//a[text()='Conditions of Use']"));
		conOfUseLink.click();
		Thread.sleep(2000);
		WebElement dismissOpt = driver
				.findElement(By.xpath("//span[contains(text(),'Dismiss')]/..//input[@type='submit']"));
		dismissOpt.click();
		Thread.sleep(2000);
		WebElement customerServiceLink = driver.findElement(By.xpath("//a[text()='Customer Service']"));
		customerServiceLink.click();

	}

	@Test
	public void writeAScriptToObtainInfoFromElements() {

		// Navigate to Url
		driver.get("https://www.selenium.dev/selenium/web/inputs.html");

		// isDisplayed
		// Get boolean value for is element display
		boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
		Assert.assertEquals(isEmailVisible, true);

		// isEnabled
		// returns true if element is enabled else returns false
		boolean isEnabledButton = driver.findElement(By.name("button_input")).isEnabled();
		Assert.assertEquals(isEnabledButton, true);

		// isSelected
		// returns true if element is checked else returns false
		boolean isSelectedCheck = driver.findElement(By.name("checkbox_input")).isSelected();
		Assert.assertEquals(isSelectedCheck, true);

		// TagName
		// returns TagName of the element
		String tagNameInp = driver.findElement(By.name("email_input")).getTagName();
		Assert.assertEquals(tagNameInp, "input");

		// GetRect
		// Returns height, width, x and y coordinates referenced element
		Rectangle res = driver.findElement(By.name("range_input")).getRect();
		// Rectangle class provides getX,getY, getWidth, getHeight methods
		Assert.assertEquals(res.getX(), 10);

		// Retrieves the computed style property 'font-size' of field
		String cssValue = driver.findElement(By.name("color_input")).getCssValue("font-size");
		Assert.assertEquals(cssValue, "13.3333px");

		// GetText
		// Retrieves the text of the element
		String text = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(text, "Testing Inputs");

		// FetchAttributes
		// identify the email text box
		WebElement emailTxt = driver.findElement(By.name(("email_input")));
		
		// fetch the value property associated with the textbox
		String valueInfo = emailTxt.getAttribute("value");
		Assert.assertEquals(valueInfo, "admin@localhost");
	}

	@Test
	public void checkWhetherTheUserIsAbleToClickOnLinkText() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement forgottenPwdLink = driver.findElement(By.linkText("Forgotten password?"));
		forgottenPwdLink.click();
		Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheUserIsAbleToClickOnPartialLinkText() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		WebElement hindiLink = driver.findElement(By.partialLinkText("हिन्दी"));
		hindiLink.click();
		Thread.sleep(2000);
		WebElement englishLink = driver.findElement(By.partialLinkText("English (UK)"));
		englishLink.click();
		Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheCustomRadioButtonIsSelected() throws InterruptedException {
		driver.get("https://www.facebook.com/signup");
		WebElement customRadioButton = driver
				.findElement(By.xpath("//label[text()='Custom']/..//input[@type='radio']"));
		Assert.assertTrue(!customRadioButton.isSelected());
			customRadioButton.click();
			Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheEmailAndPasswordTextFieldEndPointsAreSame() {
		driver.get("https://www.facebook.com/");
		// email
		WebElement emailTextField = driver.findElement(By.id("email"));
		int emailStartX = emailTextField.getRect().getX();
		System.out.println("emailStartX= " + emailStartX);
		int emailWidth = emailTextField.getRect().getWidth();
		System.out.println("emailWidth= " + emailWidth);
		int emailEndPoint = emailStartX + emailWidth;
		System.out.println("emailEndPoint= " + emailEndPoint);
		// password
		WebElement passwordTextField = driver.findElement(By.id("passContainer"));
		int passwordStartX = passwordTextField.getRect().getX();
		System.out.println("passwordStartX= " + passwordStartX);
		int passwordWidth = passwordTextField.getRect().getWidth();
		System.out.println("passwordWidth= " + passwordWidth);
		int passwordEndPoint = passwordStartX + passwordWidth;
		System.out.println("passwordEndPoint= " + passwordEndPoint);
		if (emailEndPoint == passwordEndPoint) {
			System.out.println("Pass: The email and password end point is verified and found correct.");
		} else {
			System.out.println("Fail: The email and password and point is verified and found incorrect.");
		}
	}

	/*
	 * Usage of id attribute
	 */

	@Test
	public void writeAScripToEnterTheDataIntoPasswordTextField() throws InterruptedException {
		driver.get("https://www.facebook.com");
		WebElement PasswordTextField = driver.findElement(By.id("pass"));
		PasswordTextField.sendKeys("123456789");
		Thread.sleep(2000);
	}

	/*
	 * Usage of name attribute
	 */

	public void checkWhetherTheUserIsAbleToClickOnLoginButton() {
		driver.get("https://www.facebook.com");
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
	}

	/*
	 * Use of enum in sendKeys()
	 */

	@Test
	public void writeAScripToEnterDataThroughKeyboardSimulations() throws InterruptedException {
		
		driver.get("https://demo.vtiger.com/vtigercrm/");
		
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.sendKeys(Keys.CONTROL + "a");
		usernameTextField.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		usernameTextField.sendKeys(Keys.chord("admin"));
		Thread.sleep(2000);
		
		WebElement passwordTextField = driver.findElement(By.id("password"));
		passwordTextField.sendKeys(Keys.CONTROL + "a");
		passwordTextField.sendKeys(Keys.DELETE);
		Thread.sleep(2000);
		passwordTextField.sendKeys(Keys.chord("admin"));
		Thread.sleep(2000);
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.submit();
	}

	/*
	 * Use of value attribute
	 */

	@Test
	public void writeAScripToGetTheAttributeValueOfUsernameTextField() throws InterruptedException {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		Thread.sleep(2000);
		WebElement usernameTextField = driver.findElement(By.id("username"));
		String userNameValue = usernameTextField.getAttribute("value");
		System.out.println("userNameValue= " + userNameValue);
		Assert.assertTrue(!userNameValue.isEmpty());
			usernameTextField.sendKeys("abc");
			usernameTextField.clear();
			Thread.sleep(2000);
			usernameTextField.sendKeys("xyz");
	}

	@Test
	public void verifyAltTextOfGroceryImgEleInFlipkart() {
		driver.get("https://www.flipkart.com/");
		WebElement groceryImg = driver.findElement(By.xpath("//a[@aria-label='Grocery']//img"));
		String groceryImgAltText = groceryImg.getAttribute("alt");
		System.out.println("groceryImgAltText= " + groceryImgAltText);
//		WebElement groceryImgAltText = driver.findElement(By.xpath("//img[contains(@src\"https://rukminim1.flipcart.com/flap/64/64/image/29')]"));
	}

	@Test
	public void verifyTheColorOfCreateNewAccountLink() {
		driver.get("https://www.facebook.com/");
		// Color is sel class
		// fromString()...static method...Color class
		// asHex()...non static method...from Color class..return type is String
		WebElement createNewAccountLink = driver.findElement(By.xpath("//a[text()='Create new account']"));
		String backgroundColorOfNewAcct = createNewAccountLink.getCssValue("background-color");
		System.out.println("backgroundColorOfNewAct" + backgroundColorOfNewAcct);
		String hexadecimalValue = Color.fromString(backgroundColorOfNewAcct).asHex();
		System.out.println("hexadecimalValue= " + hexadecimalValue);
	}

	@Test
	public void checkWhetherTheUserIsAbleToSeeTheElementInUI() {
		// ele is not present in the UI but the element source code is present in the
		// HTML DOM
		driver.get(
				"https://services.ecourts.gov.in/ecourtindia_v6/?p=casestatus/index&app_token=16c1b2afa0b7a24259d263d9aec08415b6ab01f089c0215c87826ee24zf7434a2");
		WebElement invisibleEle = driver.findElement(By.id("court_est_code"));
		if (invisibleEle.isDisplayed()) {
			System.out.println("method True");
			System.out.println("Client false");
		} else {
			System.out.println("method false");
			System.out.println("Client True");
		}
	}

	@Test
	public void writeAScriptToGetTheTextOfFacebookConnectQuoteOnLoginPage() {
		driver.get("https://www.facebook.com/");
		WebElement connectText = driver.findElement(By.xpath("//h2[@class='_8eso']"));
		String tagText = connectText.getText();
		System.out.println(tagText);
	}

	@Test
	public void writeAScripToClickOnFemaleRadioButtonOnFbSignUpPage() throws InterruptedException {
		driver.get("https://www.facebook.com/signup");
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@name='sex']/..//label[text()='Female']"));
		Thread.sleep(2000);
		femaleRadioButton.click();
		Thread.sleep(2000);
	}

	@Test
	public void checkWhetherTheEmailAndPasswordTextFieldsAreStartingWithTheSameLocationOnYAxis() {
		driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
		WebElement emailOrPhoneTxtFld = driver.findElement(By.name("email"));
		int emailOrPhoneStartY = emailOrPhoneTxtFld.getLocation().getY();
		System.out.println("emailOrPhonestartY= " + emailOrPhoneStartY);
		WebElement passwordTxtFld = driver.findElement(By.name("pass"));
		int passwordStartY = passwordTxtFld.getLocation().getY();
		System.out.println("passwordStartY= " + passwordStartY);
		if (emailOrPhoneStartY == passwordStartY) {
			System.out.println(
					"Pass:The location of email or phone and password are starting with the same location on y axis ");
		} else {
			System.out.println(
					"Fail:The location of email or phone and password are not starting with the same location on y axis ");
		}
	}

	@Test
	public void verifyTheSizeOfEmailAndNewPasswordTextFields() {
		driver.get("https://www.facebook.com/signup");
		// mobile number or email address
		WebElement mobNoOrEmailTextField = driver.findElement(By.name("reg_email__"));
		int mobNoOrEmailHeight = mobNoOrEmailTextField.getSize().getHeight();
		System.out.println("mobNoOrEmailHeight= " + mobNoOrEmailHeight);
		int mobNoOrEmailWidth = mobNoOrEmailTextField.getSize().getWidth();
		System.out.println("mobNoOrEmailWidth= " + mobNoOrEmailWidth);
		// New password
		WebElement newPasswordTextField = driver.findElement(By.name("reg_passwd__"));
		int newPasswordHeight = newPasswordTextField.getSize().getHeight();
		System.out.println("newPasswordHeight= " + newPasswordHeight);
		int newPasswordWidth = newPasswordTextField.getSize().getWidth();
		System.out.println("newPasswordWidth= " + newPasswordWidth);
		if (mobNoOrEmailHeight == newPasswordHeight && mobNoOrEmailWidth == newPasswordWidth) {
			System.out.println(
					"Pass:The mobile number or email address and New password size is verified and found correct");
		} else {
			System.out.println(
					"Fail:The mobile number or email address and New password size is verified and found incorrect");
		}
	}

	@Test
	public void verifyTheSizeOfFirstnameAndSurnameTextFields() {
		driver.get("https://www.facebook.com/signup");
		// firstname
		WebElement firstnameTextField = driver.findElement(By.name("firstname"));
		int firstnameHeight = firstnameTextField.getSize().getHeight();
		System.out.println("firstnameHeight= " + firstnameHeight);
		int firstnameWidth = firstnameTextField.getSize().getWidth();
		System.out.println("firstnameWidth= " + firstnameWidth);
		// surname
		WebElement surnameTextField = driver.findElement(By.name("lastname"));
		int surnameHeight = surnameTextField.getSize().getHeight();
		System.out.println("surnameHeight= " + surnameHeight);
		int surnameWidth = surnameTextField.getSize().getWidth();
		System.out.println("surnameWidth= " + surnameWidth);
		if (firstnameHeight == surnameHeight && firstnameWidth == surnameWidth) {
			System.out.println("Pass:The firstname and surname size is verified and found correct");
		} else {
			System.out.println("Fail:The firstname and surname size is verified and found incorrect");
		}
	}

	@Test
	public void writeAScripToGetTheBackgroundColorOfFacebookLoginButton() {
		driver.get("https://www.facebook.com/");
		WebElement loginButton = driver.findElement(By.name("login"));
		String backgroundColorOfLogin = loginButton.getCssValue("background-color");
		System.out.println("backgroundColorOfLogin= " + backgroundColorOfLogin);
		String hexadecimalValue = Color.fromString(backgroundColorOfLogin).asHex();
		System.out.println("hexadecimalValue= " + hexadecimalValue);
//		loginButton.click();
	}

	@Test
	public void verifyTheSizeOfEmailAndPasswordTextFieldsOnFacebookLoginPage() {
		driver.get("https://www.facebook.com/");
		// email
		WebElement emailTextField = driver.findElement(By.id("email"));
		int emailHeight = emailTextField.getSize().getHeight();
		System.out.println("emailHeight= " + emailHeight);
		int emailWidth = emailTextField.getSize().getWidth();
		System.out.println("emailWidth" + emailWidth);
		// password
		WebElement passwordTextField = driver.findElement(By.id("passContainer"));
		int passwordHeight = passwordTextField.getSize().getHeight();
		System.out.println("passwordHeight" + passwordHeight);
		int passwordWidth = passwordTextField.getSize().getWidth();
		System.out.println("passwordWidth=" + passwordWidth);
		if (emailHeight == passwordHeight && emailWidth == passwordWidth) {
			System.out.println("Pass: The size of email and password is verified and found correct");
		} else {
			System.out.println("Fail: The size of email and password is verified and found incorrect.");
		}
	}

	@Test
	public void verifyTheStartingPositionOfEmailAndPasswordTextFieldsOnFacebookLoginPage() {
		driver.get("https://www.facebook.com/");
		// email x-axis
		WebElement emailTextField = driver.findElement(By.id("email"));
		int emailStartX = emailTextField.getLocation().getX();
		System.out.println("emailStartX= " + emailStartX);
		// password x-axis
		WebElement passwordTextField = driver.findElement(By.id("passContainer"));
		int passwordStartX = passwordTextField.getLocation().getX();
		System.out.println("passwordStartX= " + passwordStartX);
		if (emailStartX == passwordStartX) {
			System.out.println("Pass: The starting location of email and password is verified and found correct");
		} else {
			System.out.println("Fail: The starting location of email and password is verified and found incorrect.");
		}
	}

	@Test
	public void verifyTheStateofSubmitOptionOnCowinWebpage() throws InterruptedException {
		driver.get("https://sandbox.abdm.gov.in/applications/cowin/Home/cowin_signup_form");
		Thread.sleep(2000);
		
		WebElement submitOpt = driver.findElement(By.name("submit"));
		Assert.assertTrue(!submitOpt.isEnabled());
		Thread.sleep(2000);

		WebElement acceptTermsOfServiceOpt = driver.findElement(By.xpath("//button[text()='Accept Terms of Service']"));
		Assert.assertTrue(!submitOpt.isSelected());
		acceptTermsOfServiceOpt.click();
		Thread.sleep(2000);
		
		WebElement acceptTermsOfServiceCheckBox = driver.findElement(By.id("confbtn"));
		Assert.assertTrue(!acceptTermsOfServiceCheckBox.isSelected());
		acceptTermsOfServiceCheckBox.click();
		Thread.sleep(2000);
		
		WebElement closeOpt = driver.findElement(By.xpath("//button[text()='Close']"));
		closeOpt.click();
		Thread.sleep(2000);
		submitOpt.click();
		Thread.sleep(2000);

	}

	@Test
	public void checkWhetherTheUserIsAbleToVerifyTheTagName() {
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.findElement(By.id("email"));
		String emailTagName = emailTextField.getTagName();
		if (emailTagName.equals("input")) {
			emailTextField.sendKeys("abc@gmail.com");
		} else {
			System.out
					.println("The text field is not created with input tag so we will not be able to append the data");
		}
	}

	@Test
	public void checkWhetherTheUserIsAbleToVerifyTheTagText() {
		driver.get("https://www.facebook.com/");
		WebElement forgottenPwdLink = driver
				.findElement(By.xpath("//a[contains(@href,'https://www.facebook.com/recover')]"));
		String linkText = forgottenPwdLink.getText();
		if (linkText.equals("Forgotten Password?")) {
			forgottenPwdLink.click();
		} else {
			System.out.println("Fail");
		}
	}

	@Test
	public void writeAScripToFetchTheToolTipTextOfTitleAttribute() {
		driver.get("https://www.flipkart.com/");
		WebElement flipkartLogo = driver.findElement(By.xpath(
				"//img[contains(@src,'https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkh')]"));
		String flipkartLogoTitle = flipkartLogo.getAttribute("title");
		System.out.println("flipkartLogoTitle= " + flipkartLogoTitle);
	}

	@Test
	public void checkWhetherTheUserIsAbleToSeeDayDropdownElementOnTheWebpage() {
		driver.get("https://www.facebook.com/signup");
		WebElement dayDropDown = driver.findElement(By.id("day"));
		if (dayDropDown.isDisplayed()) {
			System.out.println("A/c to method ---- True");
			System.out.println("A/c to client True");
		} else {
			System.out.println("A/c to method False");
			System.out.println("A/c to client False");
		}
	}

	@Test
	public void verifyYAxisOfEmailAndPasswordTextfieldsInFacebookForgotPwdPage() {
		driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
		WebElement emailTextField = driver.findElement(By.xpath("//input[@placeholder='Email or phone']"));
		int emailStartY = emailTextField.getLocation().getY();
		System.out.println("emailStartY= " + emailStartY);
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		int passwordStartY = passwordTextField.getLocation().getY();
		System.out.println("passwordStartY= " + passwordStartY);
		if (emailStartY == passwordStartY) {
			System.out.println(
					"Pass: The email and password text field are starting with the same location through Y-axis");
		} else {
			System.out.println(
					"Fail: The email and password text field are starting with the same location through Y-axis");
		}
	}

}
