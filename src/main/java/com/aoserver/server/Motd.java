package com.aoserver.server;

import com.aoserver.utils.TextFormat;

import java.util.ArrayList;
import java.util.List;

public class Motd {
    private static Motd instance = null;

    private int maxLines;

    class MotdInfo {
        String text;
        TextFormat format;
    }

    private List<MotdInfo> dataLines;

    private Motd() {
        this.maxLines = 0;
        this.dataLines = new ArrayList<>();
    }

    public static Motd getInstance() {
        if(instance == null) {
            instance = new Motd();
        }

        return instance;
    }

    public void loadMotd() {



    }



}
