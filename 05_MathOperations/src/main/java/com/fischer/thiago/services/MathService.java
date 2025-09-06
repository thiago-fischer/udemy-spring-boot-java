package com.fischer.thiago.services;

import com.fischer.thiago.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        validate(numberOne, numberTwo);
        return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        validate(numberOne, numberTwo);
        return Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        validate(numberOne, numberTwo);
        return Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        validate(numberOne, numberTwo);
        if (numberTwo.equals("0")) throw new UnsupportedMathOperationException("Impossible divide by zero, set a valid number!");
        return Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) {
        validate(numberOne, numberTwo);
        return (Double.parseDouble(numberOne) + Double.parseDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        validate(number);
        return Math.sqrt(Double.parseDouble(number));
    }


    private void validate(String... numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }
        }

    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        if (number.isEmpty()) return false;
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
