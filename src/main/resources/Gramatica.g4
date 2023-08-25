grammar Gramatica;

// Definición de reglas léxicas LEXER
IDENTIFICADOR: [a-zA-Z][a-zA-Z0-9]*;          // Identificadores
INT: [0-9]+;                                  // Números enteros
DECIMAL: [0-9]+'.'[0-9]+;                     // Números decimales
STRING: '"' ~["\r\n]* '"';                    // Cadenas entre comillas dobles
ASIGNACION: '=';
OPERADORCOMPARACION: ('==' | '!=' | '<' | '>' | '<=' | '>=');
OPERADORLOGICO: ('||' | '&&');
FINALIZADOR: ';';
// Ignorar espacios en blanco
BLANCO: [ \t\r\n]+ -> skip;

// Definición de reglas sintácticas PARSER
programa: sentencia+; //Sentencia General

//Sentencias Posibles para el lenguaje
sentencia: (sentenciaAsignacion | sentenciaEscritura | sentenciaIf | sentenciaWhile);

//La sentecia de asignacion esta compuesta por una o mas expresiones.
sentenciaAsignacion: IDENTIFICADOR ASIGNACION expresion FINALIZADOR;

//La sentecia de escritura esta compuesta por una o mas expresiones.
sentenciaEscritura: 'Escribir' expresion FINALIZADOR;

//La sentencia IF esta compuesta por condicion o condiciones.
sentenciaIf: 'si' '(' condicion ')' '{' sentencia+ '}' ('sino' '{' sentencia+ '}')?;

//La sentencia WHILE esta compuesta por
sentenciaWhile: 'mientras' '(' condicion ')' '{' sentencia+ '}';

//Expresion de condicion. Ej: 5>4, 0!=variable, etc
condicion: expresion OPERADORCOMPARACION expresion;

//Diferentes expresiones.
expresion: '(' expresion ')'                              # parentesis
    | INT                                                 # entero
    | DECIMAL                                             # decimal
    | STRING                                              # string
    | IDENTIFICADOR                                       # identificador
    | expresion OPERADORCOMPARACION expresion             # comparacion
    | expresion OPERADORLOGICO expresion                  # logico
    | expresion '+' expresion                             # adicion
    | expresion '-' expresion                             # sustraccion
    | expresion '*' expresion                             # multiplicacion
    | expresion '/' expresion                             # division
    | expresion '^' expresion                             # elevacion
    | expresion '%' expresion                             # modulo
    ;

