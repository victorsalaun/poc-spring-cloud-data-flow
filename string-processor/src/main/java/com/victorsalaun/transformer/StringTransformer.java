package com.victorsalaun.transformer;

import com.victorsalaun.properties.StringProcessorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class StringTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringTransformer.class.getCanonicalName());

    private final StringProcessorProperties properties;

    @Autowired
    public StringTransformer(StringProcessorProperties properties) {
        this.properties = properties;
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Message<?> message) {
        LOGGER.info("Transforming message: " + message);
        String transformedMessage = (String) properties.getExpression().getValue(message);
        LOGGER.info("Transformed message: " + transformedMessage);
        return transformedMessage;
    }

}
