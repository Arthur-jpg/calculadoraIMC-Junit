import imc.model.ResultadoIMC;
import imc.service.CalculadoraIMC;
import imc.service.CalculadoraIMCSimples;
import imc.service.CalculadoraIMCService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteCalculadoraIMC {

    // Escolha manual da implementacao para os testes
    private static final String IMPLEMENTACAO = "avancada";
    // private static final String IMPLEMENTACAO = "simples";

    private CalculadoraIMCService calculadora;

    @Before
    public void setup() {
        if ("simples".equalsIgnoreCase(IMPLEMENTACAO)) {
            calculadora = new CalculadoraIMCSimples();
        } else {
            calculadora = new CalculadoraIMC();
        }
    }

    @Test
    public void homemadulto_baixo_peso_muito_grave_caso01() {
        ResultadoIMC resultado = calculadora.calcularIMC(46.21, 1.70, 30, "masculino");
        Assert.assertEquals(15.99, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso muito grave", resultado.classificacao());
    }

    @Test
    public void homemadulto_baixo_peso_grave_caso02() {
        ResultadoIMC resultado = calculadora.calcularIMC(46.24, 1.70, 30, "masculino");
        Assert.assertEquals(16.00, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso grave", resultado.classificacao());
    }

    @Test
    public void homemadulto_baixo_peso_grave_caso03() {
        ResultadoIMC resultado = calculadora.calcularIMC(49.10, 1.70, 30, "masculino");
        Assert.assertEquals(16.99, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso grave", resultado.classificacao());
    }

    @Test
    public void homemadulto_baixo_peso_caso04() {
        ResultadoIMC resultado = calculadora.calcularIMC(49.13, 1.70, 30, "masculino");
        Assert.assertEquals(17.00, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void homemadulto_baixo_peso_caso05() {
        ResultadoIMC resultado = calculadora.calcularIMC(53.44, 1.70, 30, "masculino");
        Assert.assertEquals(18.49, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void homemadulto_peso_normal_caso06() {
        ResultadoIMC resultado = calculadora.calcularIMC(53.47, 1.70, 30, "masculino");
        Assert.assertEquals(18.50, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void homemadulto_peso_normal_caso07() {
        ResultadoIMC resultado = calculadora.calcularIMC(72.22, 1.70, 30, "masculino");
        Assert.assertEquals(24.99, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void homemadulto_sobrepeso_caso08() {
        ResultadoIMC resultado = calculadora.calcularIMC(72.25, 1.70, 30, "masculino");
        Assert.assertEquals(25.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void homemadulto_sobrepeso_caso09() {
        ResultadoIMC resultado = calculadora.calcularIMC(86.67, 1.70, 30, "masculino");
        Assert.assertEquals(29.99, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void homemadulto_obesidade_grau_i_caso10() {
        ResultadoIMC resultado = calculadora.calcularIMC(86.70, 1.70, 30, "masculino");
        Assert.assertEquals(30.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void homemadulto_obesidade_grau_i_caso11() {
        ResultadoIMC resultado = calculadora.calcularIMC(101.12, 1.70, 30, "masculino");
        Assert.assertEquals(34.99, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void homemadulto_obesidade_grau_ii_caso12() {
        ResultadoIMC resultado = calculadora.calcularIMC(101.15, 1.70, 30, "masculino");
        Assert.assertEquals(35.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void homemadulto_obesidade_grau_ii_caso13() {
        ResultadoIMC resultado = calculadora.calcularIMC(115.57, 1.70, 30, "masculino");
        Assert.assertEquals(39.99, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void homemadulto_obesidade_grau_iii_caso14() {
        ResultadoIMC resultado = calculadora.calcularIMC(115.63, 1.70, 30, "masculino");
        Assert.assertEquals(40.01, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau III", resultado.classificacao());
    }

    @Test
    public void homemidoso_baixo_peso_caso15() {
        ResultadoIMC resultado = calculadora.calcularIMC(63.26, 1.70, 70, "masculino");
        Assert.assertEquals(21.99, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void homemidoso_peso_normal_caso16() {
        ResultadoIMC resultado = calculadora.calcularIMC(63.58, 1.70, 70, "masculino");
        Assert.assertEquals(22.00, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void homemidoso_peso_normal_caso17() {
        ResultadoIMC resultado = calculadora.calcularIMC(78.03, 1.70, 70, "masculino");
        Assert.assertEquals(27.00, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void homemidoso_sobrepeso_caso18() {
        ResultadoIMC resultado = calculadora.calcularIMC(78.32, 1.70, 70, "masculino");
        Assert.assertEquals(27.10, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void homemidoso_sobrepeso_caso19() {
        ResultadoIMC resultado = calculadora.calcularIMC(92.47, 1.70, 70, "masculino");
        Assert.assertEquals(32.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void homemidoso_obesidade_grau_i_caso20() {
        ResultadoIMC resultado = calculadora.calcularIMC(92.77, 1.70, 70, "masculino");
        Assert.assertEquals(32.10, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void homemidoso_obesidade_grau_i_caso21() {
        ResultadoIMC resultado = calculadora.calcularIMC(106.93, 1.70, 70, "masculino");
        Assert.assertEquals(37.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void homemidoso_obesidade_grau_ii_caso22() {
        ResultadoIMC resultado = calculadora.calcularIMC(107.22, 1.70, 70, "masculino");
        Assert.assertEquals(37.1, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void homemidoso_obesidade_grau_ii_caso23() {
        ResultadoIMC resultado = calculadora.calcularIMC(121.10, 1.70, 70, "masculino");
        Assert.assertEquals(41.9, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void homemidoso_obesidade_grau_iii_caso24() {
        ResultadoIMC resultado = calculadora.calcularIMC(121.38, 1.70, 70, "masculino");
        Assert.assertEquals(42.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau III", resultado.classificacao());
    }

    @Test
    public void mulheridosa_baixo_peso_caso25() {
        ResultadoIMC resultado = calculadora.calcularIMC(63.26, 1.70, 70, "feminino");
        Assert.assertEquals(21.89, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void mulheridosa_peso_normal_caso26() {
        ResultadoIMC resultado = calculadora.calcularIMC(63.58, 1.70, 70, "feminino");
        Assert.assertEquals(22.00, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void mulheridosa_peso_normal_caso27() {
        ResultadoIMC resultado = calculadora.calcularIMC(78.03, 1.70, 70, "feminino");
        Assert.assertEquals(27.00, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void mulheridosa_sobrepeso_caso28() {
        ResultadoIMC resultado = calculadora.calcularIMC(78.32, 1.70, 70, "feminino");
        Assert.assertEquals(27.10, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void mulheridosa_sobrepeso_caso29() {
        ResultadoIMC resultado = calculadora.calcularIMC(92.48, 1.70, 70, "feminino");
        Assert.assertEquals(32.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void mulheridosa_obesidade_grau_i_caso30() {
        ResultadoIMC resultado = calculadora.calcularIMC(92.77, 1.70, 70, "feminino");
        Assert.assertEquals(32.10, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void mulheridosa_obesidade_grau_i_caso31() {
        ResultadoIMC resultado = calculadora.calcularIMC(106.93, 1.70, 70, "feminino");
        Assert.assertEquals(37.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau I", resultado.classificacao());
    }

    @Test
    public void mulheridosa_obesidade_grau_ii_caso32() {
        ResultadoIMC resultado = calculadora.calcularIMC(107.22, 1.70, 70, "feminino");
        Assert.assertEquals(37.10, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void mulheridosa_obesidade_grau_ii_caso33() {
        ResultadoIMC resultado = calculadora.calcularIMC(120.99, 1.70, 70, "feminino");
        Assert.assertEquals(41.90, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau II", resultado.classificacao());
    }

    @Test
    public void mulheridosa_obesidade_grau_iii_caso34() {
        ResultadoIMC resultado = calculadora.calcularIMC(121.31, 1.70, 70, "feminino");
        Assert.assertEquals(42.01, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade grau III", resultado.classificacao());
    }

    @Test
    public void menino2anos_baixo_peso_caso35() {
        ResultadoIMC resultado = calculadora.calcularIMC(11.74, 0.90, 2, "masculino");
        Assert.assertEquals(14.49, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menino2anos_peso_normal_caso36() {
        ResultadoIMC resultado = calculadora.calcularIMC(11.75, 0.90, 2, "masculino");
        Assert.assertEquals(14.50, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino2anos_peso_normal_caso37() {
        ResultadoIMC resultado = calculadora.calcularIMC(14.57, 0.90, 2, "masculino");
        Assert.assertEquals(17.99, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino2anos_sobrepeso_caso38() {
        ResultadoIMC resultado = calculadora.calcularIMC(14.58, 0.90, 2, "masculino");
        Assert.assertEquals(18.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino2anos_sobrepeso_caso39() {
        ResultadoIMC resultado = calculadora.calcularIMC(15.38, 0.90, 2, "masculino");
        Assert.assertEquals(18.99, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino2anos_obesidade_caso40() {
        ResultadoIMC resultado = calculadora.calcularIMC(15.39, 0.90, 2, "masculino");
        Assert.assertEquals(19.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menino4anos_baixo_peso_caso41() {
        ResultadoIMC resultado = calculadora.calcularIMC(13.79, 1.00, 4, "masculino");
        Assert.assertEquals(13.79, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menino4anos_peso_normal_caso42() {
        ResultadoIMC resultado = calculadora.calcularIMC(13.80, 1.00, 4, "masculino");
        Assert.assertEquals(13.80, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino4anos_peso_normal_caso43() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.39, 1.00, 4, "masculino");
        Assert.assertEquals(17.39, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino4anos_sobrepeso_caso44() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.40, 1.00, 4, "masculino");
        Assert.assertEquals(17.40, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino4anos_sobrepeso_caso45() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.29, 1.00, 4, "masculino");
        Assert.assertEquals(18.29, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino4anos_obesidade_caso46() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.30, 1.00, 4, "masculino");
        Assert.assertEquals(18.30, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menino6anos_baixo_peso_caso47() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.10, 1.15, 6, "masculino");
        Assert.assertEquals(13.69, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menino6anos_peso_normal_caso48() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.11, 1.15, 6, "masculino");
        Assert.assertEquals(13.70, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino6anos_peso_normal_caso49() {
        ResultadoIMC resultado = calculadora.calcularIMC(23.39, 1.15, 6, "masculino");
        Assert.assertEquals(17.69, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino6anos_sobrepeso_caso50() {
        ResultadoIMC resultado = calculadora.calcularIMC(23.40, 1.15, 6, "masculino");
        Assert.assertEquals(17.70, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino6anos_sobrepeso_caso51() {
        ResultadoIMC resultado = calculadora.calcularIMC(24.83, 1.15, 6, "masculino");
        Assert.assertEquals(18.79, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino6anos_obesidade_caso52() {
        ResultadoIMC resultado = calculadora.calcularIMC(24.84, 1.15, 6, "masculino");
        Assert.assertEquals(18.80, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menino8anos_baixo_peso_caso53() {
        ResultadoIMC resultado = calculadora.calcularIMC(22.92, 1.28, 8, "masculino");
        Assert.assertEquals(13.99, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menino8anos_peso_normal_caso54() {
        ResultadoIMC resultado = calculadora.calcularIMC(22.94, 1.28, 8, "masculino");
        Assert.assertEquals(14.00, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino8anos_peso_normal_caso55() {
        ResultadoIMC resultado = calculadora.calcularIMC(31.11, 1.28, 8, "masculino");
        Assert.assertEquals(18.99, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino8anos_sobrepeso_caso56() {
        ResultadoIMC resultado = calculadora.calcularIMC(31.13, 1.28, 8, "masculino");
        Assert.assertEquals(19.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino8anos_sobrepeso_caso57() {
        ResultadoIMC resultado = calculadora.calcularIMC(33.24, 1.28, 8, "masculino");
        Assert.assertEquals(20.29, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino8anos_obesidade_caso58() {
        ResultadoIMC resultado = calculadora.calcularIMC(33.26, 1.28, 8, "masculino");
        Assert.assertEquals(20.30, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menino10anos_baixo_peso_caso59() {
        ResultadoIMC resultado = calculadora.calcularIMC(28.60, 1.40, 10, "masculino");
        Assert.assertEquals(14.59, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menino10anos_peso_normal_caso60() {
        ResultadoIMC resultado = calculadora.calcularIMC(28.62, 1.40, 10, "masculino");
        Assert.assertEquals(14.60, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino10anos_peso_normal_caso61() {
        ResultadoIMC resultado = calculadora.calcularIMC(40.16, 1.40, 10, "masculino");
        Assert.assertEquals(20.49, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menino10anos_sobrepeso_caso62() {
        ResultadoIMC resultado = calculadora.calcularIMC(40.18, 1.40, 10, "masculino");
        Assert.assertEquals(20.50, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino10anos_sobrepeso_caso63() {
        ResultadoIMC resultado = calculadora.calcularIMC(44.08, 1.40, 10, "masculino");
        Assert.assertEquals(22.49, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menino10anos_obesidade_caso64() {
        ResultadoIMC resultado = calculadora.calcularIMC(44.10, 1.40, 10, "masculino");
        Assert.assertEquals(22.50, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menina2anos_baixo_peso_caso65() {
        ResultadoIMC resultado = calculadora.calcularIMC(11.57, 0.90, 2, "feminino");
        Assert.assertEquals(14.29, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menina2anos_peso_normal_caso66() {
        ResultadoIMC resultado = calculadora.calcularIMC(11.58, 0.90, 2, "feminino");
        Assert.assertEquals(14.30, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina2anos_peso_normal_caso67() {
        ResultadoIMC resultado = calculadora.calcularIMC(14.57, 0.90, 2, "feminino");
        Assert.assertEquals(17.99, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina2anos_sobrepeso_caso68() {
        ResultadoIMC resultado = calculadora.calcularIMC(14.58, 0.90, 2, "feminino");
        Assert.assertEquals(18.00, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina2anos_sobrepeso_caso69() {
        ResultadoIMC resultado = calculadora.calcularIMC(15.38, 0.90, 2, "feminino");
        Assert.assertEquals(18.99, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina2anos_obesidade_caso70() {
        ResultadoIMC resultado = calculadora.calcularIMC(15.39, 0.90, 2, "feminino");
        Assert.assertEquals(19.00, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menina4anos_baixo_peso_caso71() {
        ResultadoIMC resultado = calculadora.calcularIMC(13.49, 1.00, 4, "feminino");
        Assert.assertEquals(13.49, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menina4anos_peso_normal_caso72() {
        ResultadoIMC resultado = calculadora.calcularIMC(13.50, 1.00, 4, "feminino");
        Assert.assertEquals(13.50, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina4anos_peso_normal_caso73() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.19, 1.00, 4, "feminino");
        Assert.assertEquals(17.19, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina4anos_sobrepeso_caso74() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.20, 1.00, 4, "feminino");
        Assert.assertEquals(17.20, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina4anos_sobrepeso_caso75() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.19, 1.00, 4, "feminino");
        Assert.assertEquals(18.19, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina4anos_obesidade_caso76() {
        ResultadoIMC resultado = calculadora.calcularIMC(18.20, 1.00, 4, "feminino");
        Assert.assertEquals(18.20, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menina6anos_baixo_peso_caso77() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.69, 1.15, 6, "feminino");
        Assert.assertEquals(13.39, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menina6anos_peso_normal_caso78() {
        ResultadoIMC resultado = calculadora.calcularIMC(17.70, 1.15, 6, "feminino");
        Assert.assertEquals(13.40, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina6anos_peso_normal_caso79() {
        ResultadoIMC resultado = calculadora.calcularIMC(23.11, 1.15, 6, "feminino");
        Assert.assertEquals(17.49, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina6anos_sobrepeso_caso80() {
        ResultadoIMC resultado = calculadora.calcularIMC(23.12, 1.15, 6, "feminino");
        Assert.assertEquals(17.50, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina6anos_sobrepeso_caso81() {
        ResultadoIMC resultado = calculadora.calcularIMC(24.71, 1.15, 6, "feminino");
        Assert.assertEquals(18.69, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina6anos_obesidade_caso82() {
        ResultadoIMC resultado = calculadora.calcularIMC(24.72, 1.15, 6, "feminino");
        Assert.assertEquals(18.70, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menina8anos_baixo_peso_caso83() {
        ResultadoIMC resultado = calculadora.calcularIMC(22.59, 1.28, 8, "feminino");
        Assert.assertEquals(13.79, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menina8anos_peso_normal_caso84() {
        ResultadoIMC resultado = calculadora.calcularIMC(22.61, 1.28, 8, "feminino");
        Assert.assertEquals(13.80, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina8anos_peso_normal_caso85() {
        ResultadoIMC resultado = calculadora.calcularIMC(30.77, 1.28, 8, "feminino");
        Assert.assertEquals(18.79, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina8anos_sobrepeso_caso86() {
        ResultadoIMC resultado = calculadora.calcularIMC(30.79, 1.28, 8, "feminino");
        Assert.assertEquals(18.80, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina8anos_sobrepeso_caso87() {
        ResultadoIMC resultado = calculadora.calcularIMC(33.57, 1.28, 8, "feminino");
        Assert.assertEquals(20.49, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina8anos_obesidade_caso88() {
        ResultadoIMC resultado = calculadora.calcularIMC(33.59, 1.28, 8, "feminino");
        Assert.assertEquals(20.50, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

    @Test
    public void menina10anos_baixo_peso_caso89() {
        ResultadoIMC resultado = calculadora.calcularIMC(28.01, 1.40, 10, "feminino");
        Assert.assertEquals(14.29, resultado.imc(), 0.0);
        Assert.assertEquals("Baixo peso", resultado.classificacao());
    }

    @Test
    public void menina10anos_peso_normal_caso90() {
        ResultadoIMC resultado = calculadora.calcularIMC(28.03, 1.40, 10, "feminino");
        Assert.assertEquals(14.30, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina10anos_peso_normal_caso91() {
        ResultadoIMC resultado = calculadora.calcularIMC(39.57, 1.40, 10, "feminino");
        Assert.assertEquals(20.19, resultado.imc(), 0.0);
        Assert.assertEquals("Peso normal", resultado.classificacao());
    }

    @Test
    public void menina10anos_sobrepeso_caso92() {
        ResultadoIMC resultado = calculadora.calcularIMC(39.59, 1.40, 10, "feminino");
        Assert.assertEquals(20.20, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina10anos_sobrepeso_caso93() {
        ResultadoIMC resultado = calculadora.calcularIMC(44.67, 1.40, 10, "feminino");
        Assert.assertEquals(22.79, resultado.imc(), 0.0);
        Assert.assertEquals("Sobrepeso", resultado.classificacao());
    }

    @Test
    public void menina10anos_obesidade_caso94() {
        ResultadoIMC resultado = calculadora.calcularIMC(44.69, 1.40, 10, "feminino");
        Assert.assertEquals(22.80, resultado.imc(), 0.0);
        Assert.assertEquals("Obesidade", resultado.classificacao());
    }

}
