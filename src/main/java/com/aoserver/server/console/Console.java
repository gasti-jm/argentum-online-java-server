package com.aoserver.server.console;

import com.aoserver.AOServer;
import com.aoserver.server.ClientThread;
import com.aoserver.utils.Log;

import java.util.Scanner;

import static com.aoserver.AOServer.clients;

public class Console extends Thread {
    private boolean running;
    private Scanner input;
    private String command;

    public Console(Scanner input) {
        this.input = input;
        this.command = "";
        this.running = true;
    }

    @Override
    public void run() {
        // We dont stop while AO Server is running!
        while (running && input.hasNextLine()) {
            this.command = input.nextLine().toUpperCase();

                if(command.startsWith("/")) {
                    switch (command) {
                        case "/STOP":
                            Log.warn("Command /stop - Processing...");

                            Log.warn("Disconecting all users...");
                            for (ClientThread client : clients.values()) {
                                client.disconnect();
                            }

                            AOServer.closeServer();
                            running = false;
                            break;

                        case "/BAN":
                            // nothing to do...
                            break;

                        default:
                            Log.warn("The command doesn't exists.");
                    }

                } else {
                    Log.warn("The command doesn't exists.");
                }
        }
    }

    public boolean isRunning() {
        return running;
    }
}
