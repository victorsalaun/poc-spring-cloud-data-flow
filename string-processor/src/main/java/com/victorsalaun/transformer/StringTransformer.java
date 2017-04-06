package com.victorsalaun.transformer;

import com.victorsalaun.properties.StringProcessorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class StringTransformer {

    private final StringProcessorProperties properties;

    @Autowired
    public StringTransformer(StringProcessorProperties properties) {
        this.properties = properties;
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Message<?> message) {
        return properties.getExpression().getValue(message);
    }

}
