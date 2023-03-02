package com.Intuit.paymentSystem.API.Controller;

import com.Intuit.models.PayeeDTO;
import com.Intuit.models.PaymentMethodDTO;
import com.Intuit.models.PaymentRequest;
import com.Intuit.services.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/paymentManagement")
public class controller {

    @Inject
    private CreatePayment createPaymentService;

    @Inject
    private GetPayee getPayeeService;

    @Inject
    private GetPayees getPayeesListService;

    @Inject
    private GetPaymentMethod getPaymentMethodService;

    @Inject
    private GetPaymentMethods getPaymentMethodsListService;

    @PostMapping(value="/createPayment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPayment(@RequestParam("sum") String sum, @RequestParam("currency") String currency, @RequestParam("payeeId") String payeeId,
                                                @RequestParam("paymentMethodId") String paymentMethodId) {

        PaymentRequest req = new PaymentRequest(payeeId, paymentMethodId, sum, currency);
        return createPaymentService.createPayment(req);

    }

    @GetMapping(value = "/allPaymentMethods", produces={"application/json"})
    public @ResponseBody List<PaymentMethodDTO> getAllPaymentMethods(){
        List<PaymentMethodDTO> response = getPaymentMethodsListService.getAll();
        return response;
    }

    @GetMapping(value = "/allPayees", produces={"application/json"})
    public @ResponseBody List<PayeeDTO> getAllPayees(){
        List<PayeeDTO> response = getPayeesListService.getAll();
        return response;
    }

    @GetMapping(value = "/paymentMethod/{id}", produces={"application/json"})
    public @ResponseBody PaymentMethodDTO getPaymentMethod(@PathVariable("id") String id){
        PaymentMethodDTO response = getPaymentMethodService.getPaymentMethod(id);

        return response;
    }

    @GetMapping(value = "/Payee/{id}", produces={"application/json"})
    public @ResponseBody PayeeDTO getPayee(@PathVariable("id") String id){
        PayeeDTO response = getPayeeService.getPayee(id);
        return response;
    }


}

