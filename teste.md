```java
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Map;

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

    enum Sexo {
        MASCULINO,
        FEMININO;

        static Sexo from(String sexo) {
            String normalizado = sexo.trim().toLowerCase(Locale.ROOT);
            if ("masculino".equals(normalizado)) {
                return MASCULINO;
            }
            if ("feminino".equals(normalizado)) {
                return FEMININO;
            }
            throw new IllegalArgumentException("Sexo invalido. Use 'masculino' ou 'feminino'.");
        }
    }

    enum ClassificacaoIMC {
        BAIXO_PESO_MUITO_GRAVE("Baixo peso muito grave"),
        BAIXO_PESO_GRAVE("Baixo peso grave"),
        BAIXO_PESO("Baixo peso"),
        PESO_NORMAL("Peso normal"),
        SOBREPESO("Sobrepeso"),
        OBESIDADE_GRAU_I("Obesidade grau I"),
        OBESIDADE_GRAU_II("Obesidade grau II"),
        OBESIDADE_GRAU_III("Obesidade grau III"),
        OBESIDADE("Obesidade");

        private final String descricao;

        ClassificacaoIMC(String descricao) {
            this.descricao = descricao;
        }

        public String descricao() {
            return descricao;
        }
    }

    interface ClassificadorPorFaixaEtaria {
        ClassificacaoIMC classificar(double imc, int idade, Sexo sexo);
    }

    static class ClassificadorFactory {
        private final ClassificadorPorFaixaEtaria classificadorAdulto = new ClassificadorAdulto();
        private final ClassificadorPorFaixaEtaria classificadorIdoso = new ClassificadorIdoso();
        private final ClassificadorPorFaixaEtaria classificadorInfantil = new ClassificadorInfantil();

        ClassificadorPorFaixaEtaria obterClassificador(int idade) {
            if (idade >= 20 && idade <= 65) {
                return classificadorAdulto;
            }
            if (idade > 65) {
                return classificadorIdoso;
            }
            return classificadorInfantil;
        }
    }

    static class ClassificadorAdulto implements ClassificadorPorFaixaEtaria {
        @Override
        public ClassificacaoIMC classificar(double imc, int idade, Sexo sexo) {
            if (imc < 16.00) {
                return ClassificacaoIMC.BAIXO_PESO_MUITO_GRAVE;
            }
            if (imc < 17.00) {
                return ClassificacaoIMC.BAIXO_PESO_GRAVE;
            }
            if (imc < 18.50) {
                return ClassificacaoIMC.BAIXO_PESO;
            }
            if (imc < 25.00) {
                return ClassificacaoIMC.PESO_NORMAL;
            }
            if (imc < 30.00) {
                return ClassificacaoIMC.SOBREPESO;
            }
            if (imc < 35.00) {
                return ClassificacaoIMC.OBESIDADE_GRAU_I;
            }
            if (imc < 40.00) {
                return ClassificacaoIMC.OBESIDADE_GRAU_II;
            }
            return ClassificacaoIMC.OBESIDADE_GRAU_III;
        }
    }

    static class ClassificadorIdoso implements ClassificadorPorFaixaEtaria {
        @Override
        public ClassificacaoIMC classificar(double imc, int idade, Sexo sexo) {
            if (imc < 22.00) {
                return ClassificacaoIMC.BAIXO_PESO;
            }
            if (imc <= 27.00) {
                return ClassificacaoIMC.PESO_NORMAL;
            }

            if (sexo == Sexo.FEMININO) {
                return classificarFeminino(imc);
            }
            return classificarMasculino(imc);
        }

        private ClassificacaoIMC classificarFeminino(double imc) {
            if (imc <= 32.00) {
                return ClassificacaoIMC.SOBREPESO;
            }
            if (imc <= 37.00) {
                return ClassificacaoIMC.OBESIDADE_GRAU_I;
            }
            if (imc <= 41.90) {
                return ClassificacaoIMC.OBESIDADE_GRAU_II;
            }
            return ClassificacaoIMC.OBESIDADE_GRAU_III;
        }

        private ClassificacaoIMC classificarMasculino(double imc) {
            if (imc <= 30.00) {
                return ClassificacaoIMC.SOBREPESO;
            }
            if (imc <= 35.00) {
                return ClassificacaoIMC.OBESIDADE_GRAU_I;
            }
            if (imc <= 39.90) {
                return ClassificacaoIMC.OBESIDADE_GRAU_II;
            }
            return ClassificacaoIMC.OBESIDADE_GRAU_III;
        }
    }

    static class ClassificadorInfantil implements ClassificadorPorFaixaEtaria {

        private static final Map<Integer, LimitesPercentil> MENINOS = Map.of(
                2, new LimitesPercentil(14.5, 18.0, 19.0),
                4, new LimitesPercentil(13.8, 17.4, 18.3),
                6, new LimitesPercentil(13.7, 17.7, 18.8),
                8, new LimitesPercentil(14.0, 19.0, 20.3),
                10, new LimitesPercentil(14.6, 20.5, 22.5)
        );

        private static final Map<Integer, LimitesPercentil> MENINAS = Map.of(
                2, new LimitesPercentil(14.3, 18.0, 19.0),
                4, new LimitesPercentil(13.5, 17.2, 18.2),
                6, new LimitesPercentil(13.4, 17.5, 18.7),
                8, new LimitesPercentil(13.8, 18.8, 20.5),
                10, new LimitesPercentil(14.3, 20.2, 22.8)
        );

        @Override
        public ClassificacaoIMC classificar(double imc, int idade, Sexo sexo) {
            LimitesPercentil limites = obterLimites(idade, sexo);

            if (imc < limites.p5()) {
                return ClassificacaoIMC.BAIXO_PESO;
            }
            if (imc <= limites.p85()) {
                return ClassificacaoIMC.PESO_NORMAL;
            }
            if (imc <= limites.p95()) {
                return ClassificacaoIMC.SOBREPESO;
            }
            return ClassificacaoIMC.OBESIDADE;
        }

        private LimitesPercentil obterLimites(int idade, Sexo sexo) {
            Map<Integer, LimitesPercentil> tabela = sexo == Sexo.MASCULINO ? MENINOS : MENINAS;
            LimitesPercentil limites = tabela.get(idade);
            if (limites == null) {
                throw new IllegalArgumentException("Idade infantil nao suportada. Use: 2, 4, 6, 8 ou 10.");
            }
            return limites;
        }
    }

    record LimitesPercentil(double p5, double p85, double p95) {
    }
}

```