package com.Intuit.models;

import com.Intuit.models.enums.PaymentMethodType;

import java.io.Serializable;
import java.util.Objects;

public class PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String last4Digits ;
    private String bank;
    private String account;
    private PaymentMethodType type;

    private String ID;

    public PaymentMethod(String firstName, String lastName, String last4Digits, String bank, String account, PaymentMethodType type, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.last4Digits = last4Digits;
        this.bank = bank;
        this.account = account;
        this.type = type;
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(last4Digits, that.last4Digits) && Objects.equals(bank, that.bank) && Objects.equals(account, that.account) && type == that.type && Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, last4Digits, bank, account, type, ID);
    }

    @Override
    public String toString() {
        return "PaymentMethodDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", last4Digits='" + last4Digits + '\'' +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", type=" + type +
                ", ID='" + ID + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PaymentMethodType getType() {
        return type;
    }

    public void setType(PaymentMethodType type) {
        this.type = type;
    }
}
