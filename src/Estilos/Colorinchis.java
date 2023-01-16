package Estilos;


public class Colorinchis {

    public static String red (String frase) {
        return "\u001B[31m"+frase+"\u001B[0m";
    }

    public static String red (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[31m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[31m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[31m"+frase+"\u001B[0m";
        } else {
            return "\u001B[31m"+frase+"\u001B[0m";
        }
    }

    public static String red (char caracter) {
        return "\u001B[31m"+caracter+"\u001B[0m";
    }

    public static String red (int numero) {
        return "\u001B[31m"+numero+"\u001B[0m";
    }

    public static String red (double numero) {
        return "\u001B[31m"+numero+"\u001B[0m";
    }

    public static String black (String frase) {
        return "\u001B[30m"+frase+"\u001B[0m";
    }

    public static String black (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[30m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[30m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[30m"+frase+"\u001B[0m";
        } else {
            return "\u001B[30m"+frase+"\u001B[0m";
        }
    }

    public static String black (char caracter) {
        return "\u001B[30m"+caracter+"\u001B[0m";
    }

    public static String black (int numero) {
        return "\u001B[30m"+numero+"\u001B[0m";
    }

    public static String black (double numero) {
        return "\u001B[30m"+numero+"\u001B[0m";
    }

    public static String green (String frase) {
        return "\u001B[32m"+frase+"\u001B[0m";
    }

    public static String green (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[32m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[32m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[32m"+frase+"\u001B[0m";
        } else {
            return "\u001B[32m"+frase+"\u001B[0m";
        }
    }

    public static String green (char caracter) {
        return "\u001B[32m"+caracter+"\u001B[0m";
    }
    
    public static String green (int numero) {
        return "\u001B[32m"+numero+"\u001B[0m";
    }
    
    public static String green (double numero) {
        return "\u001B[32m"+numero+"\u001B[0m";
    }

    public static String yellow (String frase) {
        return "\u001B[33m"+frase+"\u001B[0m";
    }
    
    public static String yellow (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[33m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[33m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[33m"+frase+"\u001B[0m";
        } else {
            return "\u001B[33m"+frase+"\u001B[0m";
        }
    }
    
    public static String yellow (char caracter) {
        return "\u001B[33m"+caracter+"\u001B[0m";
    }
    
    public static String yellow (int numero) {
        return "\u001B[33m"+numero+"\u001B[0m";
    }
    
    public static String yellow (double numero) {
        return "\u001B[33m"+numero+"\u001B[0m";
    }

    public static String blue (String frase) {
        return "\u001B[34m"+frase+"\u001B[0m";
    }
    
    public static String blue (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[34m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[34m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[34m"+frase+"\u001B[0m";
        } else {
            return "\u001B[34m"+frase+"\u001B[0m";
        }
    }
    
    public static String blue (char caracter) {
        return "\u001B[34m"+caracter+"\u001B[0m";
    }
    
    public static String blue (int numero) {
        return "\u001B[34m"+numero+"\u001B[0m";
    }
    
    public static String blue (double numero) {
        return "\u001B[34m"+numero+"\u001B[0m";
    }

    public static String purple (String frase) {
        return "\u001B[35m"+frase+"\u001B[0m";
    }
    
    public static String purple (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[35m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[35m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[35m"+frase+"\u001B[0m";
        } else {
            return "\u001B[35m"+frase+"\u001B[0m";
        }
    }
    
    public static String purple (char caracter) {
        return "\u001B[35m"+caracter+"\u001B[0m";
    }
    
    public static String purple (int numero) {
        return "\u001B[35m"+numero+"\u001B[0m";
    }

    public static String purple (double numero) {
        return "\u001B[35m"+numero+"\u001B[0m";
    }

    public static String cyan (String frase) {
        return "\u001B[36m"+frase+"\u001B[0m";
    }

    public static String cyan (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[36m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[36m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[36m"+frase+"\u001B[0m";
        } else {
            return "\u001B[36m"+frase+"\u001B[0m";
        }
    }

    public static String cyan (char caracter) {
        return "\u001B[36m"+caracter+"\u001B[0m";
    }
 
    public static String cyan (int numero) {
        return "\u001B[36m"+numero+"\u001B[0m";
    }

    public static String cyan (double numero) {
        return "\u001B[36m"+numero+"\u001B[0m";
    }

    public static String white (String frase) {
        return "\u001B[37m"+frase+"\u001B[0m";
    }

    public static String white (String frase, boolean bold, boolean italic) {
        if (bold && italic) {
            return "\u001B[1m\033[3m\u001B[37m"+frase+"\u001B[0m";
        } else if (!bold && italic) {
            return "\033[3m\u001B[37m"+frase+"\u001B[0m";
        } else if (bold && !italic) {
            return "\u001B[1m\u001B[37m"+frase+"\u001B[0m";
        } else {
            return "\u001B[37m"+frase+"\u001B[0m";
        }
    }

    public static String white (char caracter) {
        return "\u001B[37m"+caracter+"\u001B[0m";
    }

    public static String white (int numero) {
        return "\u001B[37m"+numero+"\u001B[0m";
    }

    public static String white (double numero) {
        return "\u001B[37m"+numero+"\u001B[0m";
    }

    public static String rainbow (String frase) {
        int contador = 0;
        String[] letras = frase.split("");
        String[] colores = {"\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m"};
        for (int i = 0; i < letras.length; i++) {
            letras[i] = colores[contador] + letras[i];
            contador++;
            if (contador == 6) {
                contador = 0;
            }
        }
        return String.join("", letras) + "\u001B[0m";
    }
}
