package gramatica;

import gramatica.generado.GramaticaLexer;
import gramatica.generado.GramaticaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    private static final Visitador visitador = new Visitador();

    public static void main(String[] args) {
        final CommonTokenStream tokens = getCommonTokenStream();
        final GramaticaParser parser = new GramaticaParser(tokens); // Analisis sintactico

        try {
            ParseTree tree = parser.programa();
            visitador.visit(tree);
        } catch (Exception e) {
            System.out.println("Error en el analisis sintactico");
            System.out.println(e.getMessage());
        }
    }

    private static CommonTokenStream getCommonTokenStream() {
        @SuppressWarnings("deprecation")
        final ANTLRInputStream input = new ANTLRInputStream("""
                dormir = true;
                
                si (dormir == true) {
                    Escribir "buen dia";
                    Escribir "prueba";
                } sino {
                    Escribir "buena noche";
                }
            """);

        final GramaticaLexer lexer = new GramaticaLexer(input); // Analisis lexico
        final CommonTokenStream tokens = new CommonTokenStream(lexer); // Tokenizador
        return tokens;
    }
}