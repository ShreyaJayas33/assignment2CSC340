package com.csc340.demo;

public class FunFact {
    private String text;
    private String source;

    // Constructor
    public FunFact(String text, String source) {
        this.text = text;
        this.source = source;
    }

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
