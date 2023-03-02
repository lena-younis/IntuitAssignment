package com.Intuit.services;

import com.Intuit.models.PayeeDTO;
import org.apache.coyote.Response;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Component
public class GetPayees {

    public List<PayeeDTO> getAll(){
        return generateDummyPayeeList();
    }

    private List<PayeeDTO> generateDummyPayeeList() {
        List<PayeeDTO> response = new ArrayList<>();
        response.add(new PayeeDTO("lena" , "younis" , "hacarmel 13 , Tel aviv" ,
                "Leumi" , "123" , "123" , "1"));
        return response;
    }

}
