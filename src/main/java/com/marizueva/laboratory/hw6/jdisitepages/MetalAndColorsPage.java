package com.marizueva.laboratory.hw6.jdisitepages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.marizueva.laboratory.hw6.entities.MetalAndColorData;
import com.marizueva.laboratory.hw6.forms.MetalAndColorForm;

import java.util.List;
import java.util.stream.Collectors;

public class MetalAndColorsPage extends WebPage {

    public MetalAndColorForm metalAndColorForm;

    @FindBy(css = ".results>li")
    public static WebList results;

    public List<String> getResultsInStrings() {
        return results.stream().map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public void fillInFormWithData(MetalAndColorData data) {
        metalAndColorForm.fill(data);
        metalAndColorForm.submit();
    }
}
