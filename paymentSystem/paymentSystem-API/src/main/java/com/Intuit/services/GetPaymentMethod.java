package com.Intuit.services;

import com.Intuit.models.PaymentMethod;
import com.Intuit.models.enums.PaymentMethodType;
import org.springframework.stereotype.Component;

@Component
public class GetPaymentMethod {

    public PaymentMethod getPaymentMethod(String id){
        return generateDummyPaymentMethod(id);
    }

    private PaymentMethod generateDummyPaymentMethod(String id) {
        return new PaymentMethod("hai" , "cohen" , "1456" , "Central" , "111" , PaymentMethodType.transfer,id);
    }
}
