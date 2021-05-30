package com.marizueva.laboratory.hw6.jdisitepages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.marizueva.laboratory.hw6.entities.User;
import com.marizueva.laboratory.hw6.forms.LoginForm;

public class HomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    public Menu headerMenu;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void goToMetalAndColorPage() {
        headerMenu.select("Metals & Colors");
    }

}
