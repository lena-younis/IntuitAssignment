package com.Intuit.services;

import com.Intuit.models.Payee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GetPayees {

    public List<Payee> getAll(){
        return generateDummyPayeeList();
    }

    private List<Payee> generateDummyPayeeList() {
        List<Payee> response = new ArrayList<>();
        response.add(new Payee("lena" , "younis" , "hacarmel 13 , Tel aviv" ,
                "Leumi" , "123" , "123" , "1"));
        return response;
    }

}
