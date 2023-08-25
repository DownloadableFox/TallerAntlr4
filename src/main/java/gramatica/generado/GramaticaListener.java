package gramatica.generado;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(GramaticaParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(GramaticaParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaAsignacion(GramaticaParser.SentenciaAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaAsignacion(GramaticaParser.SentenciaAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sentenciaEscritura}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaEscritura(GramaticaParser.SentenciaEscrituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sentenciaEscritura}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaEscritura(GramaticaParser.SentenciaEscrituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaIf(GramaticaParser.SentenciaIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaIf(GramaticaParser.SentenciaIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaWhile(GramaticaParser.SentenciaWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaWhile(GramaticaParser.SentenciaWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(GramaticaParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(GramaticaParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacion(GramaticaParser.MultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacion(GramaticaParser.MultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterString(GramaticaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitString(GramaticaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logico}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLogico(GramaticaParser.LogicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logico}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLogico(GramaticaParser.LogicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code entero}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEntero(GramaticaParser.EnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code entero}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEntero(GramaticaParser.EnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentesis}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParentesis(GramaticaParser.ParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentesis}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParentesis(GramaticaParser.ParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDivision(GramaticaParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDivision(GramaticaParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(GramaticaParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(GramaticaParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sustraccion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSustraccion(GramaticaParser.SustraccionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sustraccion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSustraccion(GramaticaParser.SustraccionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elevacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterElevacion(GramaticaParser.ElevacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elevacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitElevacion(GramaticaParser.ElevacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(GramaticaParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(GramaticaParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(GramaticaParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(GramaticaParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code adicion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAdicion(GramaticaParser.AdicionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code adicion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAdicion(GramaticaParser.AdicionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterModulo(GramaticaParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitModulo(GramaticaParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identificador}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(GramaticaParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identificador}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(GramaticaParser.IdentificadorContext ctx);
}