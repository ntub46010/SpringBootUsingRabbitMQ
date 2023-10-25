package com.vincent.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @PostMapping("/comment")
    public void notifyNewComment(@RequestBody CommentMsg comment) {
        producer.sendNewCommentNotification(comment);
    }
}