package gramatica;

import gramatica.generado.GramaticaLexer;
import gramatica.generado.GramaticaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Scanner;

public class Main {
    private static final Visitador visitador = new Visitador();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Taller Lenguaje con Antlr4");
        System.out.println("Ingrese una sentencia o \"exit\" para salir");

        while (true) {
            System.out.print("\n> ");
            final String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            try {
                // Se general el parser para la sentencia ingresada
                final GramaticaParser parser = generarParser(input);

                // Se obtiene el arbol de analisis sintactico
                final ParseTree tree = parser.programa();
                visitador.visit(tree);
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error al analizar la sentencia, error:");
                System.out.println(e.getMessage());
            }
        }
    }

    private static GramaticaParser generarParser(final String input) {
        @SuppressWarnings("deprecation")
        ANTLRInputStream stream = new ANTLRInputStream(input);
        GramaticaLexer lexer = new GramaticaLexer(stream); // Analisis lexico
        CommonTokenStream tokens = new CommonTokenStream(lexer); // Tokenizador

        return new GramaticaParser(tokens); // Analisis sintactico
    }
}