package com.mrt.dictionary.Models;

public class Phonetics {
    String text = "";
    String audio = "";

    public String getText() { /*getter setter metotları belirledik*/
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
