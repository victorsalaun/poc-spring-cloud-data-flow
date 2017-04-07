package com.victorsalaun.input;

import com.victorsalaun.properties.LogSinkProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.stereotype.Component;

@Component
public class ChannelInput {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelInput.class.getCanonicalName());

    private final LogSinkProperties properties;

    @Autowired
    public ChannelInput(LogSinkProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ServiceActivator(inputChannel = Sink.INPUT)
    public LoggingHandler logSinkHandler() {
        LoggingHandler loggingHandler = new LoggingHandler(this.properties.getLevel().name());
        loggingHandler.setExpression(this.properties.getExpression());
        loggingHandler.setLoggerName(this.properties.getName());
        return loggingHandler;
    }

}
