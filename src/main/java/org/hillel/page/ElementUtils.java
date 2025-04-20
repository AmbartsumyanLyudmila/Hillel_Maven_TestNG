package org.hillel.page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ElementUtils {
    public static void clickWithScrollingToElement(WebElement element, WebDriver driver) {
        FluentWait<WebElement> wait = new FluentWait<>(element)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(ElementClickInterceptedException.class);
        Actions actions = new Actions(driver);

        wait.until(webElement -> {
                    actions.scrollByAmount(0, 100);
                    actions.perform(); //нужно указывать обязательно чтобы выполнились предыдущие actions
                    element.click();
                    return webElement;
                }
        );
    }
}
