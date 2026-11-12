package com.aoserver;

import com.aoserver.server.ClientThread;
import com.aoserver.utils.Log;

import javax.swing.*;
import java.net.ServerSocket;

public class AOServer {

    // for test and launch options.
    public static boolean SERVER_DEBUG = false;
    private ServerSocket ss;

    public AOServer() {
        this.ss     = null;
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

    private void initSocket() {
        Log.info("Opening server socket in port 7666 (DEFAULT).");

        try {
            ss = new ServerSocket(7666);

            while(!ss.isClosed()) {
                new ClientThread(ss.accept()).start();
            }

            ss.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Intentamos leer los archivos .ini originales de AO 13.0
     */
    private void initComponents() {
        Log.info("Initializing data server...");
    }
}
