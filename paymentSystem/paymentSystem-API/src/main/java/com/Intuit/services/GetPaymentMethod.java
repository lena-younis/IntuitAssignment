package com.Intuit.services;

import com.Intuit.models.PaymentMethodDTO;
import com.Intuit.models.enums.PaymentMethodType;
import org.springframework.stereotype.Component;

@Component
public class GetPaymentMethod {

    public PaymentMethodDTO getPaymentMethod(String id){
        return generateDummyPaymentMethod(id);
    }

    private PaymentMethodDTO generateDummyPaymentMethod(String id) {

        PaymentMethodDTO pm = new PaymentMethodDTO("hai" , "cohen" , "1456" , "Central" , "111" , PaymentMethodType.transfer,id);
        return pm;
    }
}
