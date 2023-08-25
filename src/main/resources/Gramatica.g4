grammar Gramatica;

// Definición de reglas léxicas LEXER
INT: [0-9]+;                                  // Números enteros
DECIMAL: [0-9]+'.'[0-9]+;                     // Números decimales
STRING: '"' ~["\r\n]* '"';                    // Cadenas entre comillas dobles
BOOLEAN: ('true' | 'false');                  // Booleanos
IDENTIFICADOR: [a-zA-Z][a-zA-Z0-9]*;          // Identificadores
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
sentenciaIf: 'si' '(' condicion ')' '{' sentencia+ '}' sentenciaSino?;

//La sentencia SINO esta compuesta por una o mas sentencias.
sentenciaSino : 'sino' '{' sentencia+ '}';

//La sentencia WHILE esta compuesta por
sentenciaWhile: 'mientras' '(' condicion ')' '{' sentencia+ '}';

//Expresion de condicion. Ej: 5>4, 0!=variable, etc
condicion: expresion OPERADORCOMPARACION expresion;

//Diferentes expresiones.
expresion: '(' expresion ')'                              # parentesis
    | INT                                                 # entero
    | BOOLEAN                                             # booleano
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

