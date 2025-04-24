package org.hillel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v133.page.Page;
import org.openqa.selenium.support.PageFactory;

//class or interface marker
public abstract class BasePage {
    protected WebDriver driver;
    protected String titlePage;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    protected BasePage(WebDriver driver, String titlePage) {
        this(driver);
        this.titlePage = titlePage;
        validatePage();
    }

    protected void validatePage() {
        String title = driver.getTitle();

    }
    public WebDriver getDriver(){
        return driver;
    }
}
