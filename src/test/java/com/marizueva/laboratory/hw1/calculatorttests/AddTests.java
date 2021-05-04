package com.marizueva.laboratory.hw1.calculatorttests;

import com.marizueva.laboratory.hw1.calculatorttests.basetest.BaseTest;
import com.marizueva.laboratory.hw1.testdata.DataProviders;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddTests extends BaseTest {

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "sumOperations", groups = {"add_subtract"})
    public void addOperationWithLongTest(long a, long b, long result) {
        long sum = calculator.sum(a, b);

        assertThat(sum, CoreMatchers.equalTo(result));
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "sumOperationsWithDouble", groups = {"add_subtract"})
    public void addOperationWithDoubleTest(double a, double b, double result) {
        double sum = calculator.sum(a, b);

        assertThat(sum, CoreMatchers.equalTo(result));
    }
}
