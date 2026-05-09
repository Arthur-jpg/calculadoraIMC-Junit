import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class CalculadoraIMC {

    private final ClassificadorFactory classificadorFactory;

    public CalculadoraIMC() {
        this.classificadorFactory = new ClassificadorFactory();
    }

    public String calcularIMC(double peso, double altura, int idade, String sexo) {
        validarEntradas(peso, altura, idade, sexo);

        Sexo sexoNormalizado = Sexo.from(sexo);
        double imc = arredondar2Casas(peso / (altura * altura));

        ClassificacaoIMC classificacao = classificadorFactory
                .obterClassificador(idade)
                .classificar(imc, idade, sexoNormalizado);

        return String.format(Locale.US, "IMC: %.2f - Classificacao: %s", imc, classificacao.descricao());
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
    }

    private double arredondar2Casas(double valor) {
        return BigDecimal.valueOf(valor)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
