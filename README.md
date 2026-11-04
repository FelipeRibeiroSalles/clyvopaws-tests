# ClyvoPaws — Automação de Testes (Sprint 4)

Evidência de automação de testes do ClyvoPaws (FIAP Challenge 2026), exigida na Parte B do Sprint 4 — Compliance, Quality Assurance & Tests.

## Ferramenta

**Katalon Studio 11.7** (WebUI, Groovy). O sistema testável neste momento (app mobile em React Native) roda como aplicação web via `expo start --web`, o que permite automação no navegador (Chrome).

## Casos de teste automatizados

| Caso | Fluxo | Teste manual (Azure Boards) | Status |
|---|---|---|---|
| [`TC_AUTO_02_Login`](./Scripts/TC_AUTO_02_Login) | Login com credenciais válidas e verificação da Home autenticada | TC02 | Passou (16/16 passos) |
| [`TC_AUTO_03_BuscaCatalogo`](./Scripts/TC_AUTO_03_BuscaCatalogo) | Busca por nome ("Ração") e filtro por categoria (CACHORRO) | TC05 | Passou (32/32 passos) |
| [`TC_AUTO_04_AdicionarCarrinho`](./Scripts/TC_AUTO_04_AdicionarCarrinho) | Adicionar produto ao carrinho com quantidade 2 e conferir o total | TC06 | Passou (37/37 passos) |
| [`TC_AUTO_05_RemoverCarrinho`](./Scripts/TC_AUTO_05_RemoverCarrinho) | Adicionar produto ao carrinho e remover o item, confirmando que ele some | TC07 | Passou (42/42 passos) |

Os testes usam localizadores XPath baseados em `aria-label` (gerado pelo `accessibilityLabel` do React Native Web) e uma conta de teste já existente (`art@gmail.com`, conta de teste exclusiva para QA).

## Como executar

1. Clonar o app mobile: `git clone https://github.com/Jppcamilo/clyvopaws-mobile`
2. `cd clyvopaws-mobile/clyvo-paws && npm ci`
3. `npx expo start --web` — o app deve responder em `http://localhost:8081`.
4. No Katalon Studio: **File → Open Project** e abrir a pasta deste repositório.
5. Garantir que o Google Chrome esteja instalado e que o backend esteja no ar.
6. Executar cada Test Case (`TC_AUTO_02_Login`, `TC_AUTO_03_BuscaCatalogo`, `TC_AUTO_04_AdicionarCarrinho`, `TC_AUTO_05_RemoverCarrinho`) com o navegador Chrome.

## Evidências

- Vídeo de configuração, execução e resultados: https://youtu.be/j0sr4WivzfU
- Plano de teste manual (Test Plan 173, suíte 175) no Azure Boards: https://dev.azure.com/RM565224/ClyvoPaws/_testPlans/define?planId=173&suiteId=175

## Plano de teste manual

O plano de teste manual completo (objetivos, dados de entrada/saída e procedimento de cada caso) está documentado como Test Plan/Test Cases no Azure Boards do projeto (link acima).
