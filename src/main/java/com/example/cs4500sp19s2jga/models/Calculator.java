package com.example.cs4500sp19s2jga.models;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public float add(float a, float b) {
        return a + b;
    }
    public float divide(float a, float b) {
        return a / b;
    }
}
