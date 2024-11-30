package com.aoserver.utils;

public class TextFormat {
    private float r, g, b;
    private boolean bold, italic;

    public TextFormat() {
        this.r          = 0f;
        this.g          = 0f;
        this.b          = 0f;
        this.bold       = false;
        this.italic     = false;
    }

    public TextFormat(float r, float g, float b) {
        this.r          = r;
        this.g          = g;
        this.b          = b;
        this.bold       = false;
        this.italic     = false;
    }

    public TextFormat(float r, float g, float b, boolean bold) {
        this.r          = r;
        this.g          = g;
        this.b          = b;
        this.bold       = bold;
        this.italic     = false;
    }

    public TextFormat(float r, float g, float b, boolean bold, boolean italic) {
        this.r          = r;
        this.g          = g;
        this.b          = b;
        this.bold       = bold;
        this.italic     = italic;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }
}
