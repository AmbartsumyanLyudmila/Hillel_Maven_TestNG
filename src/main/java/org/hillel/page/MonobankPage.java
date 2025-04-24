package org.hillel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonobankPage extends BasePage{

    @FindBy(css="a[href=\"deposit\"]")
    private WebElement depositButton;

    public MonobankPage(WebDriver driver) {
        super(driver, "monobank");

    }
    public void clickDepositButton(){
        depositButton.click();
    }

}
