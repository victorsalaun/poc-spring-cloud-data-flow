package com.victorsalaun.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
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
