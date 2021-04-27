package com.marizueva.laboratory.hw1.calculatort_tests;

import com.epam.tat.module4.Calculator;
import com.marizueva.laboratory.hw1.calculatort_tests.base_test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckValueIsNegativeOrPositive extends BaseTest {

    @Test
    public void checkIsNegativeFalse() {
        boolean negative = calculator.isNegative(-0);

        Assert.assertFalse(negative);
    }

    @Test
    public void checkIsNegativeTrue() {
        boolean negative = calculator.isNegative(-1);

        Assert.assertTrue(negative);
    }

    @Test
    public void checkIsPositiveFalse() {
        boolean negative = calculator.isPositive(-1);

        Assert.assertFalse(negative);
    }

    @Test
    public void checkIsNPositiveTrue() {
        boolean negative = calculator.isPositive(1);

        Assert.assertTrue(negative);
    }
}
