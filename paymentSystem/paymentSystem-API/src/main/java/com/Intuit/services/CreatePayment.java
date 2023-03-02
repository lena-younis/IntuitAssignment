package com.Intuit.services;

import com.Intuit.ErrorHandling.BadRequestException;
import com.Intuit.kafka.PaymentNotificationProducer;
import com.Intuit.models.PayeeDTO;
import com.Intuit.models.PaymentDTO;
import com.Intuit.models.PaymentMethodDTO;
import com.Intuit.models.PaymentRequest;
import com.Intuit.models.enums.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.inject.Inject;


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



    public ResponseEntity<String> createPayment(PaymentRequest request) throws BadRequestException {

        logger.info("validating payment request ..");
        validatePaymentRequest(request);

        PaymentDTO payment= new PaymentDTO();
        payment.setSum(request.getSum());
        payment.setPaymentMethod(getPaymentMethodService.getPaymentMethod(request.getPaymentMethodId()));
        payment.setPayee(getPayeeService.getPayee(request.getPayeeId()));
        payment.setCurr(Currency.valueOf(request.getCurrency()));

        logger.info("producing payment notification on kafka topic for risk analysis");
        paymentNotificationProducer.produce(payment);
        logger.info("successfully produced payment notification to 'Payments'");

        ResponseEntity<String> response= new ResponseEntity<>(HttpStatusCode.valueOf(201));
        return response;
    }

    private void validatePaymentRequest(PaymentRequest request) throws BadRequestException {
        if(request.getPaymentMethodId()==null
                || request.getPayeeId()==null
                || request.getCurrency()==null)
            throw new BadRequestException("request params cant be null");
        if(!isValidPayee(request.getPayeeId())) throw new BadRequestException("payee not found");
        if(!isValidPaymentMethod(request.getPaymentMethodId())) throw new BadRequestException("payment Method not found");
        if(!isValidCurrency(request.getCurrency())) throw new BadRequestException("currency invalid or not supported");
        }

    private boolean isValidPayee(String payeeId) {
        List<PayeeDTO> payees = getPayeesListService.getAll();
        for(PayeeDTO payee : payees){
            if(payee.getID().equals(payeeId)) return true;
        }
        return false;
    }

    private boolean isValidPaymentMethod(String paymentMethodId) {
        List<PaymentMethodDTO> paymentMethods = getPaymentMethodsListService.getAll();
        for(PaymentMethodDTO p : paymentMethods){
            if(p.getID().equals(paymentMethodId)) return true;
        }
        return false;
    }

    public boolean isValidCurrency(String currency) {
        for (Currency curr : Currency.values()) {
            if (curr.name().equalsIgnoreCase(currency)) return true;
        }
        return false;
    }


}

