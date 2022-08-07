package dev.rivaldi.userrestapi;

public class TaxPayer {

    Integer age;

    public TaxPayer(Integer age) {
        this.age = age;
    }

    public Integer calculateTax(int taxRate) {
        return age * taxRate;
    }
}
