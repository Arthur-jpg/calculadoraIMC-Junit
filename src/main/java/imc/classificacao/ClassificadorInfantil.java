package imc.classificacao;

import imc.model.ClassificacaoIMC;
import imc.model.LimitesPercentil;
import imc.model.Sexo;

import java.util.Map;

public class ClassificadorInfantil implements ClassificadorPorFaixaEtaria {

    private static final Map<Integer, LimitesPercentil> MENINOS = Map.of(
            2, new LimitesPercentil(15.01, 18.01, 19.01),
            4, new LimitesPercentil(14.51, 17.01, 18.81),
            6, new LimitesPercentil(14.01, 17.01, 18.31),
            8, new LimitesPercentil(14.21, 17.81, 20.01),
            10, new LimitesPercentil(14.51, 19.31, 22.01)
    );

    private static final Map<Integer, LimitesPercentil> MENINAS = Map.of(
            2, new LimitesPercentil(14.81, 18.01, 19.01),
            4, new LimitesPercentil(14.01, 16.81, 18.01),
            6, new LimitesPercentil(13.81, 17.01, 18.81),
            8, new LimitesPercentil(14.01, 18.21, 20.51),
            10, new LimitesPercentil(14.51, 20.01, 23.01)
    );

    @Override
    public ClassificacaoIMC classificar(double imc, int idade, Sexo sexo) {
        LimitesPercentil limites = obterLimites(idade, sexo);

        if (imc < limites.p5()) {
            return ClassificacaoIMC.BAIXO_PESO;
        }
        if (imc < limites.p85()) {
            return ClassificacaoIMC.PESO_NORMAL;
        }
        if (imc < limites.p95()) {
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
