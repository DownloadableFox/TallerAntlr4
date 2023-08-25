package gramatica;

import gramatica.generado.GramaticaLexer;
import gramatica.generado.GramaticaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    private static final Visitador visitador = new Visitador();

    public static void main(String[] args) {
        final ANTLRInputStream input = new ANTLRInputStream("Escribir \"hola\";");
        final GramaticaLexer lexer = new GramaticaLexer(input); // Analisis lexico
        final CommonTokenStream tokens = new CommonTokenStream(lexer); // Tokenizador
        final GramaticaParser parser = new GramaticaParser(tokens); // Analisis sintactico

        try {
            ParseTree tree = parser.programa();
            visitador.visit(tree);
        } catch (Exception e) {
            System.out.println("Error en el analisis sintactico");
        }
    }
}