package com.Intuit.controller;

import com.Intuit.models.PayeeDTO;
import com.Intuit.models.PaymentMethodDTO;
import com.Intuit.models.PaymentRequest;
import com.Intuit.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import com.Intuit.ErrorHandling.BadRequestException;

import java.util.List;


@RestController
@RequestMapping("/paymentManagement")
public class controller {

    @Autowired
    private CreatePayment createPaymentService;

    @Autowired
    private GetPayee getPayeeService;

    @Autowired
    private GetPayees getPayeesListService;

    @Autowired
    private GetPaymentMethod getPaymentMethodService;

    @Autowired
    private GetPaymentMethods getPaymentMethodsListService;
    private Logger logger = LoggerFactory.getLogger(controller.class);


    @PostMapping(value="/createPayment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPayment(@RequestBody String payload) throws JsonProcessingException {

        logger.info("received create payment request with details : "+payload.toString()); //sum " + sum +", currency "+currency +", payeeId "+payeeId +" and paymentMethodId " + paymentMethodId + ".");
        ObjectMapper mapper = new ObjectMapper();
        PaymentRequest req = mapper.readValue(payload ,PaymentRequest.class);
         //new PaymentRequest(payeeId, paymentMethodId, sum, currency);
        ResponseEntity<String> response;
        try{
            logger.debug("creating payment with payment request: " + req.toString());
            response =  createPaymentService.createPayment(req);
        }
        catch(BadRequestException e){
            logger.error("execption caught while creating payment , exception is : " + e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        finally {
            return ResponseEntity.created(null).body("payment successfully posted for risk analysis");
        }

    }

    @GetMapping(value = "/allPaymentMethods", produces={"application/json"})
    public @ResponseBody List<PaymentMethodDTO> getAllPaymentMethods(){
        logger.info("received GET payment methods request");
        List<PaymentMethodDTO> response = getPaymentMethodsListService.getAll();
        return response;
    }

    @GetMapping(value = "/allPayees", produces={"application/json"})
    public @ResponseBody List<PayeeDTO> getAllPayees(){
        logger.info("received GET payees request");
        List<PayeeDTO> response = getPayeesListService.getAll();
        return response;
    }

    @GetMapping(value = "/paymentMethod/{id}", produces={"application/json"})
    public @ResponseBody PaymentMethodDTO getPaymentMethod(@PathVariable("id") String id){
        logger.info("received GET payment method request for id: "+id);
        PaymentMethodDTO response = getPaymentMethodService.getPaymentMethod(id);

        return response;
    }

    @GetMapping(value = "/Payee/{id}", produces={"application/json"})
    public @ResponseBody PayeeDTO getPayee(@PathVariable("id") String id){
        logger.info("received GET payee request for id: "+id);
        PayeeDTO response = getPayeeService.getPayee(id);
        return response;
    }


}

