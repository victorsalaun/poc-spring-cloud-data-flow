package com.victorsalaun.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ChannelOutput {

    private final Source channels;

    @Autowired
    public ChannelOutput(Source channels) {
        this.channels = channels;
    }

    public void sendMessage(String message) {
        channels.output().send(MessageBuilder.createMessage(message,
                new MessageHeaders(Collections.singletonMap(MessageHeaders.CONTENT_TYPE, "text/html"))));
    }

}
