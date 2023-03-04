package com.Intuit.models;

import com.Intuit.models.enums.Currency;

import java.io.Serializable;
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Status;

    private String risk;

    private Payee payee;
    private double sum;
    private Currency curr;
    private PaymentMethod paymentMethod;

    public Payment() {
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "Status='" + Status + '\'' +
                ", risk='" + risk + '\'' +
                ", payee=" + payee +
                ", sum=" + sum +
                ", curr=" + curr +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
