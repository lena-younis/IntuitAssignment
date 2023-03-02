package com.Intuit.models;

import com.Intuit.models.enums.Currency;

public class PaymentRequest {

    private String payeeId;
    private String paymentMethodId;
    private double sum;
    private String currency;

    public PaymentRequest(String payeeId , String paymentMethodId , String sum , String currency){
        this.paymentMethodId = paymentMethodId;
        this.currency = currency;
        this.payeeId = payeeId;
        this.sum = Double.valueOf(sum);
    }

    public double getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public PaymentRequest() {
    }

    public PaymentRequest(String payeeId, String paymentMethodId, double sum, String currency) {
        this.payeeId = payeeId;
        this.paymentMethodId = paymentMethodId;
        this.sum = sum;
        this.currency = currency;
    }
}
