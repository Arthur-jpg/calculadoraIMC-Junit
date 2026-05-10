package imc.classificacao;

import imc.model.ClassificacaoIMC;
import imc.model.Sexo;

public class ClassificadorIdoso implements ClassificadorPorFaixaEtaria {
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
}
