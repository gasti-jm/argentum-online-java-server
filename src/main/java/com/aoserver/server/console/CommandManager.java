package com.aoserver.server.console;

import com.aoserver.utils.Log;

public class CommandManager {

    public static void seeCommand(String command) {
        if(!isCommand(command)) return;


    }

    public static boolean isCommand(String c) {
        return c.startsWith("/");
    }
}
