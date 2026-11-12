package com.aoserver;

/**
 * Aqui comienza nuestro servidor de AO en Java, la idea es migrarlo a un lenguaje moderno para poder aprovechar APIs y
 * tecnologias modernas.
 */
public class Main {
    public static void main(String[] args) {

        // are we in debug mode?
        for (String arg: args) {
            if (arg.equals("-debug")) {
                AOServer.SERVER_DEBUG = true;
                break;
            }
        }

        new AOServer().start();
    }
}