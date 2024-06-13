package one.challenge.literalura;

public class LiterAluraMenu {
    // Método para obtener el menú como una cadena de texto formateada
    public String getMenuString() {
        // Retorna una cadena formateada que representa el menú
        return """
          \s
            ======================================================
                         =====    LITERALURA    =====           \s
                Bienvenido al Sistema de Intercambio de Moneda  \s
            ======================================================
          
            Por favor, elija una opción válida ingresando un
            número del 1 al 6:
          \s
            1. Buscar libro por título
            2. Listar libros registrados
            3. Listar autores registrados
            4. Listar autores vivos en un determinado año
            5. Listar libros por idioma
            6. Salir
          
            ======================================================
          \s""";
    }
}
