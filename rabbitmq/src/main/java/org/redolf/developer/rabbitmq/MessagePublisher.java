package org.redolf.developer.rabbitmq;


import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rabbitmq")
@AllArgsConstructor
public class MessagePublisher {

    private RabbitTemplate template;

    @PostMapping("/publish/")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(RabbitMQConfiguration.MESSAGE_EXCHANGE, RabbitMQConfiguration.MESSAGE_ROUTING_KEY, message);
        return "Published__";
    }

    @GetMapping("/")
    private String hellow(){
        return "Hello world";
    }
}
