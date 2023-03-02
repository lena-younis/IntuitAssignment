package com.Intuit.engine;

import com.Intuit.kafka.PaymentNotificationConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RiskEngine {

    private static int generated;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentNotificationConsumer.class);

    public int calculateRisk(){
        LOGGER.info("calculating payment risk");
        //generate random risk
        int risk;
        Random r = new Random();
        if(generated%10>2)
            risk = 70 + r.nextInt(31) ;
        else risk = r.nextInt(31);

        generated++;
        return risk;
    }
}
