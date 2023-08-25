package gramatica.generado;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(GramaticaParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaAsignacion(GramaticaParser.SentenciaAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sentenciaEscritura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaEscritura(GramaticaParser.SentenciaEscrituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sentenciaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaIf(GramaticaParser.SentenciaIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaWhile(GramaticaParser.SentenciaWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(GramaticaParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicacion(GramaticaParser.MultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(GramaticaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logico}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogico(GramaticaParser.LogicoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code entero}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntero(GramaticaParser.EnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentesis}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis(GramaticaParser.ParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code division}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(GramaticaParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleano(GramaticaParser.BooleanoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sustraccion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSustraccion(GramaticaParser.SustraccionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elevacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElevacion(GramaticaParser.ElevacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(GramaticaParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(GramaticaParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code adicion}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdicion(GramaticaParser.AdicionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(GramaticaParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identificador}
	 * labeled alternative in {@link GramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(GramaticaParser.IdentificadorContext ctx);
}