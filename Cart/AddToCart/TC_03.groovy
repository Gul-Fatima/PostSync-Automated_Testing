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

WebUI.sendKeys(findTestObject('Page_Log In  PostSync/input_Enter your username'), Keys.chord(Keys.ENTER))

WebUI.setEncryptedText(findTestObject('Page_Log In  PostSync/input_Enter your password'), '4mQrzaQ12cgE+VFfFzsxvQ==')

WebUI.click(findTestObject('Page_Log In  PostSync/button_Sign in'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://127.0.0.1:8000/', false)


// =========================
// FIRST ADD (qty = 3)
// =========================
WebUI.click(findTestObject('Page_Welcome  PostSync/img_The Trinity'))

WebUI.click(findTestObject('Page_The Trinity - PostSync  PostSync/a_Add to Cart'))

WebUI.switchToWindowTitle('Home | PostSync')

WebUI.setText(findTestObject('Page_Home  PostSync/input_Quantity'), '3')

WebUI.click(findTestObject('Page_Home  PostSync/button_Add to Cart'))


// =========================
// GET EXISTING QUANTITY FROM CART
// =========================
WebUI.navigateToUrl('http://127.0.0.1:8000/cart/')

TestObject qtyObject = new TestObject().addProperty(
    "xpath",
    ConditionType.EQUALS,
    "//table//tr[1]/td[2]"
)

String existingQtyText = WebUI.getText(qtyObject)
int existingQty = Integer.parseInt(existingQtyText)


// =========================
// SECOND ADD (qty = 2)
// =========================
WebUI.navigateToUrl('http://127.0.0.1:8000/')

WebUI.click(findTestObject('Page_Welcome  PostSync/img_The Trinity'))

WebUI.click(findTestObject('Page_The Trinity - PostSync  PostSync/a_Add to Cart'))

WebUI.switchToWindowTitle('Home | PostSync')

WebUI.setText(findTestObject('Page_Home  PostSync/input_Quantity'), '2')

WebUI.click(findTestObject('Page_Home  PostSync/button_Add to Cart'))


// =========================
// FINAL VERIFY (DYNAMIC)
// =========================
WebUI.navigateToUrl('http://127.0.0.1:8000/cart/')

String updatedQtyText = WebUI.getText(qtyObject)
int updatedQty = Integer.parseInt(updatedQtyText)

int expectedQty = existingQty + 2

WebUI.verifyEqual(updatedQty, expectedQty)

WebUI.takeScreenshot()
WebUI.closeBrowser()