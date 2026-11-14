package com.aoserver.server;


import java.util.ArrayList;
import java.util.List;

public enum Motd {
    INSTANCE;

    private int maxLines;

    class MotdInfo {
        String text;
    }

    private List<MotdInfo> dataLines;

    Motd() {
        this.maxLines = 0;
        this.dataLines = new ArrayList<>();
    }

    public void loadMotd() {



    }


}
