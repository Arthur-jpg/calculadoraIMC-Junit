package imc.classificacao;

import imc.model.ClassificacaoIMC;
import imc.model.Sexo;

public class ClassificadorAdulto implements ClassificadorPorFaixaEtaria {
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
