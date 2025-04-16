package org.hillel.page.element;

import org.hillel.page.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    private final WebElement fullNameInput;
    private WebElement emailInput;
    private WebElement currentAddressTextArea;
    private WebElement permanentAddressTextArea;
    private WebElement submitButton;

    public TextBoxPage(WebDriver driver) {
        this.fullNameInput=driver.findElement(By.cssSelector(Path.TEXT_BOX_FULL_NAME));
        this.emailInput=driver.findElement(By.cssSelector(Path.TEXT_BOX_EMAIL));
        this.currentAddressTextArea=driver.findElement(By.cssSelector(Path.TEXT_BOX_CURRENT_ADDRESS));
        this.permanentAddressTextArea=driver.findElement(By.cssSelector(Path.TEXT_BOX_PERMANENT_ADDRESS));
    }
    public void fillFullNameInput(String value){
        fullNameInput.clear();
        fullNameInput.sendKeys(value);

    }
    public void fillEmailInput(String email){
        emailInput.clear();
        emailInput.sendKeys(value);
    }
    public void fillInput (WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
