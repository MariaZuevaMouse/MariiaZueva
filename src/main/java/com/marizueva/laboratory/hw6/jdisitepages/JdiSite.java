package com.marizueva.laboratory.hw6.jdisitepages;


import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.marizueva.laboratory.hw6.entities.User;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("index.html")@Title("Home Page")
    public static HomePage homePage;

    @Url("metals-colors.html")@Title("Metal and Colors")
    public static MetalAndColorsPage metalAndColorsPage;

    @FindBy(css = "li.dropdown.uui-profile-menu")
    public static UIElement loggedUser;

    @FindBy(css = ".logout")
    public static Button logoutButton;

    public static void open() {
        homePage.open();
    }

    public static void performLogin(User user) {
        homePage.login(user);
    }

    public static void logoutUser() {
        loggedUser.click();
        logoutButton.click();
    }

}
