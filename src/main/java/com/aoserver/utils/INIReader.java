package com.aoserver.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class INIReader {
    private String filePath;
    private BufferedReader reader;

    INIReader(String filePath) {
        this.filePath = filePath;
    }

//    public void load() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("=");
//                if (parts.length == 2) {
//                    String option = parts[0].trim();
//                    String value = parts[1].trim();
//                    //load(option, value);
//                }
//            }
//
//        } catch (IOException e) {
//            Log.err("The {} file was not found or could not be read.", filePath);
//        }
    //}

    /**
     * Escribe una opcion con su valor asociado en un objeto {@code BufferedWriter}.
     *
     * @param writer objeto {@code BufferedWriter} que sera utilizado para escribir
     *               la opcion
     * @param option nombre de la opcion
     * @param value  valor de la opcion
     */
    private void write(BufferedWriter writer, String option, Object value) throws IOException {
        writer.write(option + " = " + value);
        writer.newLine();
    }



//    private void load(String option, String value) {
//        switch (option) {
//            case "Music" -> music = Boolean.parseBoolean(value);
//            case "Sound" -> sound = Boolean.parseBoolean(value);
//            case "ShowName" -> showName = Boolean.parseBoolean(value);
//            case "Name" -> nick = value;
//            case "IP" -> ipServer = value;
//            case "PORT" -> portServer = value;
//            case "Fullscreen" -> fullscreen = Boolean.parseBoolean(value);
//            case "VSYNC" -> vsync = Boolean.parseBoolean(value);
//            case "CursorGraphic" -> cursorGraphic = Boolean.parseBoolean(value);
//            case "BreathingEffect" -> breathingEffect = Boolean.parseBoolean(value);
//            case "Language" -> language = value;
//            default -> Logger.warn("Unknown option ignored: {}", option);
//        }
//    }


}
