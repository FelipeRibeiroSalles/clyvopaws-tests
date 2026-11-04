# ClyvoPaws — Automação de Testes (Sprint 4)

Este repositório contém a evidência de automação de testes do ClyvoPaws (FIAP Challenge 2026), exigida na Parte B do Sprint 4 — Compliance, Quality Assurance & Tests.

## Ferramenta

**Selenium IDE**, usada porque o sistema testável neste momento (app mobile em React Native) roda como aplicação web via `expo start --web`, permitindo gravação e execução no navegador.

## Casos de teste automatizados

Arquivo do projeto: [`ClyvoPaws_Automacao.side`](./ClyvoPaws_Automacao.side) — importar no Selenium IDE (Menu → Import).

| Caso | Fluxo |
|---|---|
| TC_AUTO_01 | Cadastro de novo tutor |
| TC_AUTO_02 | Login com credenciais válidas |
| TC_AUTO_03 | Buscar produto no catálogo pelo nome |
| TC_AUTO_04 | Adicionar produto ao carrinho |

## Como executar

1. Clonar o app mobile: `git clone https://github.com/Jppcamilo/clyvopaws-mobile`
2. `cd clyvopaws-mobile/clyvo-paws && npm ci`
3. `npx expo start --web` e anotar a porta exibida no terminal (ex.: `http://localhost:8081`)
4. No arquivo `ClyvoPaws_Automacao.side`, ajustar a URL base (`url` e `urls`) para a porta real, se diferente.
5. Garantir que a conta de QA (`qa.clyvopaws@teste.com` / `Teste@123`) já esteja cadastrada no backend antes de rodar TC_AUTO_02/03/04.
6. Abrir o Selenium IDE, importar o arquivo `.side` e rodar a suíte "ClyvoPaws - Suite de Automação (Sprint 4)".

## Evidências

- Vídeo de configuração, execução e resultados: **[LINK DO VÍDEO]**
- Projeto no Azure Boards (correção do teste manual): https://dev.azure.com/RM565224/ClyvoPaws

## Plano de teste manual

O plano de teste manual completo (objetivos, dados de entrada/saída e procedimento de cada caso) está documentado como Test Plan/Test Cases no Azure Boards do projeto (link acima).
