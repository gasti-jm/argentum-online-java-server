package com.aoserver;

import com.aoserver.server.ClientThread;

import javax.swing.*;
import java.net.ServerSocket;

public class AOServer {
    private ServerSocket ss;

    public AOServer() {
        this.ss     = null;
    }

    public void start() {
        initComponents();
        initSocket();
    }

    private void initSocket() {
        try {
            ss = new ServerSocket(7666);

            System.out.println("Argentum Online - Java Server");
            System.out.println("Version: 13.0");

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


    }
}
