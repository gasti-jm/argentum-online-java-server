package com.aoserver;

import com.aoserver.network.PacketBuffer;
import com.aoserver.server.ClientThread;
import com.aoserver.server.console.Console;
import com.aoserver.utils.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AOServer {
    // for test and launch options.
    public static boolean SERVER_DEBUG = false;
    private static ServerSocket svSocket = null;
    private Console console;

    // clients connected list (UserList in VB6)
    public static Map<Integer, ClientThread> clients = new HashMap<>();

    public AOServer() {
        this.console = new Console(new Scanner(System.in));
    }

    public void start() {
        Log.info("===========================================================================");
        Log.info("= Argentum Online - Java Server");
        Log.info("= Version: 13.0x Alkon");
        Log.info("= Running on {} / v{} [{}]", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch"));
        Log.info("= Java version: {}", System.getProperty("java.version"));
        Log.info("===========================================================================\n");

        initComponents();
        initSocket();
    }

    /**
     * Initializing Socket and own console.
     */
    private void initSocket() {
        try {
            svSocket = new ServerSocket(7666);
            Log.debug("Server socket opened in port 7666 (DEFAULT).");

            var consoleThread = new Thread(this.console);
            consoleThread.start();

            while(!svSocket.isClosed()) {
                var sv = svSocket.accept();
                var cl = new ClientThread(sv);

                clients.put(cl.getClientID(), cl);
                cl.start();
            }

        } catch (IOException e) {
            if (!svSocket.isClosed()) {
                Log.err("Server socket - {}", e.getMessage());
            }
        }
    }

    /**
     * Trying to read all data server files.
     */
    private void initComponents() {
        Log.info("Initializing data server...");
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Console getConsole() {
        return console;
    }

    /**
     * Close server socket.
     */
    public static void closeServer() {
        try {
            svSocket.close();
            Log.warn("Server close and finalized!");
        } catch (IOException e) {
            Log.err("Failed to close the server socket - {}", e.getMessage());
        }
    }
}
