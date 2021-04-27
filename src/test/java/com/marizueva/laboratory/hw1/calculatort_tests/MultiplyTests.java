package com.marizueva.laboratory.hw1.calculatort_tests;

import com.marizueva.laboratory.hw1.calculatort_tests.base_test.BaseTest;
import com.marizueva.laboratory.hw1.testdata.DataProviders;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MultiplyTests extends BaseTest {

    @Test( dataProviderClass = DataProviders.class,dataProvider = "multiplyOperations", groups = {"divide_multiply"})
    public void multiplyOperationWithLongTest(long a, long b, long result) {
        long mult = calculator.mult(a,b);

        assertThat(mult, CoreMatchers.is(result));
    }

    @Test( dataProviderClass = DataProviders.class,dataProvider = "multiplyOperationsWithDouble", groups = {"divide_multiply"})
    public void multiplyOperationWithDoubleTest(double a, double b, double result) {
        double mult = calculator.mult(a, b);

        assertThat(mult, CoreMatchers.is(result));
    }
}
