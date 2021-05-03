package com.marizueva.laboratory.hw3.testdata;

import com.marizueva.laboratory.hw3.fluentpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.ServiceDifferentElementPage;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.ServicesSubCategories;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "headerItems")
    public static Object[][] headerItems() {
        return new Object[][]{{"HOME"}, {"CONTACT FORM"}, {"SERVICE"}, {"METALS & COLORS"}};
    }

    @DataProvider(name = "headerItemsEn")
    public static Object[][] headerItemsFromEnum() {
        return new Object[][]{
            {HeaderItems.HOME},
            {HeaderItems.CONTACT_FORM},
            {HeaderItems.SERVICE},
            {HeaderItems.METAL_AND_COLORS}};
    }

    @DataProvider(name = "headerItemsFromEnum")
    public static Object[][] headerItemsFromEnum2() {
        return new Object[][]{
                {HeaderItems.HOME},
                {HeaderItems.CONTACT_FORM},
                {HeaderItems.SERVICE},
                {HeaderItems.METAL_AND_COLORS}};
    }

    @DataProvider(name = "benefitIconsTextIndex")
    public static Object[][] benefitIconsTextIndex() {
        return new Object[][]{{1}, {2}, {3}, {4}};
    }

    @DataProvider(name = "servicesSubCategories")
    public static Object[][] servicesSubCategories() {

        return new Object[][] {
                {ServicesSubCategories.SUPPORT},
                {ServicesSubCategories.DATES},
                {ServicesSubCategories.COMPLEX_TABLE},
                {ServicesSubCategories.SIMPLE_TABLE},
                {ServicesSubCategories.TABLE_WITH_PAGES},
                {ServicesSubCategories.DIFFERENT_ELEMENT}
        };
    }


    @DataProvider(parallel = true, name = "servicesSubCategoriesData")
    public static Object[][] servicesSubCategoriesData() {
        return new Object[][] {
                {ServicesSubCategories.SUPPORT},
                {ServicesSubCategories.DATES},
                {ServicesSubCategories.COMPLEX_TABLE},
                {ServicesSubCategories.SIMPLE_TABLE},
                {ServicesSubCategories.TABLE_WITH_PAGES},
                {ServicesSubCategories.DIFFERENT_ELEMENT}
        };
    }

    @DataProvider(name = "checkElementsOnDifferentElementPage")
    public static Object[][] checkElementsOnDifferentElementPage() {
        return new Object[][]{{ServiceDifferentElementPage.ElementType.CHECKBOXES, 4},
            {ServiceDifferentElementPage.ElementType.RADIO_BUTTONS, 4},
            {ServiceDifferentElementPage.ElementType.DROPDOWN_MENU, 1}};
    }


}
