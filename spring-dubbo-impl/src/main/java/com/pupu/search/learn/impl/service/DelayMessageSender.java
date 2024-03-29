package com.pupu.search.learn.impl.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pupu.search.learn.impl.config.DelayedRabbitMQConfig.DELAYED_EXCHANGE_NAME;
import static com.pupu.search.learn.impl.config.DelayedRabbitMQConfig.DELAYED_ROUTING_KEY;

@Component
public class DelayMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDelayMsg(String msg, Integer delayTime) {
        rabbitTemplate.convertAndSend(DELAYED_EXCHANGE_NAME,
                DELAYED_ROUTING_KEY, msg, a ->{
            // 设置延迟时间，单位是毫秒
            a.getMessageProperties().setDelay(delayTime);
            return a;
        });
    }
}
