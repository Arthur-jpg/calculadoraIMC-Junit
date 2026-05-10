package imc.service;

import imc.model.ResultadoIMC;

public interface CalculadoraIMCService {
    ResultadoIMC calcularIMC(double peso, double altura, int idade, String sexo);
}
