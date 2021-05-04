package com.marizueva.laboratory.hw1.calculatorttests.basetest;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
