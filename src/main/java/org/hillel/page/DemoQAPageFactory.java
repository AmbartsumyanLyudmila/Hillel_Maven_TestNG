package org.hillel.page;

import org.hillel.page.element.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoQAPageFactory {
    private static final WebDriver DRIVER=new ChromeDriver();
    private DemoQAPageFactory() {}

//    public static TextBoxPage getTextBoxPage() {
//        return PageFactory.initElements(DRIVER, TextBoxPage.class);
//    }
    public static <T extends BasePage> T getPage(Class<T> tClass){
        return PageFactory.initElements(DRIVER, tClass);
    }

    public static WebDriver getDriver() {
        return DRIVER;
    }
}
