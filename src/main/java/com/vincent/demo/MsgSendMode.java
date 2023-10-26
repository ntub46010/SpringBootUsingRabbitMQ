package com.vincent.demo;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum MsgSendMode {
    ROUTING, TOPIC;

    @JsonCreator
    public static MsgSendMode from(String key) {
        return Arrays.stream(values())
                .filter(x -> x.name().equalsIgnoreCase(key))
                .findFirst()
                .orElse(null);
    }
}