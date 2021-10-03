package com.example.java;

public interface Calculator <T extends Number> {
    double calculateFees(T clubID);

}
