package com.pupu.search.learn.impl.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

import static com.pupu.search.learn.impl.config.DelayedRabbitMQConfig.DELAYED_QUEUE_NAME;


@Slf4j
@Component
public class DelayedQueueConsumer {

    @RabbitListener(queues = DELAYED_QUEUE_NAME)
    public void receiveDelayedMessage(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("当前时间：{},延时队列收到消息：{}", new Date().toString(), msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}