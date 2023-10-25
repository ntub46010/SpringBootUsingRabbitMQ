package com.vincent.demo;

import java.io.Serializable;

public class CommentMsg implements Serializable {
    private int postId;
    private int creatorId;
    private String content;
    private MsgSendMode mode;
    private String routingKey;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

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
