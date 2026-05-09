package imc.classificacao;

import imc.model.ClassificacaoIMC;
import imc.model.Sexo;

public interface ClassificadorPorFaixaEtaria {
    ClassificacaoIMC classificar(double imc, int idade, Sexo sexo);
}
