package page.widget;

import org.hillel.page.widget.SliderPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BasePageTest;

public class SliderPageTest extends BasePageTest {
    private SliderPage sliderPage;

    @Override
    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get("https://demoqa.com/slider");
        sliderPage=new SliderPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        sliderPage = null;
        super.tearDown();

    }

    @Test
    public void sliderTest() throws InterruptedException {
        int expected=76;
        sliderPage.setSliderValue(76);
        Thread.sleep(2000);
        int actual=sliderPage.getSliderValue();
        Thread.sleep(2000);
        Assert.assertEquals(actual,expected);
    }
}
