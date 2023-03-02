package com.Intuit.services;

import com.Intuit.models.PayeeDTO;
import com.Intuit.models.PaymentMethodDTO;
import com.Intuit.models.enums.PaymentMethodType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GetPaymentMethods {

    public List<PaymentMethodDTO> getAll(){
        return generateDummyPaymentMethodList();
    }

    private List<PaymentMethodDTO> generateDummyPaymentMethodList() {
        List<PaymentMethodDTO> response = new ArrayList<>();
        response.add(new PaymentMethodDTO("hai" , "cohen" , "1456" , "Central" , "111" , PaymentMethodType.transfer,"10"));
        return response;
    }
}
