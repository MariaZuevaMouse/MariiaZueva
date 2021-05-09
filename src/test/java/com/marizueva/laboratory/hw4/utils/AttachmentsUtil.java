package com.marizueva.laboratory.hw4.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AttachmentsUtil {

    @Attachment(type = "image/png", value = "try to use param {attName}")
    public static byte[] attachPngImage(byte[] source, String attName, WebDriver driver) {
        //        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return source;
    }

}
