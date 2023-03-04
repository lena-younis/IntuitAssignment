package com.Intuit.services;

import com.Intuit.errorHandling.BadRequestException;
import com.Intuit.kafka.PaymentNotificationProducer;
import com.Intuit.models.Payment;
import com.Intuit.models.PaymentRequest;
import com.Intuit.models.enums.Currency;
import com.Intuit.utils.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class CreatePayment {

    private Logger logger = LoggerFactory.getLogger(CreatePayment.class);

    @Autowired
    private PaymentNotificationProducer paymentNotificationProducer;

    @Autowired
    private GetPayee getPayeeService;

    @Autowired
    private GetPaymentMethods getPaymentMethodsListService;

    @Autowired
    private GetPayees getPayeesListService;

    @Autowired
    private GetPaymentMethod getPaymentMethodService;

    @Autowired
    private ValidationService validator;



    public ResponseEntity<String> createPayment(PaymentRequest request) throws BadRequestException {

        logger.info("validating payment request ..");
        validator.validatePaymentRequest(request);

        Payment payment= new Payment();
        payment.setSum(request.getSum());
        payment.setCurr(Currency.valueOf(request.getCurrency()));

        payment.setPaymentMethod(getPaymentMethodService.getPaymentMethod(request.getPaymentMethodId()));
        payment.setPayee(getPayeeService.getPayee(request.getPayeeId()));

        logger.info("producing payment notification on kafka topic for risk analysis");
        paymentNotificationProducer.produce(payment);
        logger.info("successfully produced payment notification to 'Payments'");

        return new ResponseEntity<>(HttpStatusCode.valueOf(201));

    }




}

