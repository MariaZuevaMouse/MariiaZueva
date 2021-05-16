package com.marizueva.laboratory.hw6;

import com.marizueva.laboratory.hw6.dataprovider.DataProviders;
import com.marizueva.laboratory.hw6.entities.MetalAndColorData;
import com.marizueva.laboratory.hw6.entities.User;
import com.marizueva.laboratory.hw6.jdisitepages.JdiSite;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.marizueva.laboratory.hw6.jdisitepages.JdiSite.homePage;
import static com.marizueva.laboratory.hw6.jdisitepages.JdiSite.metalAndColorsPage;

public class MetalAndColorPageTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "metalAndColorDataSet")
    public void testFillInDifferentValuesOnMetalAndColorPage(MetalAndColorData data) {
        JdiSite.open();
        JdiSite.performLogin(User.ROMAN);
        homePage.goToMetalAndColorPage();

        metalAndColorsPage.fillInFormWithData(data);

        List<String> actualResultsInStrings = metalAndColorsPage.getResultsInStrings();
        List<String> expectedResultsInString = getExpectedResultInString(data);
        System.out.println("actual:" + actualResultsInStrings);
        System.out.println("expected" + expectedResultsInString);

        Assert.assertTrue(actualResultsInStrings.containsAll(expectedResultsInString),
                "results lists are different");
        JdiSite.logoutUser();
    }

    private List<String> getExpectedResultInString(MetalAndColorData data) {
        List<String> result = new ArrayList<>();
        result.add("Summary: " + (Integer.parseInt(data.getSummary()[0])
                + Integer.parseInt(data.getSummary()[1])));
        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetal());

        String elementsString = "Elements: ";
        for (int i = 0; i < data.getElements().length; i++) {
            elementsString = elementsString + data.getElements()[i] + ", ";
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));

        String vegetableString = "Vegetables: ";
        for (int i = 0; i < data.getVegetables().length; i++) {
            vegetableString = vegetableString + data.getVegetables()[i] + ", ";
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        return result;
    }
}

//        metalAndColorsPage.metalAndColorForm.summeryEvenRadio.select("4");
//        metalAndColorsPage.metalAndColorForm.summeryOddRadio.select("3");
//        WebList list = metalAndColorsPage.metalAndColorForm.elementsCheckList.list();
//        System.out.println(list);
//
//        metalAndColorsPage.metalAndColorForm.elementsCheckList.select("Water", "Fire");
//        metalAndColorsPage.metalAndColorForm.elementsCheckList.select(3);
//        metalAndColorsPage.metalAndColorForm.metalDropdown.select("Gold");
//        metalAndColorsPage.metalAndColorForm.colorDropdown.select("Green");
//        metalAndColorsPage.metalAndColorForm.vegetablesDropdown.expand();
//        metalAndColorsPage.metalAndColorForm.vegetablesDropdown.select("Cucumber", "Onion");
//        metalAndColorsPage.metalAndColorForm.vegetablesDropdown.select("Vegetables");
//
//        metalAndColorsPage.metalAndColorForm.submitButton.click();