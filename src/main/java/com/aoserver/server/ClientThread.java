package com.aoserver.server;

import com.aoserver.network.Protocol;
import com.aoserver.utils.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientThread extends Thread{
    public static long contClients = 0;

    private long id;
    private Socket sc;
    private DataInputStream handleData;
    private DataOutputStream writeData;
    private Protocol protocol;

    public ClientThread(Socket sc) {
        contClients++;

        this.id = contClients;
        this.sc = sc;
        this.handleData = null;
        this.writeData = null;
        this.protocol = new Protocol(id);
    }


    public void close() {
        try {
            handleData.close();
            writeData.close();
            sc.close();

            contClients--;

        } catch (IOException e) {
            Log.err(e.getMessage());
        }
    }

    /**
     * Read complete own array bytes and read each packet.
     */
    private void readData(final int bytesRead, final byte[] dataBuffer)  {
        if (bytesRead > 0) {
            // Put data in the buffer
            protocol.putDataBuffer(dataBuffer);

            //Send buffer to handle data
            protocol.handleIncomingData();
        }
    }

    private void sendData() {
        // nothing to do...
    }

    @Override
    public void run() {
        Log.debug("Client #{} has been connected with the IP {}:{}",
                id, sc.getInetAddress().toString(), sc.getPort()
        );

        try {
            this.handleData = new DataInputStream(sc.getInputStream());
            this.writeData = new DataOutputStream(sc.getOutputStream());


            byte[] buffer = new byte[10240];
            int bytesRead;

            // read() bloquea el hilo hasta que lleguen datos o se cierre el socket (-1)
            while ((bytesRead = handleData.read(buffer)) != -1) {
                // Copiamos solo los bytes realmente leídos para pasarlos a tu protocolo
                byte[] exactData = Arrays.copyOf(buffer, bytesRead);
                readData(bytesRead, exactData);
            }



        } catch (Exception e) {
            Log.err("Client #{} error - {}", id, e.getMessage());

        } finally {
            Log.debug("Client #{} has been disconnect from the server.", id);
            close();
        }

    }


    /**
     * Verifica si el socket esta listo para escribir datos.
     *
     * @return true si el socket esta conectado y el flujo de salida esta disponible
     */
    private boolean isReadyForWriting() {
        return isReadyForCommunication() && writeData != null;
    }

    /**
     * Verifica si el socket esta listo para leer datos.
     *
     * @return true si el socket esta conectado y el flujo de entrada esta disponible
     */
    private boolean isReadyForReading() {
        return isReadyForCommunication() && handleData != null;
    }

    /**
     * Verifica si el socket esta preparado para comunicarse.
     *
     * @return true si el socket existe, esta conectado y no esta cerrado
     */
    private boolean isReadyForCommunication() {
        return sc != null && sc.isConnected() && !sc.isClosed();
    }

}
