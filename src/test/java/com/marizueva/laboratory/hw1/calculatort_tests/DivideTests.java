package com.marizueva.laboratory.hw1.calculatort_tests;

import com.marizueva.laboratory.hw1.calculatort_tests.base_test.BaseTest;
import com.marizueva.laboratory.hw1.testdata.DataProviders;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class DivideTests extends BaseTest {

    @Test( dataProviderClass = DataProviders.class,dataProvider = "divideOperations", groups = {"divide_multiply"})
    public void divideOperationTest(long a, long b, long result) {
        long div = calculator.div(a, b);

        assertThat(div, CoreMatchers.is(result));
    }

    @Test( dataProviderClass = DataProviders.class,dataProvider = "divideOperationsWithDouble", groups = {"divide_multiply"})
    public void divideOperationWithDoubleTest(double a, double b, double result) {
        double div = calculator.div(a, b);

        assertThat(div, CoreMatchers.is(result));
    }
}
