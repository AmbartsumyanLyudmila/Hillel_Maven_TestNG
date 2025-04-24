package org.hillel.page.widget;

import org.hillel.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    @FindBy(css=".range-slider")
    private WebElement inputSlider;

    @FindBy(id="sliderValue")
    private WebElement sliderValue;

    public SliderPage(WebDriver driver) {
        super(driver);
    }
    public void setSliderValue(int value){
        Actions actions=new Actions(driver);
        int width=inputSlider.getRect().getWidth();
        int xZero=inputSlider.getLocation().x;
        actions.clickAndHold(inputSlider)
                .moveToLocation(xZero, 0)
                .moveByOffset((int)(0.75*width),0)
                .perform();
//        slider.sendKeys(String.valueOf(value));
        inputSlider.sendKeys(String.valueOf(value));
    }
    public int getSliderValue(){
        String text=sliderValue.getDomAttribute("value");
        return  Integer.parseInt(text);
    }
}
