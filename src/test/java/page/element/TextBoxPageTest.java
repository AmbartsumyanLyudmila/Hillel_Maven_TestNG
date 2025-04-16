package page.element;

import org.hillel.page.element.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TextBoxPageTest {
    private TextBoxPage textBoxPage;
    private WebDriver driver;

   @BeforeMethod
    public void setUp(){
       driver= new ChromeDriver();
       driver.get("https://demoqa.com/text-box");
       driver.manage().window().maximize();
       textBoxPage=new TextBoxPage(driver);

   }
   @AfterMethod
   public void tearDown(){
       textBoxPage=null;
       driver.quit();

   }
   @Test
   public void  fullNameFieldTest(){
       String input ="Mike";
       String expected="Mike";

       textBoxPage.fillFullNameInput(input);
       textBoxPage.fillEmailInput("email@email.com");
       textBoxPage.clickSubmitButton();
       String actual= textBoxPage.getOutputText();
       System.out.println(actual);
       Assert.assertTrue(actual.contains(expected));
   }
}
