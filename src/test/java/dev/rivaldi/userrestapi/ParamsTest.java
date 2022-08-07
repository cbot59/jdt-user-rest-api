package dev.rivaldi.userrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamsTest {

    @ValueSource(ints = {5, 10, 15})
    @ParameterizedTest
    void calculateTax(int taxRate) {
        System.out.println("Angka dari taxRate = " + taxRate);

        TaxPayer taxPayer = new TaxPayer(20);

        Integer taxAmount = taxPayer.calculateTax(taxRate);

        assertTrue(taxAmount > 0);
    }

    @CsvSource({"5,100", "10,200", "15,300"})
    @ParameterizedTest
    void printInfo(int taxRate, int expected) {
        System.out.println("taxRate = " + taxRate + " expected = " + expected);

        TaxPayer taxPayer = new TaxPayer(20);

        Integer taxAmount = taxPayer.calculateTax(taxRate);

        assertTrue(taxAmount > 0);
        assertEquals(expected, taxAmount);
    }

    @CsvFileSource(resources = "/test-input.csv")
    @ParameterizedTest
    void printCsv(int taxRate, int expected) {
        System.out.println("CSV taxRate = " + taxRate + " expected = " + expected);

        TaxPayer taxPayer = new TaxPayer(20);

        Integer taxAmount = taxPayer.calculateTax(taxRate);

        assertTrue(taxAmount > 0);
        assertEquals(expected, taxAmount);
    }

    @RepeatedTest(3)
    void repeated() {
        System.out.println("Test ini dijalankan berulang");
    }
}
