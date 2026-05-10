import imc.service.CalculadoraIMC;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TesteCalculadoraIMC {

    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    @Test
    public void deveClassificarAdultoCaso1_BaixoPesoMuitoGrave() {
        assertClassificacao(15.99, 30, "masculino", "Baixo peso muito grave");
    }

    @Test
    public void deveClassificarAdultoCaso2_BaixoPesoGrave() {
        assertClassificacao(16.00, 30, "masculino", "Baixo peso grave");
    }

    @Test
    public void deveClassificarAdultoCaso3_BaixoPesoGrave() {
        assertClassificacao(16.99, 30, "masculino", "Baixo peso grave");
    }

    @Test
    public void deveClassificarAdultoCaso4_BaixoPeso() {
        assertClassificacao(17.00, 30, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarAdultoCaso5_BaixoPeso() {
        assertClassificacao(18.49, 30, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarAdultoCaso6_PesoNormal() {
        assertClassificacao(18.50, 30, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarAdultoCaso7_PesoNormal() {
        assertClassificacao(24.99, 30, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarAdultoCaso8_Sobrepeso() {
        assertClassificacao(25.00, 30, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarAdultoCaso9_Sobrepeso() {
        assertClassificacao(29.99, 30, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarAdultoCaso10_ObesidadeGrauI() {
        assertClassificacao(30.00, 30, "masculino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarAdultoCaso11_ObesidadeGrauI() {
        assertClassificacao(34.99, 30, "masculino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarAdultoCaso12_ObesidadeGrauII() {
        assertClassificacao(35.00, 30, "masculino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarAdultoCaso13_ObesidadeGrauII() {
        assertClassificacao(39.99, 30, "masculino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarAdultoCaso14_ObesidadeGrauIII() {
        assertClassificacao(40.01, 30, "masculino", "Obesidade grau III");
    }

    @Test
    public void deveClassificarIdosoHomemCaso1_BaixoPeso() {
        assertClassificacao(21.89, 66, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarIdosoHomemCaso2_PesoNormal() {
        assertClassificacao(22.00, 66, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarIdosoHomemCaso3_PesoNormal() {
        assertClassificacao(27.00, 66, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarIdosoHomemCaso4_Sobrepeso() {
        assertClassificacao(27.10, 66, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarIdosoHomemCaso5_Sobrepeso() {
        assertClassificacao(30.00, 66, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarIdosoHomemCaso6_ObesidadeGrauI() {
        assertClassificacao(30.10, 66, "masculino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarIdosoHomemCaso7_ObesidadeGrauI() {
        assertClassificacao(35.00, 66, "masculino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarIdosoHomemCaso8_ObesidadeGrauII() {
        assertClassificacao(35.10, 66, "masculino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarIdosoHomemCaso9_ObesidadeGrauII() {
        assertClassificacao(39.90, 66, "masculino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarIdosoHomemCaso10_ObesidadeGrauIII() {
        assertClassificacao(40.01, 66, "masculino", "Obesidade grau III");
    }

    @Test
    public void deveClassificarIdosaMulherCaso1_BaixoPeso() {
        assertClassificacao(21.89, 66, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarIdosaMulherCaso2_PesoNormal() {
        assertClassificacao(22.00, 66, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarIdosaMulherCaso3_PesoNormal() {
        assertClassificacao(27.00, 66, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarIdosaMulherCaso4_Sobrepeso() {
        assertClassificacao(27.10, 66, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarIdosaMulherCaso5_Sobrepeso() {
        assertClassificacao(32.00, 66, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarIdosaMulherCaso6_ObesidadeGrauI() {
        assertClassificacao(32.10, 66, "feminino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarIdosaMulherCaso7_ObesidadeGrauI() {
        assertClassificacao(37.00, 66, "feminino", "Obesidade grau I");
    }

    @Test
    public void deveClassificarIdosaMulherCaso8_ObesidadeGrauII() {
        assertClassificacao(37.10, 66, "feminino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarIdosaMulherCaso9_ObesidadeGrauII() {
        assertClassificacao(41.90, 66, "feminino", "Obesidade grau II");
    }

    @Test
    public void deveClassificarIdosaMulherCaso10_ObesidadeGrauIII() {
        assertClassificacao(42.01, 66, "feminino", "Obesidade grau III");
    }

    @Test
    public void deveClassificarMenino2AnosCaso1_BaixoPeso() {
        assertClassificacao(14.49, 2, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenino2AnosCaso2_PesoNormal() {
        assertClassificacao(14.50, 2, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino2AnosCaso3_PesoNormal() {
        assertClassificacao(17.99, 2, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino2AnosCaso4_Sobrepeso() {
        assertClassificacao(18.00, 2, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino2AnosCaso5_Sobrepeso() {
        assertClassificacao(18.99, 2, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino2AnosCaso6_Obesidade() {
        assertClassificacao(19.00, 2, "masculino", "Obesidade");
    }

    @Test
    public void deveClassificarMenino4AnosCaso1_BaixoPeso() {
        assertClassificacao(13.79, 4, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenino4AnosCaso2_PesoNormal() {
        assertClassificacao(13.80, 4, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino4AnosCaso3_PesoNormal() {
        assertClassificacao(17.39, 4, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino4AnosCaso4_Sobrepeso() {
        assertClassificacao(17.40, 4, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino4AnosCaso5_Sobrepeso() {
        assertClassificacao(18.29, 4, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino4AnosCaso6_Obesidade() {
        assertClassificacao(18.30, 4, "masculino", "Obesidade");
    }

    @Test
    public void deveClassificarMenino6AnosCaso1_BaixoPeso() {
        assertClassificacao(13.69, 6, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenino6AnosCaso2_PesoNormal() {
        assertClassificacao(13.70, 6, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino6AnosCaso3_PesoNormal() {
        assertClassificacao(17.69, 6, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino6AnosCaso4_Sobrepeso() {
        assertClassificacao(17.70, 6, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino6AnosCaso5_Sobrepeso() {
        assertClassificacao(18.79, 6, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino6AnosCaso6_Obesidade() {
        assertClassificacao(18.80, 6, "masculino", "Obesidade");
    }

    @Test
    public void deveClassificarMenino8AnosCaso1_BaixoPeso() {
        assertClassificacao(13.99, 8, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenino8AnosCaso2_PesoNormal() {
        assertClassificacao(14.00, 8, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino8AnosCaso3_PesoNormal() {
        assertClassificacao(18.99, 8, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino8AnosCaso4_Sobrepeso() {
        assertClassificacao(19.00, 8, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino8AnosCaso5_Sobrepeso() {
        assertClassificacao(20.29, 8, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino8AnosCaso6_Obesidade() {
        assertClassificacao(20.30, 8, "masculino", "Obesidade");
    }

    @Test
    public void deveClassificarMenino10AnosCaso1_BaixoPeso() {
        assertClassificacao(14.59, 10, "masculino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenino10AnosCaso2_PesoNormal() {
        assertClassificacao(14.60, 10, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino10AnosCaso3_PesoNormal() {
        assertClassificacao(20.49, 10, "masculino", "Peso normal");
    }

    @Test
    public void deveClassificarMenino10AnosCaso4_Sobrepeso() {
        assertClassificacao(20.50, 10, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino10AnosCaso5_Sobrepeso() {
        assertClassificacao(22.49, 10, "masculino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenino10AnosCaso6_Obesidade() {
        assertClassificacao(22.50, 10, "masculino", "Obesidade");
    }

    @Test
    public void deveClassificarMenina2AnosCaso1_BaixoPeso() {
        assertClassificacao(14.29, 2, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenina2AnosCaso2_PesoNormal() {
        assertClassificacao(14.30, 2, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina2AnosCaso3_PesoNormal() {
        assertClassificacao(17.99, 2, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina2AnosCaso4_Sobrepeso() {
        assertClassificacao(18.00, 2, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina2AnosCaso5_Sobrepeso() {
        assertClassificacao(18.99, 2, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina2AnosCaso6_Obesidade() {
        assertClassificacao(19.00, 2, "feminino", "Obesidade");
    }

    @Test
    public void deveClassificarMenina4AnosCaso1_BaixoPeso() {
        assertClassificacao(13.49, 4, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenina4AnosCaso2_PesoNormal() {
        assertClassificacao(13.50, 4, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina4AnosCaso3_PesoNormal() {
        assertClassificacao(17.19, 4, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina4AnosCaso4_Sobrepeso() {
        assertClassificacao(17.20, 4, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina4AnosCaso5_Sobrepeso() {
        assertClassificacao(18.19, 4, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina4AnosCaso6_Obesidade() {
        assertClassificacao(18.20, 4, "feminino", "Obesidade");
    }

    @Test
    public void deveClassificarMenina6AnosCaso1_BaixoPeso() {
        assertClassificacao(13.39, 6, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenina6AnosCaso2_PesoNormal() {
        assertClassificacao(13.40, 6, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina6AnosCaso3_PesoNormal() {
        assertClassificacao(17.49, 6, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina6AnosCaso4_Sobrepeso() {
        assertClassificacao(17.50, 6, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina6AnosCaso5_Sobrepeso() {
        assertClassificacao(18.69, 6, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina6AnosCaso6_Obesidade() {
        assertClassificacao(18.70, 6, "feminino", "Obesidade");
    }

    @Test
    public void deveClassificarMenina8AnosCaso1_BaixoPeso() {
        assertClassificacao(13.79, 8, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenina8AnosCaso2_PesoNormal() {
        assertClassificacao(13.80, 8, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina8AnosCaso3_PesoNormal() {
        assertClassificacao(18.79, 8, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina8AnosCaso4_Sobrepeso() {
        assertClassificacao(18.80, 8, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina8AnosCaso5_Sobrepeso() {
        assertClassificacao(20.49, 8, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina8AnosCaso6_Obesidade() {
        assertClassificacao(20.50, 8, "feminino", "Obesidade");
    }

    @Test
    public void deveClassificarMenina10AnosCaso1_BaixoPeso() {
        assertClassificacao(14.29, 10, "feminino", "Baixo peso");
    }

    @Test
    public void deveClassificarMenina10AnosCaso2_PesoNormal() {
        assertClassificacao(14.30, 10, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina10AnosCaso3_PesoNormal() {
        assertClassificacao(20.19, 10, "feminino", "Peso normal");
    }

    @Test
    public void deveClassificarMenina10AnosCaso4_Sobrepeso() {
        assertClassificacao(20.20, 10, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina10AnosCaso5_Sobrepeso() {
        assertClassificacao(22.79, 10, "feminino", "Sobrepeso");
    }

    @Test
    public void deveClassificarMenina10AnosCaso6_Obesidade() {
        assertClassificacao(22.80, 10, "feminino", "Obesidade");
    }

    private void assertClassificacao(double imcEsperado, int idade, String sexo, String classificacaoEsperada) {
        double altura = 1.00;
        double peso = imcEsperado;

        String resultado = calculadora.calcularIMC(peso, altura, idade, sexo);
        String esperado = String.format(Locale.US, "IMC: %.2f - Classificacao: %s", imcEsperado, classificacaoEsperada);

        Assert.assertEquals(esperado, resultado);
    }
}
