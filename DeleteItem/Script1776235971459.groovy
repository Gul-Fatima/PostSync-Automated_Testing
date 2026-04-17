import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://127.0.0.1:8000/login/')

WebUI.setText(findTestObject('Page_Log In  PostSync/input_Enter your username'), 'admin')

WebUI.setEncryptedText(findTestObject('Page_Log In  PostSync/input_Enter your password'), 'tzH6RvlfSTg=')

WebUI.click(findTestObject('Page_Log In  PostSync/button_Sign in'))

WebUI.click(findTestObject('Page_Welcome  PostSync/img_The Trinity'))

WebUI.click(findTestObject('Page_The Trinity - PostSync  PostSync/a_Delete'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://127.0.0.1:8000/dashboard/', false)

WebUI.takeScreenshot()

WebUI.closeBrowser()

