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
 * TC_AUTO_03_BuscaCatalogo
 * Objetivo: validar a busca por nome e o filtro por categoria no catalogo de produtos.
 * Dados de entrada: termo de busca "Racao"; categoria "CACHORRO".
 * Dados de saida esperados: resultado filtrado exibe apenas produtos com "Racao" no nome;
 * ao filtrar por categoria, o catalogo volta a exibir produtos daquela categoria.
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

TestObject tabServicos = new TestObject('tab_Servicos')
tabServicos.addProperty('xpath', ConditionType.EQUALS, "//a[@href='/MainTabs/Servicos']")

WebUI.click(tabServicos)

TestObject tileMedicamentosDesconto = new TestObject('tile_MedicamentosComDesconto')
tileMedicamentosDesconto.addProperty('xpath', ConditionType.EQUALS,
	"//*[contains(text(),'DESCONTO')]/ancestor::div[@tabindex='0'][1]")

WebUI.click(tileMedicamentosDesconto)

TestObject inputBusca = new TestObject('input_BuscarProduto')
inputBusca.addProperty('xpath', ConditionType.EQUALS, "//input[@aria-label='Buscar produto pelo nome']")

WebUI.setText(inputBusca, 'Ração')

TestObject resultadoRacao = new TestObject('button_ResultadoRacao')
resultadoRacao.addProperty('xpath', ConditionType.EQUALS,
	"//button[starts-with(@aria-label,'Ver detalhes de') and contains(@aria-label,'Ração')]")

WebUI.verifyElementPresent(resultadoRacao, 10)

WebUI.clearText(inputBusca)

TestObject filtroCachorro = new TestObject('button_FiltrarCachorro')
filtroCachorro.addProperty('xpath', ConditionType.EQUALS, "//button[@aria-label='Filtrar por CACHORRO']")

WebUI.click(filtroCachorro)

TestObject textResultados = new TestObject('text_ProdutosEncontrados')
textResultados.addProperty('xpath', ConditionType.EQUALS, "//*[contains(., 'produtos encontrados') or contains(., 'produto encontrado')][not(.//*[contains(., 'produtos encontrados') or contains(., 'produto encontrado')])]")

WebUI.verifyElementPresent(textResultados, 10)

WebUI.closeBrowser()
