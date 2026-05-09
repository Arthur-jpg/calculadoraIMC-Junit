import java.util.Locale;

public enum Sexo {
    MASCULINO,
    FEMININO;

    public static Sexo from(String sexo) {
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
