package page.element;

import org.hillel.page.element.DynamicPropertiesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BasePageTest;

import java.time.Duration;

public class DynamicPropertiesPageTest extends BasePageTest {
    private DynamicPropertiesPage page;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/dynamic-properties");
        page=new DynamicPropertiesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        page=null;
    }

    @Test
    public void enableAfterButtonBackgroundColor() throws InterruptedException {

        page.waitEnableAfterButtonToBeClickable();
        String beforeHover=page.getBackgroundColorEnableAfterButton();
        page.moveToEnableAfterButton();
        String afterHover=page.getBackgroundColorEnableAfterButton();


        Assert.assertNotEquals(beforeHover, afterHover);

    }
}