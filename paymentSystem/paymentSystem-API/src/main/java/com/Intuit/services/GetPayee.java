package com.Intuit.services;

import com.Intuit.models.Payee;
import org.springframework.stereotype.Component;

@Component
public class GetPayee {

    public Payee getPayee(String ID){
        return generateDemmyPayee(ID);
    }

    private Payee generateDemmyPayee(String id) {
        return new Payee("lena" , "younis" , "hacarmel 13, tel aviv" ,
                "Leumi" , "123" , "123456" , id);
    }
}
