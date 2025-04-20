package org.hillel.page.element;

import org.hillel.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage {
    @FindBy(css="#enableAfter")
    private WebElement enableAfterButton;

    public DynamicPropertiesPage(WebDriver driver){
        super(driver);
    }
    public String getBackgroundColorEnableAfterButton(){
        return enableAfterButton.getCssValue("background-color");
    }
    public void moveToEnableAfterButton(){
        Actions actions =new Actions(driver);

        actions.moveToElement(enableAfterButton).perform();
    }
    public void waitEnableAfterButtonToBeClickable(){
        FluentWait<WebDriver> wait =new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfterButton));
    }
}
