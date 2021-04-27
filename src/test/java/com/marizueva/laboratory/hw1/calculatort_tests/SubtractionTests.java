package com.marizueva.laboratory.hw1.calculatort_tests;

import com.marizueva.laboratory.hw1.calculatort_tests.base_test.BaseTest;
import com.marizueva.laboratory.hw1.testdata.DataProviders;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SubtractionTests extends BaseTest {

    @Test( dataProviderClass = DataProviders.class,dataProvider = "subtractionOperations", groups = {"add_subtract"})
    public void subtractOperationWithLongTest(long a, long b, long result) {
        long subt = calculator.sub(a,b);

        assertThat(subt, CoreMatchers.is(result));
    }

    @Test( dataProviderClass = DataProviders.class,dataProvider = "subtractionOperationsWithDouble", groups = {"add_subtract"})
    public void subtractOperationWithDoubleTest(double a, double b, double result) {
        double subt = calculator.sub(a,b);

        assertThat(subt, CoreMatchers.is(result));
    }
}
