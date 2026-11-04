import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 * TC_AUTO_02_Login
 * Objetivo: validar que um tutor ja cadastrado consegue autenticar e acessar a area
 * privada do app (ClyvoPaws rodando em http://localhost:8081 via "npx expo start --web").
 * Dados de entrada: conta de tutor ja existente (conta de teste de QA).
 * Dados de saida esperados: Home autenticada exibida (secao "MAIS ACESSADOS" visivel).
 */

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8081')

WebUI.maximizeWindow()

TestObject inputEmail = new TestObject('input_Email')

inputEmail.addProperty('xpath', ConditionType.EQUALS, "//input[@aria-label='E-mail']")

TestObject inputSenha = new TestObject('input_Senha')

inputSenha.addProperty('xpath', ConditionType.EQUALS, "//input[@aria-label='Senha']")

TestObject buttonEntrar = new TestObject('button_EntrarNaConta')

buttonEntrar.addProperty('xpath', ConditionType.EQUALS, "//button[@aria-label='Entrar na conta']")

WebUI.setText(inputEmail, 'art@gmail.com')

WebUI.setText(inputSenha, 'Jp281801_-')

WebUI.click(buttonEntrar)

TestObject textMaisAcessados = new TestObject('text_MaisAcessados')

textMaisAcessados.addProperty('xpath', ConditionType.EQUALS, "//*[contains(text(),'MAIS ACESSADOS')]")

WebUI.verifyElementPresent(textMaisAcessados, 15)

WebUI.closeBrowser()
