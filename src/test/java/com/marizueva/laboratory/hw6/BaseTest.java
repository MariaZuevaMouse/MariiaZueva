package com.marizueva.laboratory.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.marizueva.laboratory.hw6.jdisitepages.JdiSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        initElements(JdiSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
