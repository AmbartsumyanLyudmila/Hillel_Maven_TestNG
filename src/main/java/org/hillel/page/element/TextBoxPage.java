package org.hillel.page.element;

import org.hillel.page.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage {
    private final WebElement fullNameInput;
    private  WebElement emailInput;
    private WebElement currentAddressTextArea;
    private WebElement permanentAddressTextArea;
    private WebElement submitButton;
    private WebElement output;

    public TextBoxPage(WebDriver driver) {
        this.fullNameInput=driver.findElement(By.cssSelector(Path.TEXT_BOX_FULL_NAME));
        this.emailInput=driver.findElement(By.cssSelector(Path.TEXT_BOX_EMAIL));
        this.currentAddressTextArea=driver.findElement(By.cssSelector(Path.TEXT_BOX_CURRENT_ADDRESS));
        this.permanentAddressTextArea=driver.findElement(By.cssSelector(Path.TEXT_BOX_PERMANENT_ADDRESS));
        this.output=driver.findElement(By.cssSelector(Path.TEXT_BOX_OUTPUT));
    }
    public void fillFullNameInput(String value){
        fullNameInput.clear();
        fullNameInput.sendKeys(value);

    }
    public void fillEmailInput(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void fillInput (WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public String getOutputText(){
       List<WebElement> outputs = output.findElements(By.cssSelector(".mb-1"));
       StringBuilder stringBuilder=new StringBuilder();
       for (WebElement output:outputs){
           stringBuilder.append(output.getText());
           stringBuilder.append("/n");

        }
       return stringBuilder.toString();
    }
}
