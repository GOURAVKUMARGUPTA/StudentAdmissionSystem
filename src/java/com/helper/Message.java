
package com.helper;

public class Message {
    
    private String content;
    private String color;
    private String icon;

    public Message(String content, String color, String icon) {
        this.content = content;
        this.color = color;
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
}
