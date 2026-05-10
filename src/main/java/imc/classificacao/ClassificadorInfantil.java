package imc.classificacao;

import imc.model.ClassificacaoIMC;
import imc.model.LimitesPercentil;
import imc.model.Sexo;

import java.util.Map;

public class ClassificadorInfantil implements ClassificadorPorFaixaEtaria {

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
