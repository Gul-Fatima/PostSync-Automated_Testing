import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

// =========================
// STATIC CHECKING (SETUP)
// =========================

// Login
WebUI.openBrowser('')

WebUI.navigateToUrl('http://127.0.0.1:8000/')

WebUI.click(findTestObject('Page_Welcome  PostSync/a_Login'))

WebUI.setText(findTestObject('Page_Log In  PostSync/input_Enter your username'), 'Gul-Fatima')

WebUI.sendKeys(findTestObject('Page_Log In  PostSync/input_Enter your username'), Keys.chord(Keys.ENTER))

WebUI.setEncryptedText(findTestObject('Page_Log In  PostSync/input_Enter your password'), '4mQrzaQ12cgE+VFfFzsxvQ==')

WebUI.click(findTestObject('Page_Log In  PostSync/button_Sign in'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://127.0.0.1:8000/', false)


// =========================
// STATIC CHECKING (FLOW)
// =========================

WebUI.click(findTestObject('Page_Welcome  PostSync/img_The Trinity'))

WebUI.click(findTestObject('Page_The Trinity - PostSync  PostSync/a_Add to Cart'))

WebUI.switchToWindowTitle('Home | PostSync')

WebUI.setText(findTestObject('Page_Home  PostSync/input_Quantity'), '2')

WebUI.click(findTestObject('Page_Home  PostSync/button_Add to Cart'))


// =========================
// DYNAMIC CHECKING (VALIDATION)
// =========================

// Verify redirected to cart page
WebUI.verifyMatch(WebUI.getUrl(), '.*cart.*', true)

// Verify quantity is displayed correctly
WebUI.verifyTextPresent('2', false)

WebUI.takeScreenshot()

WebUI.closeBrowser()