package com.Intuit.models;

import com.Intuit.models.enums.Currency;

import java.io.Serializable;

public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private PayeeDTO payee;
    private double sum;
    private Currency curr;
    private PaymentMethodDTO paymentMethod;

    public PaymentDTO() {
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                ", payee=" + payee +
                ", sum=" + sum +
                ", curr=" + curr +
                ", paymentMethod=" + paymentMethod +
                '}';
    }


    public PayeeDTO getPayee() {
        return payee;
    }

    public void setPayee(PayeeDTO payee) {
        this.payee = payee;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Currency getCurr() {
        return curr;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
