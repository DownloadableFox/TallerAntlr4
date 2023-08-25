package gramatica;

import java.util.HashMap;
import java.util.Map;


import gramatica.generado.GramaticaBaseVisitor;
import gramatica.generado.GramaticaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Visitador extends GramaticaBaseVisitor<Object> {
    private Map<String, Object> variables = new HashMap<>();

    @Override
    public Object visitPrograma(GramaticaParser.ProgramaContext ctx) {
        for (GramaticaParser.SentenciaContext sentenciaCtx : ctx.sentencia()) {
            visit(sentenciaCtx);
        }

        return null;
    }

    @Override
    public Object visitSentencia(GramaticaParser.SentenciaContext ctx) {
        // Determinar qué tipo de sentencia es y llamar al método de visita correspondiente

        if (ctx.sentenciaAsignacion() != null) {
            return visit(ctx.sentenciaAsignacion());
        } else if (ctx.sentenciaEscritura() != null) {
            return visit(ctx.sentenciaEscritura());
        } else if (ctx.sentenciaIf() != null) {
            return visit(ctx.sentenciaIf());
        } else if (ctx.sentenciaWhile() != null) {
            return visit(ctx.sentenciaWhile());
        }

        return null;
    }

    @Override
    public Object visitSentenciaAsignacion(GramaticaParser.SentenciaAsignacionContext ctx) {
        String variable = ctx.IDENTIFICADOR().getText(); // Obtenga el nombre de la variable
        Object valor = visit(ctx.expresion()); // Obtenga el valor de la expresion
        variables.put(variable, valor); // Guardelo en una variable.
        return null;
    }

    @Override
    public Object visitSentenciaEscritura(GramaticaParser.SentenciaEscrituraContext ctx) {
        Object valor = visit(ctx.expresion());
        System.out.println(valor);
        return null;
    }

    @Override
    public Object visitSentenciaIf(GramaticaParser.SentenciaIfContext ctx) {
        boolean condicion = (boolean) visit(ctx.condicion());

        if (condicion ) {
            for (GramaticaParser.SentenciaContext sentenciaCtx : ctx.sentencia()) {
                visit(sentenciaCtx);
            }
        }
        else {

            if (ctx.sentencia().size() > 0) {
                for (GramaticaParser.SentenciaContext sentenciaCtx : ctx.sentencia()) {
                    visit(sentenciaCtx);
                }
            }
        }
        return null;
    }

    @Override
    public Object visitSentenciaWhile(GramaticaParser.SentenciaWhileContext ctx) {
        // Obtenemos el valor de la condicion y evaluamos en un while
        while ((boolean) visit(ctx.condicion())) {
            for (GramaticaParser.SentenciaContext sentenciaCtx : ctx.sentencia()) {
                visit(sentenciaCtx); // Ejecutamos la sentencia.
            }
        }
        return null;
    }

    @Override
    public Object visitCondicion(GramaticaParser.CondicionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));  // Evaluar la expresión izquierda
        Object derecha = visit(ctx.expresion(1));    // Evaluar la expresión derecha
        String operador = ctx.OPERADORCOMPARACION().getText();  // Obtener el operador de comparación

        if (izquierda instanceof String || derecha instanceof String) {
            switch (operador) {
                case "==":
                    return izquierda.equals(derecha);
                case "!=":
                    return !izquierda.equals(derecha);
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        } else if (izquierda instanceof Double && derecha instanceof Double) {
            double izq = (double) izquierda;
            double der = (double) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                case "<":
                    return izq < der;
                case ">":
                    return izq > der;
                case "<=":
                    return izq <= der;
                case ">=":
                    return izq >= der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                case "<":
                    return izq < der;
                case ">":
                    return izq > der;
                case "<=":
                    return izq <= der;
                case ">=":
                    return izq >= der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        }else if (izquierda instanceof Boolean && derecha instanceof Boolean) {
            Boolean izq = (Boolean) izquierda;
            Boolean der = (Boolean) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            } }else {
            throw new RuntimeException("Tipos de datos no compatibles para la comparación");
        }
    }

    @Override
    public Object visitMultiplicacion(GramaticaParser.MultiplicacionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));
        Object derecha = visit(ctx.expresion(1));

        if (izquierda instanceof Double || derecha instanceof Double) {
            double izq = izquierda instanceof Double ? (double) izquierda : ((Integer) izquierda).doubleValue();
            double der = derecha instanceof Double ? (double) derecha : ((Integer) derecha).doubleValue();
            return izq * der;
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;
            return izq * der;
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la multiplicación");
        }
    }


    @Override
    public Object visitString(GramaticaParser.StringContext ctx) {
        return ctx.STRING().getText();
    }

    @Override
    public Object visitLogico(GramaticaParser.LogicoContext ctx) {
        Object izquierda = visit(ctx.expresion(0));  // Evaluar la expresión izquierda
        Object derecha = visit(ctx.expresion(1));    // Evaluar la expresión derecha
        String operador = ctx.OPERADORLOGICO().getText();    // Obtener el operador lógico

        //Evaluamos el operador
        switch (operador) {
            case "&&":
                return (boolean) izquierda && (boolean) derecha;
            case "||":
                return (boolean) izquierda || (boolean) derecha;
            default:
                throw new RuntimeException("Operador lógico desconocido: " + operador);
        }
    }

    @Override
    public Object visitEntero(GramaticaParser.EnteroContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Object visitParentesis(GramaticaParser.ParentesisContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Object visitDivision(GramaticaParser.DivisionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));
        Object derecha = visit(ctx.expresion(1));

        if (izquierda instanceof Double || derecha instanceof Double) {
            double izq = izquierda instanceof Double ? (double) izquierda : ((Integer) izquierda).doubleValue();
            double der = derecha instanceof Double ? (double) derecha : ((Integer) derecha).doubleValue();
            return izq / der;
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;
            if (der != 0) {
                return izq / der;
            } else {
                throw new ArithmeticException("División por cero");
            }
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la división");
        }
    }


    @Override
    public Object visitBooleano(GramaticaParser.BooleanoContext ctx) {
        TerminalNode boolNode = (TerminalNode) ctx.BOOLEAN();
        String boolValue = boolNode.getText();

        if (boolValue.equals("true")) {
            return true;
        } else if (boolValue.equals("false")) {
            return false;
        }

        throw new RuntimeException("Valor booleano desconocido: " + boolValue);
    }


    @Override
    public Object visitSustraccion(GramaticaParser.SustraccionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));
        Object derecha = visit(ctx.expresion(1));

        if (izquierda instanceof Double || derecha instanceof Double) {
            double izq = izquierda instanceof Double ? (double) izquierda : ((Integer) izquierda).doubleValue();
            double der = derecha instanceof Double ? (double) derecha : ((Integer) derecha).doubleValue();
            return izq - der;
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;
            return izq - der;
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la resta");
        }
    }


    @Override
    public Object visitElevacion(GramaticaParser.ElevacionContext ctx) {
        Object baseObj = visit(ctx.expresion(0));
        Object exponenteObj = visit(ctx.expresion(1));

        if (baseObj instanceof Double || exponenteObj instanceof Double) {
            double base = baseObj instanceof Double ? (double) baseObj : ((Integer) baseObj).doubleValue();
            double exponente = exponenteObj instanceof Double ? (double) exponenteObj : ((Integer) exponenteObj).doubleValue();
            return Math.pow(base, exponente);
        } else if (baseObj instanceof Integer && exponenteObj instanceof Integer) {
            int base = (int) baseObj;
            int exponente = (int) exponenteObj;
            return Math.pow(base, exponente);
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la potenciación");
        }
    }



    @Override
    public Object visitDecimal(GramaticaParser.DecimalContext ctx) {
        return Double.parseDouble(ctx.DECIMAL().getText());
    }


    @Override
    public Object visitComparacion(GramaticaParser.ComparacionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));
        Object derecha = visit(ctx.expresion(1));
        String operador = ctx.OPERADORCOMPARACION().getText();


        if (izquierda instanceof String || derecha instanceof String) {
            switch (operador) {
                case "==":
                    return izquierda.equals(derecha);
                case "!=":
                    return !izquierda.equals(derecha);
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        } else if (izquierda instanceof Double && derecha instanceof Double) {
            double izq = (double) izquierda;
            double der = (double) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                case "<":
                    return izq < der;
                case ">":
                    return izq > der;
                case "<=":
                    return izq <= der;
                case ">=":
                    return izq >= der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                case "<":
                    return izq < der;
                case ">":
                    return izq > der;
                case "<=":
                    return izq <= der;
                case ">=":
                    return izq >= der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            }
        } else if (izquierda instanceof Boolean && derecha instanceof Boolean) {
            Boolean izq = (Boolean) izquierda;
            Boolean der = (Boolean) derecha;

            switch (operador) {
                case "==":
                    return izq == der;
                case "!=":
                    return izq != der;
                default:
                    throw new RuntimeException("Operador de comparación desconocido: " + operador);
            } }else {
            throw new RuntimeException("Tipos de datos no compatibles para la comparación");
        }
    }

    @Override
    public Object visitAdicion(GramaticaParser.AdicionContext ctx) {
        Object izquierda = visit(ctx.expresion(0));
        Object derecha = visit(ctx.expresion(1));

        if (izquierda instanceof Double || derecha instanceof Double) {
            double izq = izquierda instanceof Double ? (double) izquierda : ((Integer) izquierda).doubleValue();
            double der = derecha instanceof Double ? (double) derecha : ((Integer) derecha).doubleValue();
            return izq + der;
        } else if (izquierda instanceof Integer && derecha instanceof Integer) {
            int izq = (int) izquierda;
            int der = (int) derecha;
            return izq + der;
        } else if (izquierda instanceof String || derecha instanceof String) {
            String strIzq = izquierda.toString();
            String strDer = derecha.toString();
            return strIzq + strDer;
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la adición");
        }
    }

    @Override
    public Object visitIdentificador(GramaticaParser.IdentificadorContext ctx) {
        String variable = ctx.IDENTIFICADOR().getText();
        if (variables.containsKey(variable)) {
            return variables.get(variable);
        }
        throw new RuntimeException("Variable no definida: " + variable);
    }

    @Override
    public Object visitModulo(GramaticaParser.ModuloContext ctx) {
        Object izquierdaObj = visit(ctx.expresion(0));
        Object derechaObj = visit(ctx.expresion(1));

        if (izquierdaObj instanceof Double || derechaObj instanceof Double) {
            double izquierda = izquierdaObj instanceof Double ? (double) izquierdaObj : ((Integer) izquierdaObj).doubleValue();
            double derecha = derechaObj instanceof Double ? (double) derechaObj : ((Integer) derechaObj).doubleValue();
            return izquierda % derecha;
        } else if (izquierdaObj instanceof Integer && derechaObj instanceof Integer) {
            int izquierda = (int) izquierdaObj;
            int derecha = (int) derechaObj;
            return izquierda % derecha;
        } else {
            throw new RuntimeException("Tipos de datos no compatibles para la operación de módulo");
        }
    }

}

