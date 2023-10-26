package com.vincent.demo;

import java.io.Serializable;

public class CommentMsg implements Serializable {
    private String content;
    private MsgSendMode mode;
    private String routingKey;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MsgSendMode getMode() {
        return mode;
    }

    public void setMode(MsgSendMode mode) {
        this.mode = mode;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}