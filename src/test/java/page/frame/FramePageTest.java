package page.frame;

import org.hillel.page.BasePage;
import org.hillel.page.frame.FramePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BasePageTest;

import static org.testng.Assert.*;

public class FramePageTest extends BasePageTest {
    private FramePage framePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/frames");
        framePage= new FramePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        framePage=null;
    }

    @Test
    public void sampleHeaderTextTest(){
        String expected="This is a sample page";

        String actual=framePage.getFirstFrameHeaderText();
        System.out.println(actual);

        Assert. assertEquals(actual, expected);
    }
}