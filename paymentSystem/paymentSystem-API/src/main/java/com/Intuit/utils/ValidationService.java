package com.Intuit.utils;

import com.Intuit.errorHandling.BadRequestException;
import com.Intuit.models.Payee;
import com.Intuit.models.PaymentMethod;
import com.Intuit.models.PaymentRequest;
import com.Intuit.models.enums.Currency;
import com.Intuit.services.GetPayees;
import com.Intuit.services.GetPaymentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ValidationService {

    @Autowired
    private GetPaymentMethods getPaymentMethodsListService;

    @Autowired
    private GetPayees getPayeesListService;

    public void validatePaymentRequest(PaymentRequest request) throws BadRequestException {
        if(request.getPaymentMethodId()==null
                || request.getPayeeId()==null
                || request.getCurrency()==null)
            throw new BadRequestException("request params cant be null");
        if(!isValidPayee(request.getPayeeId())) throw new BadRequestException("payee not found");
        if(!isValidPaymentMethod(request.getPaymentMethodId())) throw new BadRequestException("payment Method not found");
        if(!isValidCurrency(request.getCurrency())) throw new BadRequestException("currency invalid or not supported");
    }

    private boolean isValidPayee(String payeeId) {
        List<Payee> payees = getPayeesListService.getAll();
        for(Payee payee : payees){
            if(payee.getID().equals(payeeId)) return true;
        }
        return false;
    }

    private boolean isValidPaymentMethod(String paymentMethodId) {
        List<PaymentMethod> paymentMethods = getPaymentMethodsListService.getAll();
        for(PaymentMethod p : paymentMethods){
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
