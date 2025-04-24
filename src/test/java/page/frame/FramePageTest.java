package page.frame;

import org.hillel.page.BasePage;
import org.hillel.page.MonobankPage;
import org.hillel.page.element.DynamicPropertiesPage;
import org.hillel.page.frame.FramePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BasePageTest;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;

public class FramePageTest extends BasePageTest {
    private FramePage framePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/frames");
        framePage = new FramePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        framePage = null;
    }

    @Test
    public void sampleHeaderTextTest() {
        String expected = "This is a sample page";

        //  String actual=framePage.getFirstFrameHeaderText();
        FramePage.SamplePage firstFrame = framePage.getFirstFrame();
        String actual = firstFrame.getHeaderText();
        System.out.println(actual);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void newTabTest() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://privatbank.ua/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://monobank.ua/en/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://epicentrk.ua/");

        Thread.sleep(3000);

        String testingPage = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            System.out.println(windowHandle);
            String title = driver.switchTo().window(windowHandle).getTitle();
            Thread.sleep(1000);
            if (title.toLowerCase().contains("monobank")) {
                MonobankPage monobankPage = new MonobankPage(driver);
                monobankPage.clickDepositButton();
//                DynamicPropertiesPage dynamicPropertiesPage=new DynamicPropertiesPage(driver);
//                dynamicPropertiesPage.moveToEnableAfterButton();
                break;
            }

        }
        Thread.sleep(2000);
        driver.switchTo().window(testingPage);
        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorTest() throws InterruptedException, IOException {
        driver.get("https://monobank.ua/");
        Thread.sleep(1000);
        if (driver instanceof JavascriptExecutor executor) {
            executor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
            Thread.sleep(2000);
//            executor.executeScript("alert('Hello from QA');");
//            Thread.sleep(2000);
        }
        if (driver instanceof TakesScreenshot screenshot) {
            File screen = screenshot.getScreenshotAs(OutputType.FILE);
            System.out.println(screen.getAbsolutePath());
            screen.renameTo(new File("src/main/resources/"+screen.getName()));
            System.out.println(screen.getAbsolutePath());
        }
    }
}