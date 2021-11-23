package com.pupu.search.learn.impl.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedRabbitMQConfig {
    public static final String DELAYED_EXCHANGE_NAME = "delay.exchange";
    public static final String DELAYED_ROUTING_KEY = "delay.queue.routingkey";
    public static final String DELAYED_QUEUE_NAME = "delay.queue";

    /**
     * 延迟交换机
     * @return
     */
    @Bean
    public CustomExchange delayedExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    @Bean
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    @Bean
    public Binding bindingNotify(@Qualifier("delayedQueue") Queue queue,
                                 @Qualifier("delayedExchange") CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
