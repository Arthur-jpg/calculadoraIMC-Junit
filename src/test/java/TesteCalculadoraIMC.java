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

    private void assertClassificacao(double imcEsperado, int idade, String sexo, String classificacaoEsperada) {
        double altura = 1.00;
        double peso = imcEsperado;

        String resultado = calculadora.calcularIMC(peso, altura, idade, sexo);
        String esperado = String.format(Locale.US, "IMC: %.2f - Classificacao: %s", imcEsperado, classificacaoEsperada);

        Assert.assertEquals(esperado, resultado);
    }
}
