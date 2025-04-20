package org.hillel.page.element;

import org.hillel.page.BasePage;
import org.hillel.page.ElementUtils;
import org.hillel.page.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.Flushable;
import java.time.Duration;
import java.util.List;

public class TextBoxPage extends BasePage {
    @FindBy(css = Path.TEXT_BOX_FULL_NAME)
    private WebElement fullNameInput;
    @FindBy(css = Path.TEXT_BOX_EMAIL)
    private WebElement emailInput;
    @FindBy(css = Path.TEXT_BOX_CURRENT_ADDRESS)
    private WebElement currentAddressTextArea;
    @FindBy(css = Path.TEXT_BOX_PERMANENT_ADDRESS)
    private WebElement permanentAddressTextArea;
    @FindBy(css = Path.TEXT_BOX_SUBMIT_BUTTON)
    private WebElement submitButton;
    @FindBy(css = Path.TEXT_BOX_OUTPUT)
    private WebElement output;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public void fillFullNameInput(String value) {
        fullNameInput.clear();
        fullNameInput.sendKeys(value);

    }

    public void fillEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillInput(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void clickSubmitButton() {
        ElementUtils.clickWithScrollingToElement(submitButton,driver);


//        actions.scrollToElement(submitButton);
//        actions.click(submitButton);
//        actions.perform();

  //      submitButton.click();
    }

    public String getOutputText() {
        List<WebElement> outputs = output.findElements(By.cssSelector(".mb-1"));
        StringBuilder stringBuilder = new StringBuilder();
        for (WebElement output : outputs) {
            stringBuilder.append(output.getText());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
}
