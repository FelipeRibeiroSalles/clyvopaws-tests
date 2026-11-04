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
 * TC_AUTO_05_RemoverCarrinho
 * Objetivo: validar que um item do carrinho pode ser removido.
 * Dados de entrada: primeiro produto do catalogo adicionado ao carrinho; acao "Remover".
 * Dados de saida esperados: o botao "Remover <produto>" daquele item deixa de existir no carrinho.
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

TestObject primeiroProduto = new TestObject('button_PrimeiroProduto')
primeiroProduto.addProperty('xpath', ConditionType.EQUALS,
	"(//button[starts-with(@aria-label,'Ver detalhes de')])[1]")

WebUI.click(primeiroProduto)

TestObject botaoAumentar = new TestObject('button_AumentarQuantidade')
botaoAumentar.addProperty('xpath', ConditionType.EQUALS,
	"//button[starts-with(@aria-label,'Aumentar quantidade de')]")

WebUI.click(botaoAumentar)

TestObject botaoAdicionar = new TestObject('button_AdicionarAoCarrinho')
botaoAdicionar.addProperty('xpath', ConditionType.EQUALS, "//button[contains(., 'Adicionar ao carrinho')]")

WebUI.click(botaoAdicionar)

TestObject textoConfirmacao = new TestObject('text_ConfirmacaoAdicionado')
textoConfirmacao.addProperty('xpath', ConditionType.EQUALS, "//*[contains(text(),'Produto adicionado ao carrinho')]")

WebUI.verifyElementPresent(textoConfirmacao, 10)

TestObject botaoVerCarrinho = new TestObject('button_VerMeuCarrinho')
botaoVerCarrinho.addProperty('xpath', ConditionType.EQUALS, "//*[contains(text(),'Ver meu carrinho')]")

WebUI.click(botaoVerCarrinho)

TestObject primeiroRemover = new TestObject('button_PrimeiroRemover')
primeiroRemover.addProperty('xpath', ConditionType.EQUALS, "(//button[starts-with(@aria-label,'Remover ')])[1]")

WebUI.verifyElementPresent(primeiroRemover, 10)

String rotulo = WebUI.getAttribute(primeiroRemover, 'aria-label')

WebUI.click(primeiroRemover)

TestObject itemRemovido = new TestObject('button_ItemRemovido')
itemRemovido.addProperty('xpath', ConditionType.EQUALS, "//button[@aria-label='" + rotulo + "']")

WebUI.verifyElementNotPresent(itemRemovido, 10)

WebUI.closeBrowser()
