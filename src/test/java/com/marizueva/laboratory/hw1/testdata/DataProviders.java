package com.marizueva.laboratory.hw1.testdata;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name= "sumOperations")
    public static Object[][] sumOperationData(){
        return new Object[][]{{0, 0, 0}, {5, 5, 10}, {-100, 100, 0}, {-5, -5, -10}};
    }

    @DataProvider(name= "sumOperationsWithDouble")
    public static Object[][] sumOperationDataDoubles(){
        return new Object[][]{{0.5, 0.5, 1}, {0.0007, 0.0003, 0.001}, {-0.777, 0.777, 0}};
    }

    @DataProvider(name= "subtractionOperations")
    public static Object[][] subtractionOperationData(){
        return new Object[][]{{0, 0, 0}, {10, 5, 5}, {-100, -100, 0}};
    }

    @DataProvider(name= "subtractionOperationsWithDouble")
    public static Object[][] subtractionOperationDataWithDouble(){
        return new Object[][]{{-0.5, -0.5, 0}, {-0.0007, 0.0007, -0.0014}, {5.6, 0.4, 5.2}};
    }

    @DataProvider(name= "divideOperations")
    public static Object[][] divideOperationData(){
        return new Object[][]{{5, 5, 1}, {0, 1, 0}, {-100, 5, -20}};
    }

    @DataProvider(name= "divideOperationsWithDouble")
    public static Object[][] divideOperationDataWithDouble(){
        return new Object[][]{{1, 0.1, 10}, {0.0, 1.0, 0.0}, {-100.01, 100.01, -1}};
    }

    @DataProvider(name= "multiplyOperations")
    public static Object[][] multiplyOperationData(){
        return new Object[][]{{0, 0, 0}, {5,5, 25}, {0, 1, 0}, {-1, 10, -10}};
    }

    @DataProvider(name= "multiplyOperationsWithDouble")
    public static Object[][] multiplyOperationWithDoubleData(){
        return new Object[][]{{0.0, 0.0, 0.0}, {0.5,0.5, 0.25}, {0.7, -0.2, -0.14}};
    }
}
