package com.Intuit.services;

import com.Intuit.models.PaymentMethod;
import com.Intuit.models.enums.PaymentMethodType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GetPaymentMethods {

    public List<PaymentMethod> getAll(){
        return generateDummyPaymentMethodList();
    }

    private List<PaymentMethod> generateDummyPaymentMethodList() {
        List<PaymentMethod> response = new ArrayList<>();
        response.add(new PaymentMethod("hai" , "cohen" , "1456" , "Central" , "111" , PaymentMethodType.transfer,"10"));
        return response;
    }
}
