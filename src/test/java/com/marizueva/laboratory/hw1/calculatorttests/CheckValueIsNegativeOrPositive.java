package com.marizueva.laboratory.hw1.calculatorttests;

import com.marizueva.laboratory.hw1.calculatorttests.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckValueIsNegativeOrPositive extends BaseTest {

    @Test
    public void checkIsNegativeFalse() {
        boolean negative = calculator.isNegative(-0);

        assertThat(negative, CoreMatchers.is(false));
    }

    @Test
    public void checkIsNegativeTrue() {
        boolean negative = calculator.isNegative(-1);

        Assert.assertTrue(negative);
        assertThat(negative, CoreMatchers.is(true));
    }

    @Test
    public void checkIsPositiveFalse() {
        boolean negative = calculator.isPositive(-1);

        assertThat(negative, CoreMatchers.is(false));
    }

    @Test
    public void checkIsNotPositiveTrue() {
        boolean negative = calculator.isPositive(1);

        Assert.assertTrue(negative);
        assertThat(negative, CoreMatchers.is(true));
    }
}
