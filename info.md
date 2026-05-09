# Projeto — Algoritmo de IMC com JUnit e Análise de Valor Limite
# Objetivo
O objetivo do projeto é implementar um algoritmo que:
1. Calcule o IMC
2. Classifique o indivíduo com base em:
   - idade
   - sexo
   - IMC
3. Utilize:
   - JUnit
   - análise de valor limite (Boundary Value Analysis)
---
# Fórmula do IMC
A fórmula é igual para TODOS os casos:
\[
IMC = \frac{peso}{altura^2}
\]
Onde:
- peso em kg
- altura em metros
---
# Fluxo Geral do Algoritmo
```java id="rgtz2w"
double imc = peso / (altura * altura);
if (idade >= 20 && idade <= 65) {
    return classificarAdulto(imc);
}
if (idade > 65) {
    return classificarIdoso(imc, sexo);
}
return classificarCrianca(imc, idade, sexo);

⸻

Classificação — Adultos (20 até 65 anos)

IMPORTANTE

Esses valores DEVEM ser exatamente iguais ao artigo.

Regras Oficiais

Faixa	Intervalo
Baixo peso muito grave	IMC < 16
Baixo peso grave	16 ≤ IMC ≤ 16.99
Baixo peso	17 ≤ IMC ≤ 18.49
Peso normal	18.50 ≤ IMC ≤ 24.99
Sobrepeso	25 ≤ IMC ≤ 29.99
Obesidade grau I	30 ≤ IMC ≤ 34.99
Obesidade grau II	35 ≤ IMC ≤ 39.99
Obesidade grau III	IMC > 40

⸻


Classificação — Mulheres acima de 65 anos

Regras Oficiais

Faixa	Intervalo
Baixo peso	IMC < 21.9
Peso normal	22 ≤ IMC ≤ 27
Sobrepeso	27.1 ≤ IMC ≤ 32
Obesidade grau I	32.1 ≤ IMC ≤ 37
Obesidade grau II	37.1 ≤ IMC ≤ 41.9
Obesidade grau III	IMC > 42

⸻


Classificação — Homens acima de 65 anos

Regras Oficiais

Faixa	Intervalo
Baixo peso	IMC < 21.9
Peso normal	22 ≤ IMC ≤ 27
Sobrepeso	27.1 ≤ IMC ≤ 30
Obesidade grau I	30.1 ≤ IMC ≤ 35
Obesidade grau II	35.1 ≤ IMC ≤ 39.9
Obesidade grau III	IMC > 40

⸻

Classificação Infantil

IMPORTANTE

Na classificação infantil:

* o IMC é calculado normalmente
* o resultado depende:
    * da idade
    * do sexo
    * do percentil do gráfico

⸻

Regras Oficiais do Artigo

Faixa	Percentil
Baixo peso	abaixo do percentil 5
Peso normal	entre percentil 5 e 85
Sobrepeso	entre percentil 85 e 95
Obesidade	acima do percentil 95

⸻

Estratégia Recomendada para Crianças

O professor pediu:

* interpretar manualmente o gráfico
* pegar valores específicos
* implementar apenas:
    * 2 anos
    * 4 anos
    * 6 anos
    * 8 anos
    * 10 anos

Para:

* meninos
* meninas

⸻

Estrutura Recomendada

Cada idade deve possuir:

* limite percentil 5
* limite percentil 85
* limite percentil 95

⸻

Valores Aproximados — Meninos

IMPORTANTE

Esses valores devem ser retirados diretamente do gráfico.

Exemplo de interpretação

Idade	P5	P85	P95
2	14.5	18.0	19.0
4	13.8	17.4	18.3
6	13.7	17.7	18.8
8	14.0	19.0	20.3
10	14.6	20.5	22.5

⸻

Valores Aproximados — Meninas

Idade	P5	P85	P95
2	14.3	18.0	19.0
4	13.5	17.2	18.2
6	13.4	17.5	18.7
8	13.8	18.8	20.5
10	14.3	20.2	22.8

