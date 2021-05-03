package com.marizueva.laboratory.hw3.voidpageobject.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPageElements extends BasePage {
    ServiceDifferentElementPage serviceDifferentElementPage;

    @FindBy(xpath = "//li[@class='dropdown uui-profile-menu']//span[@class='caret'][1]")
    protected WebElement openLoginDropdownButton;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::input[@id='name']")
    protected WebElement loginField;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::input[@id='password']")
    protected WebElement passwordField;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::span[text()='Enter']")
    protected WebElement enterCredentials;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::span[@id='user-name']")
    WebElement loggedUserName;

    @FindBy(xpath = "//header//ul/li/a[@href='index.html'][1]")
    WebElement headerItemHome;

    @FindBy(xpath = "//header//ul/li[2]/a[1]")
    WebElement headerItemContact;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle'][1]")
    WebElement headerItemService;

    @FindBy(xpath = "//header//ul/li/a[@href='metals-colors.html'][1]")
    WebElement headerItemMetalAndColor;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']")
    WebElement leftSection;

    @FindBy(xpath = "/html/body/footer")
    WebElement pageFooter;


    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li/"
            + "a[text()='Support']")
    WebElement subMenuFromHeaderSupportItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Dates']")
    WebElement subMenuFromHeaderDatesItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Search']")
    WebElement subMenuFromHeaderSearchItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li"
            + "/a[@href='complex-table.html']")
    WebElement subMenuFromHeaderComplexTableItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li"
            + "/a[@href='simple-table.html']")
    WebElement subMenuFromHeaderSimpleTableItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li"
            + "/a[@href='user-table.html']")
    WebElement subMenuFromHeaderUserTableItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']/li"
            + "/a[@href='table-pages.html']")
    WebElement subMenuFromHeaderTableWithPagesItem;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
            + "/following-sibling::ul[@class='dropdown-menu']"
            + "/li/a[@href='different-elements.html']")
    WebElement subMenuFromHeaderDifferentElementsItem;

    @FindBy(css = "ul.sidebar-menu.left >li[index='3']")
    WebElement leftServiceMenu;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//span[text()='Support']")
    WebElement subMenuFromLeftSupportItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//span[text()='Dates']")
    WebElement subMenuFromLeftDatesItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//span[text()='Search']")
    WebElement subMenuFromLeftSearchItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//a[@href='complex-table.html']")
    WebElement subMenuFromLeftComplexTableItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//a[@href='simple-table.html']")
    WebElement subMenuFromLeftSimpleTableItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//a[@href='user-table.html']")
    WebElement subMenuFromLeftUserTableItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']"
            + "//a[@href='table-pages.html']")
    WebElement subMenuFromLeftTableWithPagesItem;

    @FindBy(xpath = "//div[@name='navigation-sidebar']"
            + "//a[@href='different-elements.html']")
    WebElement subMenuFromLeftDifferentElementsItem;

    public ServiceDifferentElementPage getServiceDifferentElementPage() {
        return serviceDifferentElementPage;
    }

    public CommonPageElements(WebDriver driver) {
        super(driver);

    }

    public String getHeaderItem(HeaderItems headerItem) {

        switch (headerItem) {
            case HOME:
                return headerItemHome.getText();

            case CONTACT_FORM:
                return headerItemContact.getText();

            case SERVICE:
                return headerItemService.getText();

            case METAL_AND_COLORS:
                return headerItemMetalAndColor.getText();

            default:
                throw new NotFoundException("There is no such tab" + headerItem);

        }
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return pageFooter;
    }


    public void clickServiceItemFromHeader() {
        headerItemService.click();

    }

    public WebElement getSubMenuServiceItemFromHeader(ServicesSubCategories subCategories) {
        switch (subCategories) {
            case SUPPORT:
                return subMenuFromHeaderSupportItem;
            case DATES:
                return subMenuFromHeaderDatesItem;
            case SEARCH:
                return subMenuFromHeaderSearchItem;
            case COMPLEX_TABLE:
                return subMenuFromHeaderComplexTableItem;
            case SIMPLE_TABLE:
                return subMenuFromHeaderSimpleTableItem;
            case USER_TABLE:
                return subMenuFromHeaderUserTableItem;
            case TABLE_WITH_PAGES:
                return subMenuFromHeaderTableWithPagesItem;
            case DIFFERENT_ELEMENT:
                return subMenuFromHeaderDifferentElementsItem;
            default:
                throw new NotFoundException("element not found:" + subCategories);
        }
    }

    public WebElement getSubMenuServiceItemFromLeftMenu(ServicesSubCategories subCategories) {
        switch (subCategories) {
            case SUPPORT:
                return subMenuFromLeftSupportItem;
            case DATES:
                return subMenuFromLeftDatesItem;
            case SEARCH:
                return subMenuFromLeftSearchItem;
            case COMPLEX_TABLE:
                return subMenuFromLeftComplexTableItem;
            case SIMPLE_TABLE:
                return subMenuFromLeftSimpleTableItem;
            case USER_TABLE:
                return subMenuFromLeftUserTableItem;
            case TABLE_WITH_PAGES:
                return subMenuFromLeftTableWithPagesItem;
            case DIFFERENT_ELEMENT:
                return subMenuFromLeftDifferentElementsItem;
            default:
                throw new NotFoundException("element not found:" + subCategories);
        }
    }

    public void clickServiceItemFromLeftSection() {
        leftServiceMenu.click();

    }

    public ServiceDifferentElementPage goToDifferentElementPageFromHeader() {
        clickServiceItemFromHeader();
        subMenuFromHeaderDifferentElementsItem.click();
        return new ServiceDifferentElementPage(driver);
    }
}
