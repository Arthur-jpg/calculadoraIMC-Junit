package imc.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class CalculadoraIMCSimples implements CalculadoraIMCService {

    @Override
    public String calcularIMC(double peso, double altura, int idade, String sexo) {
        validarEntradas(peso, altura, idade, sexo);

        String sexoNormalizado = sexo.trim().toLowerCase(Locale.ROOT);
        double imc = arredondar2Casas(peso / (altura * altura));
        String classificacao;

        if (idade >= 20 && idade <= 65) {
            classificacao = classificarAdulto(imc);
        } else if (idade > 65) {
            classificacao = classificarIdoso(imc, sexoNormalizado);
        } else {
            classificacao = classificarCrianca(imc, idade, sexoNormalizado);
        }

        return String.format(Locale.US, "IMC: %.2f - Classificacao: %s", imc, classificacao);
    }

    private void validarEntradas(double peso, double altura, int idade, String sexo) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade nao pode ser negativa.");
        }
        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException("Sexo deve ser informado.");
        }

        String normalizado = sexo.trim().toLowerCase(Locale.ROOT);
        if (!"masculino".equals(normalizado) && !"feminino".equals(normalizado)) {
            throw new IllegalArgumentException("Sexo invalido. Use 'masculino' ou 'feminino'.");
        }
    }

    private double arredondar2Casas(double valor) {
        return BigDecimal.valueOf(valor)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private String classificarAdulto(double imc) {
        if (imc < 16.00) return "Baixo peso muito grave";
        if (imc < 17.00) return "Baixo peso grave";
        if (imc < 18.50) return "Baixo peso";
        if (imc < 25.00) return "Peso normal";
        if (imc < 30.00) return "Sobrepeso";
        if (imc < 35.00) return "Obesidade grau I";
        if (imc < 40.00) return "Obesidade grau II";
        return "Obesidade grau III";
    }

    private String classificarIdoso(double imc, String sexo) {
        if (imc < 22.00) return "Baixo peso";
        if (imc <= 27.00) return "Peso normal";

        if ("feminino".equals(sexo)) {
            if (imc <= 32.00) return "Sobrepeso";
            if (imc <= 37.00) return "Obesidade grau I";
            if (imc <= 41.90) return "Obesidade grau II";
            return "Obesidade grau III";
        }

        if (imc <= 30.00) return "Sobrepeso";
        if (imc <= 35.00) return "Obesidade grau I";
        if (imc <= 39.90) return "Obesidade grau II";
        return "Obesidade grau III";
    }

    private String classificarCrianca(double imc, int idade, String sexo) {
        double p5;
        double p85;
        double p95;

        if ("masculino".equals(sexo)) {
            if (idade == 2) {
                p5 = 14.5; p85 = 18.0; p95 = 19.0;
            } else if (idade == 4) {
                p5 = 13.8; p85 = 17.4; p95 = 18.3;
            } else if (idade == 6) {
                p5 = 13.7; p85 = 17.7; p95 = 18.8;
            } else if (idade == 8) {
                p5 = 14.0; p85 = 19.0; p95 = 20.3;
            } else if (idade == 10) {
                p5 = 14.6; p85 = 20.5; p95 = 22.5;
            } else {
                throw new IllegalArgumentException("Idade infantil nao suportada. Use: 2, 4, 6, 8 ou 10.");
            }
        } else {
            if (idade == 2) {
                p5 = 14.3; p85 = 18.0; p95 = 19.0;
            } else if (idade == 4) {
                p5 = 13.5; p85 = 17.2; p95 = 18.2;
            } else if (idade == 6) {
                p5 = 13.4; p85 = 17.5; p95 = 18.7;
            } else if (idade == 8) {
                p5 = 13.8; p85 = 18.8; p95 = 20.5;
            } else if (idade == 10) {
                p5 = 14.3; p85 = 20.2; p95 = 22.8;
            } else {
                throw new IllegalArgumentException("Idade infantil nao suportada. Use: 2, 4, 6, 8 ou 10.");
            }
        }

        if (imc < p5) return "Baixo peso";
        if (imc < p85) return "Peso normal";
        if (imc < p95) return "Sobrepeso";
        return "Obesidade";
    }
}
