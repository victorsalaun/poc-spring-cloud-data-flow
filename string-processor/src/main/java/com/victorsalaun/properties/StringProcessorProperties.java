package com.victorsalaun.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@ConfigurationProperties("transformer")
public class StringProcessorProperties {

    private static final Expression DEFAULT_EXPRESSION = new SpelExpressionParser().parseExpression("payload");

    private Expression expression = DEFAULT_EXPRESSION;

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

}
