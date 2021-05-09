package com.marizueva.laboratory.hw4.voidpageobject.tests.listener;

import com.marizueva.laboratory.hw4.utils.AttachmentsUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        
        AttachmentsUtil.attachPngImage(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES),
                "error.png", driver);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " PASSED !!!  \n\n");
    }

}
