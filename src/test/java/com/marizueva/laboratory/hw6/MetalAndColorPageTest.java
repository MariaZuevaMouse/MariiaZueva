package com.marizueva.laboratory.hw6;

import com.epam.jdi.light.elements.complex.WebList;
import com.marizueva.laboratory.hw6.dataprovider.DataProviders;
import com.marizueva.laboratory.hw6.entities.MetalAndColorData;
import com.marizueva.laboratory.hw6.entities.User;
import com.marizueva.laboratory.hw6.jdisitepages.JdiSite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.marizueva.laboratory.hw6.jdisitepages.JdiSite.homePage;
import static com.marizueva.laboratory.hw6.jdisitepages.JdiSite.metalAndColorsPage;

public class MetalAndColorPageTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initElements(JdiSite.class);

    }

//    @Test(dataProviderClass = DataProviders.class, dataProvider = "metalAndColorDataSet")
    //public void testFillInDifferentValuesOnMetalAndColorPage(MetalAndColorData data)
    @Test
    public void testFillInDifferentValuesOnMetalAndColorPage() {
        JdiSite.open();
        JdiSite.performLogin(User.ROMAN);
        homePage.goToMetalAndColorPage();
//        System.out.println(data.toString());

//        metalAndColorsPage.metalAndColorForm.
        metalAndColorsPage.metalAndColorForm.summeryEvenRadio.select("4");
        metalAndColorsPage.metalAndColorForm.summeryOddRadio.select("3");
        WebList list = metalAndColorsPage.metalAndColorForm.elementsCheckList.list();
                System.out.println(list);

                metalAndColorsPage.metalAndColorForm.elementsCheckList.select("Water", "Fire");
                metalAndColorsPage.metalAndColorForm.elementsCheckList.select(3);
                metalAndColorsPage.metalAndColorForm.metalDropdown.select("Gold");
                metalAndColorsPage.metalAndColorForm.colorDropdown.select("Green");
                metalAndColorsPage.metalAndColorForm.vegetablesDropdown.expand();
                metalAndColorsPage.metalAndColorForm.vegetablesDropdown.select("Cucumber", "Onion");
                metalAndColorsPage.metalAndColorForm.vegetablesDropdown.select("Vegetables");

                metalAndColorsPage.metalAndColorForm.submitButton.click();

        JdiSite.logoutUser();
    }
}
