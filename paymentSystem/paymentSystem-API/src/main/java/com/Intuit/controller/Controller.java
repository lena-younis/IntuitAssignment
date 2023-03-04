package com.Intuit.controller;

import com.Intuit.models.Payee;
import com.Intuit.models.PaymentMethod;
import com.Intuit.models.PaymentRequest;
import com.Intuit.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Intuit.errorHandling.BadRequestException;

import java.util.List;


@RestController
@RequestMapping("/paymentManagement")
public class Controller {

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
    private Logger logger = LoggerFactory.getLogger(Controller.class);


    @PostMapping(value="/createPayment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPayment(@RequestBody String payload) throws JsonProcessingException {

        logger.info("received create payment request with details : "+payload.toString());
        ObjectMapper mapper = new ObjectMapper();
        PaymentRequest req = mapper.readValue(payload ,PaymentRequest.class);
        ResponseEntity<String> response;
        try{
            logger.debug("creating payment with payment request: " + req.toString());
            return createPaymentService.createPayment(req);
        }
        catch(BadRequestException e){
            logger.error("execption caught while creating payment , exception is : " + e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping(value = "/allPaymentMethods", produces={"application/json"})
    public @ResponseBody List<PaymentMethod> getAllPaymentMethods(){
        logger.info("received GET payment methods request");
        return getPaymentMethodsListService.getAll();
    }

    @GetMapping(value = "/allPayees", produces={"application/json"})
    public @ResponseBody List<Payee> getAllPayees(){
        logger.info("received GET payees request");
        return getPayeesListService.getAll();
    }

    @GetMapping(value = "/paymentMethod/{id}", produces={"application/json"})
    public @ResponseBody PaymentMethod getPaymentMethod(@PathVariable("id") String id){
        logger.info("received GET payment method request for id: "+id);
        return getPaymentMethodService.getPaymentMethod(id);

    }

    @GetMapping(value = "/Payee/{id}", produces={"application/json"})
    public @ResponseBody Payee getPayee(@PathVariable("id") String id){
        logger.info("received GET payee request for id: "+id);
        return getPayeeService.getPayee(id);
    }


}

