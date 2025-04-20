package page.element;

import org.hillel.page.DemoQAPageFactory;
import org.hillel.page.element.TextBoxPage;
import org.hillel.page.form.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.BasePageTest;

import java.awt.image.CropImageFilter;
import java.time.Duration;

public class TextBoxPageTest extends BasePageTest {
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        textBoxPage = null;
        super.tearDown();

    }

    @Test
    public void fullNameFieldTest() {
        String input = "Mike";
        String expected = "Mike";

        textBoxPage.fillFullNameInput(input);
        textBoxPage.fillEmailInput("email@email.com");
        textBoxPage.clickSubmitButton();
        String actual = textBoxPage.getOutputText();
        System.out.println(actual);

        Assert.assertTrue(actual.contains(expected));
    }
}
