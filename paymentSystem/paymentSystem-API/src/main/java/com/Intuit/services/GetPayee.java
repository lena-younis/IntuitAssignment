package com.Intuit.services;

import com.Intuit.models.PayeeDTO;
import org.springframework.stereotype.Component;

@Component
public class GetPayee {

    public PayeeDTO getPayee(String ID){
        return generateDemmyPayee(ID);
    }

    private PayeeDTO generateDemmyPayee(String id) {
        PayeeDTO payee = new PayeeDTO("lena" , "younis" , "hacarmel 13, tel aviv" ,
                "Leumi" , "123" , "123456" , id);
        return payee;
    }
}
