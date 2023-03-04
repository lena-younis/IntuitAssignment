package com.Intuit.models;

import java.io.Serializable;
import java.util.Objects;

public class Payee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ID;
    private String firstName;
    private String lastName;
    private String address;
    private String bankName;
    private String branch;
    private String account;

    public Payee(String firstName, String lastName, String address, String bankName, String branch, String account , String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.bankName = bankName;
        this.branch = branch;
        this.account = account;
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payee payeeDTO = (Payee) o;
        return Objects.equals(ID, payeeDTO.ID) && Objects.equals(firstName, payeeDTO.firstName) && Objects.equals(lastName, payeeDTO.lastName) && Objects.equals(address, payeeDTO.address) && Objects.equals(bankName, payeeDTO.bankName) && Objects.equals(branch, payeeDTO.branch) && Objects.equals(account, payeeDTO.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, address, bankName, branch, account);
    }

    @Override
    public String toString() {
        return "PayeeDTO{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", account='" + account + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
