import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// =========================
// LOGIN
// =========================
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/')

WebUI.click(findTestObject('Page_Welcome  PostSync/a_Login'))

WebUI.setText(findTestObject('Page_Log In  PostSync/input_Enter your username'), 'Gul-Fatima')
WebUI.setEncryptedText(findTestObject('Page_Log In  PostSync/input_Enter your password'), '4mQrzaQ12cgE+VFfFzsxvQ==')

WebUI.click(findTestObject('Page_Log In  PostSync/button_Sign in'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://127.0.0.1:8000/', false)


// =========================
// NAVIGATE TO PRODUCT
// =========================
WebUI.click(findTestObject('Page_Welcome  PostSync/img_The Trinity'))
WebUI.click(findTestObject('Page_The Trinity - PostSync  PostSync/a_Add to Cart'))

WebUI.switchToWindowTitle('Home | PostSync')


// =========================
// INVALID INPUT TEST (0)
// =========================
WebUI.setText(findTestObject('Page_Home  PostSync/input_Quantity'), '0')
WebUI.click(findTestObject('Page_Home  PostSync/button_Add to Cart'))


// =========================
// VERIFY we can't move to checkout page - since 0 not allowed
// =========================
WebUI.verifyNotMatch(WebUI.getUrl(), '.*checkout.*', true)



WebUI.takeScreenshot()
WebUI.closeBrowser()