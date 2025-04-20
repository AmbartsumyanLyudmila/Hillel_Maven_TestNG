package org.hillel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v133.page.Page;
import org.openqa.selenium.support.PageFactory;

//class or interface marker
public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
