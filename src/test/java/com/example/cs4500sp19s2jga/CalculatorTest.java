package com.example.cs4500sp19s2jga;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.cs4500sp19s2jga.models.Calculator;

class CalculatorTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception { }

    @AfterAll
    static void tearDownAfterClass() throws Exception { }


    @AfterEach
    void tearDown() throws Exception { }

    Calculator calculator;

    @BeforeEach
    void setUp() throws Exception {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Failed State")
    @Disabled
    void testFail() {
        fail("fail!!!!");
    }
    
    @Test
    @DisplayName("2 + 2 = 4")
    void testTwoPlusTwo() {
        float expectedValue = 4.0f;
        float actualValue = calculator.add(2.0f, 2.0f);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    @DisplayName("1 / 3 = 0.3333")
    @Disabled
    void testOneOverThree() {
        float expected = 0.3333f;
        float actual = calculator.divide(1.0f, 3.0f);
        float delta = 0.33f;
        assertEquals(expected, actual, delta);
    }

}
