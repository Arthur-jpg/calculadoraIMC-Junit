public class ClassificadorFactory {
    private final ClassificadorPorFaixaEtaria classificadorAdulto = new ClassificadorAdulto();
    private final ClassificadorPorFaixaEtaria classificadorIdoso = new ClassificadorIdoso();
    private final ClassificadorPorFaixaEtaria classificadorInfantil = new ClassificadorInfantil();

    public ClassificadorPorFaixaEtaria obterClassificador(int idade) {
        if (idade >= 20 && idade <= 65) {
            return classificadorAdulto;
        }
        if (idade > 65) {
            return classificadorIdoso;
        }
        return classificadorInfantil;
    }
}
