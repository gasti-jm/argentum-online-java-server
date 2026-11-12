package com.aoserver.server;

import com.aoserver.network.Protocol;
import com.aoserver.utils.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class ClientThread extends Thread{
    public static long contID = 0;

    private long id;
    private Socket sc;
    private DataInputStream handleData;
    private DataOutputStream writeData;
    private Protocol protocol;

    public ClientThread(Socket sc) {
        contID++;

        this.id = contID;
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
            this.writeData  = new DataOutputStream(sc.getOutputStream());

            final byte[] dataBuffer = new byte[10240]; // uwu
            int bytesRead; // leemos los bytes que recibimos

            while ((bytesRead = handleData.read(dataBuffer)) != -1) {
                readData(bytesRead, dataBuffer);
            }


        } catch (Exception e) {
            Log.err("Client #{} error: {}", id, e.getMessage());

        } finally {
            Log.debug("Client #{} disconnect from the server.", id);
            close();
        }

    }
}
