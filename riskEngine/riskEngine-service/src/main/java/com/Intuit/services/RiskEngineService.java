package com.Intuit.services;

import com.Intuit.engine.RiskEngine;
import com.Intuit.kafka.PaymentNotificationConsumer;
import com.Intuit.kafka.PaymentNotificationProducer;
import com.Intuit.models.PaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RiskEngineService {
    @Autowired
    private RiskEngine engine;

    @Autowired
    private PaymentNotificationProducer producer;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentNotificationConsumer.class);

    public void processPayment(PaymentDTO payment){

        LOGGER.info("payment processing started");
        int risk = engine.calculateRisk();
        payment.setRisk(String.valueOf(risk));
        if(risk>=70)
            payment.setStatus("Accepted");
        else
            payment.setStatus("Rejected");

        LOGGER.info("risk for payment is " + risk + ", payment is " + payment.getStatus());
        producer.produce(payment);
        LOGGER.info("processed payment successfully produced on ProcessedPayments topic");

    }
}
