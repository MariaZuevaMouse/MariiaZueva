package com.marizueva.laboratory.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.marizueva.laboratory.hw6.jdisitepages.JdiSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initElements(JdiSite.class);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
