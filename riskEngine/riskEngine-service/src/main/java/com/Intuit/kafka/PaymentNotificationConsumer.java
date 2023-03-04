package com.Intuit.kafka;

import com.Intuit.models.Payment;
import com.Intuit.services.RiskEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class PaymentNotificationConsumer {
    @Autowired
    private RiskEngineService riskService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentNotificationConsumer.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Payment payment){
        LOGGER.info(String.format("payment recieved -> %s", payment.toString()));
        riskService.processPayment(payment);
    }
}
