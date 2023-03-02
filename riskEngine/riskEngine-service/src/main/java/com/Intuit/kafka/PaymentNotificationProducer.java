package com.Intuit.kafka;

import com.Intuit.models.PaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PaymentNotificationProducer {

    @Value("${spring.kafka.producer.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentNotificationProducer.class);

    private KafkaTemplate<String, PaymentDTO> kafkaTemplate;

    public PaymentNotificationProducer(KafkaTemplate<String, PaymentDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(PaymentDTO data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<PaymentDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        kafkaTemplate.send(message);
    }
}
