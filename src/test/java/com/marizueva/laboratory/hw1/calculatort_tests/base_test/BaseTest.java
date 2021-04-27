package com.marizueva.laboratory.hw1.calculatort_tests.base_test;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseTest {
    protected Calculator calculator;

//    @BeforeClass
//    public void beforeClass() {
//        calculator = new Calculator();
//    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @BeforeGroups (groups = {"add_subtract", "divide_multiply"})
    public void setUpGroup() {
        calculator = new Calculator();
    }

    @AfterGroups  (groups = {"add_subtract", "divide_multiply"})
    public void tearDownGroup() {
        calculator = null;
    }

//    @AfterClass
//    public void afterClass() {
//        calculator = null;
//    }
}
