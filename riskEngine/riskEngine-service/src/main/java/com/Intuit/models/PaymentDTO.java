package com.Intuit.models;

import com.Intuit.models.enums.Currency;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Status;

    private String risk;

    private PayeeDTO payee;
    private double sum;
    private Currency curr;
    private PaymentMethodDTO paymentMethod;

    public PaymentDTO() {
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
